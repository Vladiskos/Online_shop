package com.java.automation.lab.fall.cehanovich.core22.domain.classes.info;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.User;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Comparator;

public class ShippingInfo implements Comparable<ShippingInfo>{
    private OffsetDateTime date;
    private Address address;
    private User customerInfo;
    private LocalDate created;
    private LocalDate modified;

    public ShippingInfo(OffsetDateTime date, Address address, User customerInfo, LocalDate created, LocalDate modified) {
        this.date = date;
        this.address = address;
        this.customerInfo = customerInfo;
        this.created = created;
        this.modified = modified;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(User customerInfo) {
        this.customerInfo = customerInfo;
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
        return "Shipping info {\nDate: " + date.toString() + "Address: " + address + "Customer info: " +
                customerInfo.toString() + "\n}";
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
        ShippingInfo other = (ShippingInfo) that;
        return date.equals(other.date) && address.equals(other.address) && customerInfo.equals(other.customerInfo);
    }

    @Override
    public int hashCode() {
        return customerInfo.hashCode() + address.hashCode() + date.hashCode();
    }


    @Override
    public int compareTo(ShippingInfo a) {
        return this.getDate().compareTo(a.getDate());
    }

    public static Comparator<ShippingInfo> AddressComparator = new Comparator<ShippingInfo>() {

        @Override
        public int compare(ShippingInfo a1, ShippingInfo a2) {
            return a1.getAddress().compareTo(a2.getAddress());
        }
    };

    public static Comparator<ShippingInfo> CustomerInfoComparator = new Comparator<ShippingInfo>() {

        @Override
        public int compare(ShippingInfo a1, ShippingInfo a2) {
            return a1.getCustomerInfo().compareTo(a2.getCustomerInfo());
        }
    };
}
