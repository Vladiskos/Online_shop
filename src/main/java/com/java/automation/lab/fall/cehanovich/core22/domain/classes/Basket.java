package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.BillingInfo;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.ShippingInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;

@XmlRootElement(name = "Basket")
@XmlType(propOrder = {"id", "variations", "varCounter", "totalPrice", "paymentMethod", "priceBook",
        "coupon", "user", "billingInfo", "shippingInfo"})
public class Basket extends AbstractEntity implements Comparable<Basket>{
    private List<Variation> variations;
    private int varCounter = 0;
    private BigDecimal totalPrice;
    private BankCard bankCard;
    private PriceBook priceBook;
    private Coupon coupon;
    private User user;
    private LocalDate created;
    private LocalDate modified;

    public Basket() {

    }

    public Basket(long id, List<Variation> variations, BigDecimal totalPrice, BankCard bankCard,
                  PriceBook priceBook, Coupon coupon, User user, LocalDate created, LocalDate modified) {
        this.setId(id);
        this.variations = variations;
        this.totalPrice = totalPrice;
        this.bankCard = bankCard;
        this.priceBook = priceBook;
        this.user = user;
        this.coupon = coupon;
        this.created = created;
        this.modified = modified;

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

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
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
                "Bank card: " + bankCard.toString() + "Price book: " + priceBook.toString() + "Coupon: " +
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
                bankCard.equals(other.bankCard) && coupon.equals(other.coupon);
    }

    @Override
    public int hashCode() {
        return variations.hashCode() + totalPrice.hashCode() - bankCard.hashCode() + coupon.hashCode();
    }


    @Override
    public int compareTo(Basket a) {
        return (int) (this.getId() - a.getId());
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
            return (a1.getBankCard().compareTo(a2.getBankCard()));
        }
    };

    public static Comparator<Basket> PriceBookComparator = new Comparator<Basket>() {
        @Override
        public int compare(Basket a1, Basket a2) {
            return (a1.getPriceBook().compareTo(a2.getPriceBook()));
        }
    };
}
