package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.Comparator;

@XmlRootElement(name = "Product")
@XmlType(propOrder = {"code", "name", "brand", "description"})
public class Product extends AbstractEntity implements Comparable<Product> {
    private String name;
    private String brand;
    private String description;
    private Variation variation;
    private LocalDate created;
    private LocalDate modified;

    public Product(long id, String name, String brand, String description, Variation variation, LocalDate created, LocalDate modified) {
        this.setId(id);
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.variation = variation;
        this.created = created;
        this.modified = modified;
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

    public Variation getVariation() {
        return variation;
    }

    public void setVariation(Variation variation) {
        this.variation = variation;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Product {\nId: " + this.getId() + "Name: " + name + "Brand: " + brand + "Description: " + description + "\n}";
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
        return this.getId() == other.getId() && name.equals(other.name) && brand.equals(other.brand) &&
                description.equals(other.description);
    }

    @Override
    public int hashCode() {
        return (int) (this.getId() + name.hashCode() + brand.hashCode() - description.hashCode());
    }


    @Override
    public int compareTo(Product a) {
        return (int) (this.getId() - a.getId());
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
