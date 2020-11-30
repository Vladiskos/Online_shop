package com.java.automation.lab.fall.cehanovich.core22.domain.enums;

public enum PaymentType {
    ON_SPOT("Payment at the place of delivery or at the store"),
    ONLINE("Payment by card online");

    private String description;

    PaymentType(String description) {
        this.description = description;
    }
}
