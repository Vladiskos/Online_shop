package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.Set;

@XmlRootElement(name = "RegisteredUser")
@XmlType(propOrder = {"id", "firstname", "lastname", "contactNumber", "email", "savedCards","address",
        "discountPercent", "birthday",})
public class RegisteredUser extends User {
    private Set<BankCard> savedCards;
    private int discountPercent;
    private LocalDate birthday;
    private String salt;
    private int passwordHash;
    private LocalDate created;
    private LocalDate modified;
    private int roleId;


    public RegisteredUser(long id, String firstname, String lastname, String contactNumber, String email,
                          Set<BankCard> savedCards, int discountPercent, LocalDate birthday,
                          String salt, int passwordHash, LocalDate created, LocalDate modified, int roleId) {
        super(id, firstname, lastname, contactNumber, email);
        this.savedCards = savedCards;
        this.discountPercent = discountPercent;
        this.birthday = birthday;
        this.salt = salt;
        this.passwordHash = passwordHash;
        this.created = created;
        this.modified = modified;
        this.roleId = roleId;
    }

    public Set<BankCard> getSavedCards() {
        return savedCards;
    }

    public void setSavedCards(Set<BankCard> savedCards) {
        this.savedCards = savedCards;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RegisteredUser {\nID: " + this.getId() + "Firstname: " + firstname + "Lastname: " + lastname + "contactNumber: " +
                contactNumber + "Email: " + email + "Saved cards: " + savedCards.toString() + "Discount: " +
                discountPercent + "% Birthday: " + birthday + "\n}";
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
        return this.getId() == other.getId() && firstname.equals(other.firstname) && lastname.equals(other.lastname) &&
                contactNumber.equals(other.contactNumber) && email.equals(other.email) &&
                savedCards.equals(other.savedCards) && discountPercent == other.discountPercent
                && birthday.equals(other.birthday);
    }

    @Override
    public int hashCode() {
        return (int) (this.getId() + firstname.hashCode() + lastname.hashCode() + contactNumber.hashCode());
    }
}
