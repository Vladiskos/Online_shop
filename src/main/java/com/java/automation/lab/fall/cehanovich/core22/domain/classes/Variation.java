package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Color;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Size;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.Comparator;

@XmlRootElement(name = "Variation")
@XmlType(propOrder = {"id", "size", "color", "product", "discountPercent"})
public class Variation extends AbstractEntity implements Comparable<Variation>{
    private Size size;
    private Color color;
    private int discountPercent;
    private LocalDate created;
    private LocalDate modified;

    public Variation(long id, Size size, Color color, int discountPercent, LocalDate created, LocalDate modified) {
        this.setId(id);
        this.size = size;
        this.color = color;
        this.discountPercent = discountPercent;
        this.created = created;
        this.modified = modified;
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

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
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
        return "Variation {\nID: " + this.getId() + "Size: " + size + "Color: " + color
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
        return this.getId() == other.getId() && size.equals(other.size) && color.equals(other.color) &&
                discountPercent == other.discountPercent;
    }

    @Override
    public int hashCode() {
        return (int) (this.getId() + size.hashCode() + color.hashCode()  - discountPercent);
    }

    @Override
    public int compareTo(Variation a) {
        return (int) (this.getId() - a.getId());
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
