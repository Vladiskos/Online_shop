package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.BillingInfo;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.ShippingInfo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;

public class Basket implements Comparable<Basket>{
    private int id;
    private List<Variation> variations;
    private int varCounter = 0;
    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;
    private PriceBook priceBook;
    private Coupon coupon;
    private User user;
    private BillingInfo billingInfo;
    private ShippingInfo shippingInfo;

    public Basket() {

    }

    public Basket(int id, List<Variation> variations, BigDecimal totalPrice, PaymentMethod paymentMethod,
                  PriceBook priceBook, Coupon coupon) {
        this.id = id;
        this.variations = variations;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.priceBook = priceBook;
        this.coupon = coupon;

    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

    public int getVarCounter() {
        return varCounter;
    }

    public void setVarCounter(int varCounter) {
        this.varCounter = varCounter;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public PriceBook getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(PriceBook priceBook) {
        this.priceBook = priceBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addVariation(Variation variation) {
        variations.set(varCounter,variation);
        varCounter++;
    }

    public void deleteVariation(int index) {
        for (int i = index; i < variations.size(); i++) {
            variations.set(i,variations.get(++i));
        }
        variations.set(varCounter-1,null);
        varCounter--;
    }

    public BigDecimal countTotalPrice() {
        totalPrice = new BigDecimal(0);
        totalPrice = totalPrice.setScale(2, RoundingMode.CEILING);

        for (Variation variation : variations) {
            for (Variation var : priceBook.getPriceAndProduct().keySet()) {
                if (variation.equals(var)) {
                    totalPrice = totalPrice.add(priceBook.getPriceAndProduct().get(variation)
                            .subtract(priceBook.getPriceAndProduct().get(variation)
                                    .divide(new BigDecimal(100)))
                            .multiply(new BigDecimal(variation.getDiscountPercent())));
                }
            }
        }
        totalPrice = (totalPrice.divide(new BigDecimal(100), 2)).
                multiply(new BigDecimal(coupon.getDiscountPercent()));
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Basket {\nVariations: " + variations.toString() + "Total Price: " + totalPrice +
                "PaymentMethod: " + paymentMethod + "Price book: " + priceBook.toString() + "Coupon: " +
                coupon.toString() + "\n}";
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
        Basket other = (Basket) that;
        return variations.equals(other.variations) && totalPrice.equals(other.totalPrice) &&
                paymentMethod.equals(other.paymentMethod) && coupon.equals(other.coupon);
    }

    @Override
    public int hashCode() {
        return variations.hashCode() + totalPrice.hashCode() - paymentMethod.hashCode() + coupon.hashCode();
    }


    @Override
    public int compareTo(Basket a) {
        return this.getId() - a.getId();
    }

    public static Comparator<Basket> VarCounterComparator = new Comparator<Basket>() {
        @Override
        public int compare(Basket a1, Basket a2) {
            return a1.getVarCounter() - a2.getVarCounter();
        }
    };

    public static Comparator<Basket> TotalPriceComparator = new Comparator<Basket>() {

        @Override
        public int compare(Basket a1, Basket a2) {
            return (a1.getTotalPrice().compareTo(a2.getTotalPrice()));
        }
    };

    public static Comparator<Basket> PaymentMethodComparator = new Comparator<Basket>() {
        @Override
        public int compare(Basket a1, Basket a2) {
            return (a1.getPaymentMethod().compareTo(a2.getPaymentMethod()));
        }
    };

    public static Comparator<Basket> PriceBookComparator = new Comparator<Basket>() {
        @Override
        public int compare(Basket a1, Basket a2) {
            return (a1.getPriceBook().compareTo(a2.getPriceBook()));
        }
    };
}
