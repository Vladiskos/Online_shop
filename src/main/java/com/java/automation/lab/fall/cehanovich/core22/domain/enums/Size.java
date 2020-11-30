package com.java.automation.lab.fall.cehanovich.core22.domain.enums;

public enum Size {
    XXS(32, 40),
    XS(34, 42),
    S(36, 44),
    M(38, 46),
    L(40, 48),
    XL(42, 50),
    XXL(44, 52),
    XXXL(46, 54);

    private int europeanSize;
    private int russianSize;

    Size(int europeanSize, int russianSize) {
        this.europeanSize = europeanSize;
        this.russianSize = russianSize;
    }
}
