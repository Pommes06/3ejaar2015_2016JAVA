package be.groept.ie4.dao;

import be.groept.ie4.entities.Customer;
import be.groept.ie4.entities.Order;

import java.util.List;

public interface OrderDao {

	List<Order> findOrderForCustomer(Customer customer);

    void saveOrder(Order order);
}
