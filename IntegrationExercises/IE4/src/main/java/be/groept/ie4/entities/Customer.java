package be.groept.ie4.entities;

import be.groept.ie4.entities.types.Password;
import be.groept.ie4.entities.types.PasswordUserType;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private long cust_id;
    private String username;
    private Password password;
    private String name;
    private String firstname;
    private List<Order> orders = new ArrayList<>();

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders( List<Order> orders) {
        this.orders = orders;
    }
}
