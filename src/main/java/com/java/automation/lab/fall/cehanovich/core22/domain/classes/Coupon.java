package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.Comparator;

@XmlRootElement(name = "Coupon")
@XmlType(propOrder = {"id", "enabled", "discountPercent"})
public class Coupon extends AbstractEntity implements Comparable<Coupon> {
    private boolean enabled;
    private int discountPercent;
    private LocalDate created;
    private LocalDate modified;

    public Coupon() {

    }

    public Coupon(long id, boolean enabled, int discountPercent, LocalDate created, LocalDate modified) {
        this.setId(id);
        this.enabled = enabled;
        this.discountPercent = discountPercent;
        this.created = created;
        this.modified = modified;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
        return "Coupon {\nID: " + this.getId() + "Is enabled" + enabled + "Discount: " + discountPercent + "%\n}";
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
        Coupon other = (Coupon) that;
        return this.getId() == other.getId()  && enabled == other.enabled && discountPercent == other.discountPercent;
    }

    @Override
    public int hashCode() {
        return (int) (this.getId() * 13 + discountPercent + 3);
    }


    @Override
    public int compareTo(Coupon a) {
        return (int) (this.getId() - a.getId());
    }

    public static Comparator<Coupon> DiscountPercentComparator = new Comparator<Coupon>() {
        @Override
        public int compare(Coupon a1, Coupon a2) {
            return (a1.getDiscountPercent() - a2.getDiscountPercent());
        }
    };

}
