package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import com.java.automation.lab.fall.cehanovich.core22.domain.enums.Currency;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.Map;

@XmlRootElement(name = "PriceBook")
@XmlType(propOrder = {"currency", "enabled", "validFrom", "validTo", "priceAndProduct"})
public class PriceBook extends AbstractEntity implements Comparable<PriceBook> {
    private Currency currency;
    private boolean enabled;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Map<Variation, BigDecimal> priceAndProduct;
    private LocalDate created;
    private LocalDate modified;

    public PriceBook(long id, Currency currency, boolean enabled, LocalDate validFrom, LocalDate validTo,
                     Map<Variation, BigDecimal> priceAndProduct, LocalDate created, LocalDate modified) {
        this.setId(id);
        this.currency = currency;
        this.enabled = enabled;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.priceAndProduct = priceAndProduct;
        this.created = created;
        this.modified = modified;
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

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Map<Variation, BigDecimal> getPriceAndProduct() {
        return priceAndProduct;
    }

    public void setPriceAndProduct(Map<Variation, BigDecimal> priceAndProduct) {
        this.priceAndProduct = priceAndProduct;
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
