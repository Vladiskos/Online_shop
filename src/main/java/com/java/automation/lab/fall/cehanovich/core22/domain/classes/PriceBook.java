package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Currency;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.Map;

public class PriceBook implements Comparable<PriceBook> {
    private Currency currency;
    private boolean enabled;
    private OffsetDateTime validFrom;
    private OffsetDateTime validTo;
    private Map<Variation, BigDecimal> priceAndProduct;

    public PriceBook(Currency currency, boolean enabled, OffsetDateTime validFrom, OffsetDateTime validTo,
                     Map<Variation, BigDecimal> priceAndProduct) {
        this.currency = currency;
        this.enabled = enabled;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.priceAndProduct = priceAndProduct;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public OffsetDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
    }

    public Map<Variation, BigDecimal> getPriceAndProduct() {
        return priceAndProduct;
    }

    public void setPriceAndProduct(Map<Variation, BigDecimal> priceAndProduct) {
        this.priceAndProduct = priceAndProduct;
    }

    @Override
    public String toString() {
        return "PriceBook {\nСurrency: " + currency + "Is enabled: " + enabled + "Valid from: " + validFrom +
                "Valid To: " + validTo + "Price and Product" + priceAndProduct.toString() + "\n}";
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
        PriceBook other = (PriceBook) that;
        return currency.equals(other.currency) && enabled == other.enabled && validFrom.equals(other.validFrom) &&
                validTo.equals(other.validTo) && priceAndProduct.equals(other.priceAndProduct);
    }

    @Override
    public int hashCode() {
        return currency.hashCode() + validFrom.hashCode() + validTo.hashCode() - priceAndProduct.hashCode();
    }


    @Override
    public int compareTo(PriceBook a) {
        return this.getCurrency() .compareTo(a.getCurrency());
    }

    public static Comparator<PriceBook> ValidFromComparator = new Comparator<PriceBook>() {
        @Override
        public int compare(PriceBook a1, PriceBook a2) {
            return a1.getValidFrom().compareTo(a2.getValidFrom());
        }
    };

    public static Comparator<PriceBook> ValidToComparator = new Comparator<PriceBook>() {

        @Override
        public int compare(PriceBook a1, PriceBook a2) {
            return (a1.getValidTo().compareTo(a2.getValidTo()));
        }
    };

}
