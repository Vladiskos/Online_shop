package com.java.automation.lab.fall.cehanovich.core22.domain.enums;

public enum Currency {
    USD("U.S. dollar"),
    EUR("Euro"),
    BYN("Belarusian ruble"),
    RUB("Russian ruble"),
    UAH("Hryvnia"),
    PLN("Zloty");

    private String description;

    Currency(String description) {
        this.description = description;
    }
}
