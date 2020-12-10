package com.java.automation.lab.fall.cehanovich.core22.domain.enums;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RGB;

public enum Color {
    RED("RED", 0xFF0000,new RGB(255,0,0)),
    DARK_RED("DARK_RED", 0x8B0000,new RGB(139,0,0)),
    PINK("PINK", 0xFFC0CB,new RGB(255,192,203)),
    DEEP_PINK("DEEP_PINK",0xFF1493,new RGB(255,20,147)),
    ORANGE_RED("ORANGE_RED",0xFF4500,new RGB(255,69,0)),
    DARK_ORANGE("DARK_ORANGE",0xFF8C00,new RGB(255,140,0)),
    ORANGE("ORANGE",0xFFA500,new RGB(255,165,0)),
    YELLOW("YELLOW",0xFFFF00,new RGB(255,255,0)),
    GOLD("GOLD",0xFFD700,new RGB(255,215,0)),
    GREEN("GREEN",0x008000,new RGB(0,1280,0)),
    LIME("DARK_RED",0x00FF00,new RGB(0,255,0)),
    GREEN_YELLOW("GREEN_YELLOW",0xFF0000,new RGB(173,255,47)),
    CYAN("CYAN",0x00FFFF,new RGB(0,255,255)),
    BLUE("BLUE",0x0000FF,new RGB(0,0,255)),
    DARK_BLUE("DARK_BLUE",0x00008B,new RGB(0,0,139)),
    DEEP_BLUE("DEEP_BLUE",0x0000CD,new RGB(0,0,200)),
    PURPLE("PURPLE",0x800080,new RGB(128,0,128)),
    VIOLET("VIOLET",0xEE82EE,new RGB(238,130,238)),
    INDIGO("INDIGO",0x4B0082,new RGB(75,0,130)),
    BLACK("BLACK",0x00000,new RGB(0,0,0)),
    BROWN("BROWN",0xA52A2A,new RGB(165,42,42)),
    GRAY("GRAY",0x808080,new RGB(128,128,128)),
    SILVER("SILVER",0xC0C0C0,new RGB(192,192,192)),
    WHITE("WHITE",0xFFFFFF,new RGB(255,255,255));

    private String color;
    private int hex;
    private RGB rgb;

    Color(String color, int hex, RGB rgb) {
        this.color = color;
        this.hex = hex;
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return "'" + color + " " + hex + " " + rgb.getRed() + " " + rgb.getGreen() + " " + rgb.getBlue() + "'";
    }
}

