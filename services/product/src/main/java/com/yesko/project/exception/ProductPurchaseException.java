package com.yesko.project.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ProductPurchaseException extends RuntimeException {
    public ProductPurchaseException(String s) {
        super(s);
    }
}
