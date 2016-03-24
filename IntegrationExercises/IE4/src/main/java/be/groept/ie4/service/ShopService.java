package be.groept.ie4.service;

import java.util.List;

import be.groept.ie4.entities.Customer;
import be.groept.ie4.entities.Eshop;
import be.groept.ie4.entities.Order;
import be.groept.ie4.entities.Product;

public interface ShopService {

	public List<Eshop> listEshops();

	public Eshop loadShop(Long shopId);

	public Customer loadCustomer(String username);

	public void createOrder(List<Product> products);

	public List<Product> listProducts(String name);

	public List<Order> listOrders(Customer customer);

}
