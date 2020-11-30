package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import java.time.LocalDate;
import java.util.Set;

public class RegisteredUser extends User {
    private Set<BankCard> savedCards;
    private Address address;
    private int discountPercent;
    private LocalDate birthday;

    public RegisteredUser(int id, String firstname, String lastname, String contactNumber, String email,
                          Set<BankCard> savedCards, Address address, int discountPercent, LocalDate birthday) {
        super(id, firstname, lastname, contactNumber, email);
        this.savedCards = savedCards;
        this.address = address;
        this.discountPercent = discountPercent;
        this.birthday = birthday;
    }

    public Set<BankCard> getSavedCards() {
        return savedCards;
    }

    public void setSavedCards(Set<BankCard> savedCards) {
        this.savedCards = savedCards;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getDiscount() {
        return discountPercent;
    }

    public void setDiscount(int discount) {
        this.discountPercent = discount;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "RegisteredUser {\nID: " + id + "Firstname: " + firstname + "Lastname: " + lastname + "contactNumber: " +
                contactNumber + "Email: " + email + "Saved cards: " + savedCards.toString() + "Address: " +
                address + "Discount: " + discountPercent + "% Birthday: " + birthday + "\n}";
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
        RegisteredUser other = (RegisteredUser) that;
        return id == other.id && firstname.equals(other.firstname) && lastname.equals(other.lastname) &&
                contactNumber.equals(other.contactNumber) && email.equals(other.email) &&
                savedCards.equals(other.savedCards) && address.equals(other.address) &&
                discountPercent == other.discountPercent && birthday.equals(other.birthday);
    }

    @Override
    public int hashCode() {
        return id + firstname.hashCode() + lastname.hashCode() + contactNumber.hashCode() + address.hashCode();
    }
}
