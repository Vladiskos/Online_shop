package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import java.util.Comparator;

public class Product implements Comparable<Product> {
    private int code;
    private String name;
    private String brand;
    private String description;

    public Product(int code, String name, String brand, String description) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Product {\nСode: " + code + "Name: " + name + "Brand: " + brand + "Description: " + description + "\n}";
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
        Product other = (Product) that;
        return code == other.code && name.equals(other.name) && brand.equals(other.brand) &&
                description.equals(other.description);
    }

    @Override
    public int hashCode() {
        return code + name.hashCode() + brand.hashCode() - description.hashCode();
    }


    @Override
    public int compareTo(Product a) {
        return this.getCode() - a.getCode();
    }

    public static Comparator<Product> NameComparator = new Comparator<Product>() {

        @Override
        public int compare(Product a1, Product a2) {
            return (a1.getName().compareTo(a2.getName()));
        }
    };

    public static Comparator<Product> DescriptionComparator = new Comparator<Product>() {

        @Override
        public int compare(Product a1, Product a2) {
            return (a1.getDescription().compareTo(a2.getDescription()));
        }
    };

    public static Comparator<Product> BrandComparator = new Comparator<Product>() {

        @Override
        public int compare(Product a1, Product a2) {
            return (a1.getBrand().compareTo(a2.getBrand()));
        }
    };


}
