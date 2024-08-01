package com.yesko.project.order;

import java.io.Serializable;

public enum PaymentMethod implements Serializable {

    PAYPAL,
    CREDIT_CARD,
    VISA,
    MASTER_CARD,
    BITCOIN
}