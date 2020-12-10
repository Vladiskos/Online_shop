package com.java.automation.lab.fall.cehanovich.core22.domain.enums;

public enum Currency {
    USD("USD","U.S. dollar"),
    EUR("EUR","Euro"),
    BYN("BYN","Belarusian ruble"),
    RUB("RUB","Russian ruble"),
    UAH("UAH","Hryvnia"),
    PLN("PLN","Zloty");

    private String description;
    private String currency;

    Currency(String currency, String description) {
        this.currency = currency;
        this.description = description;
    }

    @Override
    public String toString() {
        return "'" + description + " " + currency + "'";
    }
}
