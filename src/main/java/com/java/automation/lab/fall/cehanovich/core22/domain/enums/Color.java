package com.java.automation.lab.fall.cehanovich.core22.domain.enums;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RGB;

public enum Color {
    RED(0xFF0000,new RGB(255,0,0)),
    DARK_RED(0x8B0000,new RGB(139,0,0)),
    PINK(0xFFC0CB,new RGB(255,192,203)),
    DEEP_PINK(0xFF1493,new RGB(255,20,147)),
    ORANGE_RED(0xFF4500,new RGB(255,69,0)),
    DARK_ORANGE(0xFF8C00,new RGB(255,140,0)),
    ORANGE(0xFFA500,new RGB(255,165,0)),
    YELLOW(0xFFFF00,new RGB(255,255,0)),
    GOLD(0xFFD700,new RGB(255,215,0)),
    GREEN(0x008000,new RGB(0,1280,0)),
    LIME(0x00FF00,new RGB(0,255,0)),
    GREEN_YELLOW(0xFF0000,new RGB(173,255,47)),
    CYAN(0x00FFFF,new RGB(0,255,255)),
    BLUE(0x0000FF,new RGB(0,0,255)),
    DARK_BLUE(0x00008B,new RGB(0,0,139)),
    DEEP_BLUE(0x0000CD,new RGB(0,0,200)),
    PURPLE(0x800080,new RGB(128,0,128)),
    VIOLET(0xEE82EE,new RGB(238,130,238)),
    INDIGO(0x4B0082,new RGB(75,0,130)),
    BLACK(0x00000,new RGB(0,0,0)),
    BROWN(0xA52A2A,new RGB(165,42,42)),
    GRAY(0x808080,new RGB(128,128,128)),
    SILVER(0xC0C0C0,new RGB(192,192,192)),
    WHITE(0xFFFFFF,new RGB(255,255,255));

    private int hex;
    private RGB rgb;

    Color(int hex, RGB rgb) {
        this.hex = hex;
        this.rgb = rgb;
    }
}
