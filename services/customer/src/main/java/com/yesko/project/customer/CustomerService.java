package com.yesko.project.customer;


import com.yesko.project.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerResponse createCustomer(CustomerRequest request) {
        var customer = this.repository.save(mapper.toCustomer(request));
        return mapper.toCustomerResponse(customer);
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = this.repository.findById(request.getId())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", request.getId())
                ));
        mergeCustomer(customer, request);
        this.repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.getFirstname())) {
            customer.setFirstname(request.getFirstname());
        }
        if (StringUtils.isNotBlank(request.getEmail())) {
            customer.setEmail(request.getEmail());
        }
        if (request.getAddress() != null) {
            customer.setAddress(request.getAddress());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return  this.repository.findAll()
                .stream()
                .map(this.mapper::toCustomerResponse)
                .collect(Collectors.toList());
    }

    public CustomerResponse findById(String id) {
        return this.repository.findById(id)
                .map(mapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", id)));
    }

    public CustomerResponse findByIdMic(String id) {
        return this.repository.findById(id)
                .map(mapper::toCustomerResponse)
                .orElse(null);
    }



    public boolean existsById(String id) {
        return this.repository.findById(id)
                .isPresent();
    }

    public void deleteCustomer(String id) {
        this.repository.deleteById(id);
    }
}