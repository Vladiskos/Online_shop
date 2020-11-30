package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Comparator;

@XmlRootElement(name = "RGB")
@XmlType(propOrder = {"red", "green", "blue"})
public class RGB implements Comparable<RGB>{
    private int red;
    private int green;
    private int blue;

    public RGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }


    @Override
    public String toString() {
        return "RGB {\nRed: " + red + "Green: " + green + "Blue: " + blue + "%\n}";
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }
        if (this == that) {
            return true;
        }
        RGB other = (RGB) that;
        return red == other.red && green == other.green && blue == other.blue;
    }

    @Override
    public int hashCode() {
        return blue * 13 + blue + 3 + red * 7;
    }

    @Override
    public int compareTo(RGB a) {
        return this.getRed() - a.getRed();
    }

    public static Comparator<RGB> GreenComparator = new Comparator<RGB>() {

        @Override
        public int compare(RGB a1, RGB a2) {
            return a1.getGreen() - a2.getGreen();
        }
    };

    public static Comparator<RGB> BlueComparator = new Comparator<RGB>() {

        @Override
        public int compare(RGB a1, RGB a2) {
            return a1.getBlue() - a2.getBlue();
        }
    };
}
