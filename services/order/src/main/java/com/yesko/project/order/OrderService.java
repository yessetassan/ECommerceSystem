package com.yesko.project.order;

import com.yesko.project.customer.CustomerClient;
import com.yesko.project.dto.order.OrderCreateRequest;
import com.yesko.project.dto.order.OrderMapper;
import com.yesko.project.dto.order.OrderResponse;
import com.yesko.project.dto.product.PurchaseRequest;
import com.yesko.project.dto.product.PurchaseResponse;
import com.yesko.project.exception.BusinessException;
import com.yesko.project.orderline.OrderLine;
import com.yesko.project.orderline.OrderLineMapper;
import com.yesko.project.orderline.OrderLineRepository;
import com.yesko.project.product.ProductClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    private final OrderRepository repository;
    private final OrderLineRepository orderLineRepository;

    private final OrderMapper mapper;
    private final OrderLineMapper orderLineMapper;
    @Transactional
    public OrderResponse createOrder(OrderCreateRequest request) {
        var customer = this.customerClient.findCustomerByToken(request.getToken());
        log.info("Customer is {}", customer);
//        var purchaseResponses = productClient.purchaseProducts(request.getPurchaseRequests());
//
//        var order = repository.save(mapper.toOrder(request));
//
//        for (PurchaseResponse purchaseResponse : purchaseResponses) {
//            orderLineRepository.save(orderLineMapper.toOrderLine(purchaseResponse,order));
//        }

        return null;
    }
}
