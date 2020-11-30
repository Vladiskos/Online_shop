package com.java.automation.lab.fall.cehanovich.core22.domain.classes.info;

import com.java.automation.lab.fall.cehanovich.core22.domain.enums.PaymentType;

import java.math.BigDecimal;
import java.util.Comparator;

public class BillingInfo implements Comparable<BillingInfo> {
    private BigDecimal totalPrice;
    private PaymentType paymentType;
    private String information;

    public BillingInfo(BigDecimal totalPrice, PaymentType paymentType, String information) {
        this.totalPrice = totalPrice;
        this.paymentType = paymentType;
        this.information = information;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentType getPayment() {
        return paymentType;
    }

    public void setPayment(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }


    @Override
    public String toString() {
        return "Billing info{\nTotal price " + totalPrice.toString() + "Payment: " + paymentType + "information: " +
                information + "\n}";
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
        BillingInfo other = (BillingInfo) that;
        return totalPrice.equals(other.totalPrice) && paymentType.equals(other.paymentType) &&
                information.equals(other.information);
    }

    @Override
    public int hashCode() {
        return information.hashCode() + totalPrice.hashCode() + paymentType.hashCode();
    }


    @Override
    public int compareTo(BillingInfo a) {
        return this.getTotalPrice().compareTo(a.getTotalPrice());
    }

    public static Comparator<BillingInfo> PaymentComparator = new Comparator<BillingInfo>() {

        @Override
        public int compare(BillingInfo a1, BillingInfo a2) {
            return (a1.getPayment().compareTo(a2.getPayment()));
        }
    };

    public static Comparator<BillingInfo> InformationComparator = new Comparator<BillingInfo>() {

        @Override
        public int compare(BillingInfo a1, BillingInfo a2) {
            return (a1.getInformation().compareTo(a2.getInformation()));
        }
    };
}

