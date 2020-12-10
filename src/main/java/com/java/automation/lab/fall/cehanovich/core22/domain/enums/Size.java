package com.java.automation.lab.fall.cehanovich.core22.domain.enums;

public enum Size {
    XXS(32, 40, "XXS"),
    XS(34, 42, "XS"),
    S(36, 44, "S"),
    M(38, 46, "M"),
    L(40, 48, "L"),
    XL(42, 50, "XL"),
    XXL(44, 52, "XXL"),
    XXXL(46, 54, "XXXL");

    private int europeanSize;
    private int russianSize;
    private String size;

    Size(int europeanSize, int russianSize, String size) {
        this.europeanSize = europeanSize;
        this.russianSize = russianSize;
        this.size = size;
    }

    @Override
    public String toString() {
        return "'" + europeanSize + " " + russianSize + " " + size + "'";
    }
}
