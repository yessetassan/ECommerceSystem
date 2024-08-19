package com.yesko.project.order;

import com.yesko.project.customer.CustomerClient;
import com.yesko.project.dto.customer.UserResponse;
import com.yesko.project.dto.order.OrderCreateRequest;
import com.yesko.project.dto.order.OrderMapper;
import com.yesko.project.dto.product.PurchaseResponse;
import com.yesko.project.exception.BusinessException;
import com.yesko.project.handler.AppError;
import com.yesko.project.kafka.OrderConfirmation;
import com.yesko.project.kafka.OrderProducer;
import com.yesko.project.orderline.OrderLineMapper;
import com.yesko.project.orderline.OrderLineRepository;
import com.yesko.project.product.ProductClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderProducer orderProducer;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    private final OrderRepository repository;
    private final OrderLineRepository orderLineRepository;

    private final OrderMapper mapper;
    private final OrderLineMapper orderLineMapper;

    @Transactional
    public ResponseEntity<?> createOrder(OrderCreateRequest request) {

        if (repository.findByReference(request.getReference()).isPresent())
            throw new BusinessException("Reference уже существует...");

        var user = this.customerClient.findCustomerByToken(request.getToken());
        var purchaseResponses = productClient.purchaseProducts(request.getPurchaseRequests());
        log.info("Пользователь :: {} сделал покупки::{}",  user,purchaseResponses);

        var order = generateOrder(request, user, purchaseResponses);
        log.info("У пользователя:: {} заказ:: {}", user, order);

        for (PurchaseResponse purchaseResponse : purchaseResponses) {
            orderLineRepository.save(orderLineMapper.toOrderLine(purchaseResponse,order, user));
        }

        orderProducer.sendOrderConfirmation(createOrderConfirmation(order, user,purchaseResponses));
        return ResponseEntity.ok().body(mapper.toOrderResponse(order));
    }
    private OrderConfirmation createOrderConfirmation(Order order, UserResponse user, List<PurchaseResponse> purchaseResponses) {
        return OrderConfirmation.builder()
                .orderReference(order.getReference())
                .totalAmount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .userResponse(user)
                .products(purchaseResponses)
                .build();

    }

    private Order generateOrder(OrderCreateRequest request, UserResponse user, List<PurchaseResponse> purchaseResponses) {
        BigDecimal totalAmount = purchaseResponses
                .stream()
                .map(purchase -> purchase.getPrice().multiply(BigDecimal.valueOf(purchase.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return repository.save(mapper.toOrder(request, user, totalAmount));
    }
}
