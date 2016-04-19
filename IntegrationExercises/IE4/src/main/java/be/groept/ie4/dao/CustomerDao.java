package be.groept.ie4.dao;

import be.groept.ie4.entities.Customer;

import java.util.List;

public interface CustomerDao {

	List<Customer> findCustomers(String name, String firstName, String userName);
}
