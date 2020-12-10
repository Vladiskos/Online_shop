package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlRootElement(name = "PaymentMethod")
@XmlType(propOrder = {"balance"})
public abstract class PaymentMethod extends AbstractEntity implements Comparable<PaymentMethod>{
    protected BigDecimal balance;

    public PaymentMethod() {

    }

    public PaymentMethod(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Payment method {\nBalance: " + balance + "%\n}";
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
        PaymentMethod other = (PaymentMethod) that;
        return balance.equals(other.balance);
    }

    @Override
    public int hashCode() {
        return balance.hashCode() * 3 + 19;
    }

    @Override
    public int compareTo(PaymentMethod a) {
        return this.getBalance().compareTo(a.getBalance());
    }
}
