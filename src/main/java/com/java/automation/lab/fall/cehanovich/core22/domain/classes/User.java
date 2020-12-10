package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import com.java.automation.lab.fall.cehanovich.core22.domain.dao.OrderDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.OrderDAOImpl;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "User")
@XmlType(propOrder = {"id", "firstname", "lastname", "contactNumber", "email"})
public class User extends AbstractEntity implements Comparable<User>{
    protected String firstname;
    protected String lastname;
    protected String contactNumber;
    protected String email;

    public User() {

    }

    public User(long id, String firstname, String lastname, String contactNumber, String email) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Order takeAnOrder(Basket basket, String description, BigDecimal tax) {
        if (basket.getBankCard().balance.compareTo(basket.getTotalPrice()) < 0) {
            throw new IllegalArgumentException("Not enough funds to pay!");
        }
        OrderDAO service = OrderDAOImpl.getInstance();
        return service.create(new Order(this.getId(), basket, description, tax, LocalDate.now(), LocalDate.now()));
    }

    @Override
    public String toString() {
        return "User {\nID: " + this.getId() + "Firstname: " + firstname + "Lastname: " + lastname + "contactNumber: "
                + contactNumber + "Email: " + email + "\n}";
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
        User other = (User) that;
        return this.getId() == other.getId() && firstname.equals(other.firstname) && lastname.equals(other.lastname) &&
                contactNumber.equals(other.contactNumber) && email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return (int) (this.getId() + firstname.hashCode() + lastname.hashCode() + contactNumber.hashCode());
    }

    @Override
    public int compareTo(User a) {
        return (int) (this.getId() - a.getId());
    }
}
