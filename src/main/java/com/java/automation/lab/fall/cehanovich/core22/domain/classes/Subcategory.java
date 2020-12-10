package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Comparator;
import java.util.Set;

@XmlRootElement(name = "Subcategory")
@XmlType(propOrder = {"id", "discountPercent", "name", "products"})
public class Subcategory extends AbstractEntity implements Comparable<Subcategory> {
    private int discountPercent;
    private String name;
    private Set<Product> products;

    public Subcategory(long id, int discountPercent, String name, Set<Product> products) {
        this.setId(id);
        this.discountPercent = discountPercent;
        this.name = name;
        this.products = products;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Subcategory {\nID: " + this.getId() + "Discount: " + discountPercent + "Name: " + name + "Products: " +
                products.toString() + "\n}";
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
        Subcategory other = (Subcategory) that;
        return this.getId() == other.getId() && discountPercent == other.discountPercent && name.equals(other.name) &&
                products.equals(other.products);
    }

    @Override
    public int hashCode() {
        return (int) (this.getId() + name.hashCode() + products.hashCode());
    }


    @Override
    public int compareTo(Subcategory a) {
        return (int) (this.getId() - a.getId());
    }

    public static Comparator<Subcategory> DiscountComparator = new Comparator<Subcategory>() {

        @Override
        public int compare(Subcategory a1, Subcategory a2) {
            return a1.getDiscountPercent() - a2.getDiscountPercent();
        }
    };

    public static Comparator<Subcategory> NameComparator = new Comparator<Subcategory>() {

        @Override
        public int compare(Subcategory a1, Subcategory a2) {
            return (a1.getName().compareTo(a2.getName()));
        }
    };
}
