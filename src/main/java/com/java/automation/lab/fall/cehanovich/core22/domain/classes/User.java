package com.java.automation.lab.fall.cehanovich.core22.domain.classes;

import com.java.automation.lab.fall.cehanovich.core22.domain.dao.OrderDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.OrderDAOImpl;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlRootElement(name = "User")
@XmlType(propOrder = {"id", "firstname", "lastname", "contactNumber", "email"})
public class User implements Comparable<User>{
    protected int id;
    protected String firstname;
    protected String lastname;
    protected String contactNumber;
    protected String email;

    public User() {

    }

    public User(int id, String firstname, String lastname, String contactNumber, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (basket.getPaymentMethod().balance.compareTo(basket.getTotalPrice()) < 0) {
            throw new IllegalArgumentException("Not enough funds to pay!");
        }
        OrderDAO service = OrderDAOImpl.getInstance();
        return service.create(new Order(id, basket, description, tax));
    }

    @Override
    public String toString() {
        return "User {\nID: " + id + "Firstname: " + firstname + "Lastname: " + lastname + "contactNumber: "
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
        return id == other.id && firstname.equals(other.firstname) && lastname.equals(other.lastname) &&
                contactNumber.equals(other.contactNumber) && email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return id + firstname.hashCode() + lastname.hashCode() + contactNumber.hashCode();
    }

    @Override
    public int compareTo(User a) {
        return this.getId() - a.getId();
    }
}
