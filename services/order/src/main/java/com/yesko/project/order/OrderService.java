package com.yesko.project.order;

import com.yesko.project.customer.CustomerClient;
import com.yesko.project.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final CustomerClient customerClient;
    public Integer createOrder(OrderRequest request) {
        try {
            var customer = this.customerClient.findCustomerById(request.customerId())
                    .orElseThrow(() -> new BusinessException("Can not create order:: No Customer exists with the provided ID"));
            log.info("Customer is {}", customer);

        } catch (BusinessException e) {
            log.error("Business exception occurred: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Can not create order:: No Customer exists with the provided ID");
        }
        return null;
    }
}
