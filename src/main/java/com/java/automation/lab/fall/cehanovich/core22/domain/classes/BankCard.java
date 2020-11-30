package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import java.math.BigDecimal;
import java.util.Comparator;

public class BankCard extends PaymentMethod{
    private String number;
    private String validity;
    private String cvc;

    public BankCard() {

    }

    public BankCard(String number, String validity, String cvc, BigDecimal balance) throws Exception {
        super(balance);
        setNumber(number);
        setValidity(validity);
        setCvc(cvc);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws Exception {
        if (number.length() == 19) {
            String[] num = number.split(" ");

            for (String word : num) {
                if (word.length() != 4) {
                    throw new IllegalArgumentException("Illegal card number!");
                }
                for (char i : word.toCharArray()) {
                    if (i < '0' || i > '9') {
                        throw new IllegalArgumentException("Illegal card number!");
                    }
                }
            }
            this.number = number;
        } else {
            throw new IllegalArgumentException("Illegal card number!");
        }
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        if (validity.length() == 5) {
            String[] val = validity.split("/");

            for (String word : val) {
                if (word.length() != 2) {
                    throw new IllegalArgumentException("Illegal card validity!");
                }
                for (char i : word.toCharArray()) {
                    if (i < '0' || i > '9') {
                        throw new IllegalArgumentException("Illegal card validity!");
                    }
                }
            }
            this.validity = validity;
        } else {
            throw new IllegalArgumentException("Illegal card validity!");
        }
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) throws Exception {
        if (cvc.length() == 3) {
            for (char i : cvc.toCharArray()) {
                if (i < '0' || i > '9')
                    throw new IllegalArgumentException("Illegal card cvv!");
            }
            this.cvc = cvc;
        } else {
            throw new IllegalArgumentException("Illegal card cvv!");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankCard {\nNumber: " + number + " Validity: " + validity + " CVC: " + cvc + "\n}";
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
        BankCard other = (BankCard) that;
        return number.equals(other.number) && validity.equals(other.validity) && cvc.equals(other.cvc);
    }

    @Override
    public int hashCode() {
        return number.hashCode() + validity.hashCode() + cvc.hashCode();
    }

    public static Comparator<BankCard> ValidityComparator = new Comparator<BankCard>() {

        @Override
        public int compare(BankCard a1, BankCard a2) {
            return (a1.getValidity().compareTo(a2.getValidity()));
        }
    };

    public static Comparator<BankCard> CVCComparator = new Comparator<BankCard>() {

        @Override
        public int compare(BankCard a1, BankCard a2) {
            return (a1.getCvc().compareTo(a2.getCvc()));
        }
    };
}
