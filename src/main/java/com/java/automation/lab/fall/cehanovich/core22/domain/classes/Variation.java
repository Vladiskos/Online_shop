package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Color;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Size;

import java.util.Comparator;

public class Variation implements Comparable<Variation>{
    private int id;
    private Size size;
    private Color color;
    private Product product;
    private int discountPercent;

    public Variation(int id, Size size, Color color, Product product, int discountPercent) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.product = product;
        this.discountPercent = discountPercent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }


    @Override
    public String toString() {
        return "Variation {\nID: " + id + "Size: " + size + "Color: " + color + "Products: " + product.toString()
                + "Discount: " + discountPercent + "\n}";
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
        Variation other = (Variation) that;
        return id == other.id && size.equals(other.size) && color.equals(other.color) &&
                product.equals(other.product) && discountPercent == other.discountPercent;
    }

    @Override
    public int hashCode() {
        return id + size.hashCode() + color.hashCode() + product.hashCode() - discountPercent;
    }

    @Override
    public int compareTo(Variation a) {
        return this.getId() - a.getId();
    }

    public static Comparator<Variation> SizeComparator = new Comparator<Variation>() {

        @Override
        public int compare(Variation a1, Variation a2) {
            return a1.getColor().compareTo(a2.getColor());
        }
    };

    public static Comparator<Variation> ColorComparator = new Comparator<Variation>() {

        @Override
        public int compare(Variation a1, Variation a2) {
            return (a1.getColor().compareTo(a2.getColor()));
        }
    };
}
