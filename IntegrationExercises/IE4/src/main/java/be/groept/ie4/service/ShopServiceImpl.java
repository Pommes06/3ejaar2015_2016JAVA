package be.groept.ie4.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import be.groept.ie4.dao.CustomerDao;
import be.groept.ie4.dao.OrderDao;
import be.groept.ie4.dao.ProductDao;
import be.groept.ie4.entities.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.groept.ie4.dao.ShopDao;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	private CustomerDao customerDao;
	private OrderDao orderDao;
	private ProductDao productDao;


	@Override
	@SuppressWarnings("unchecked")
	public List<Eshop> listEshops() {
		return shopDao.listAllShops();
	}

	@Override
	public Eshop loadShop(Long shopId) {


		return shopDao.findEshopById(shopId);
	}

	@Override
	public Customer loadCustomer(String username) {

		return customerDao.findCustomers(null,null, username).get(0);
	}

	@Override
	public void createOrder(List<Product> products) {

		Order order = new Order();
		Collection<OrderDetail> odlist = new ArrayList<>();
		for(Product prod:products){
			OrderDetail od = new OrderDetail();
			od.setProduct(prod);
			od.setAmount(new BigDecimal(1));
			od.setTotal(prod.getPrice());
			od.setOrder(order);
			odlist.add(od);
		}

		order.setOrderDetails(odlist);
		order.setOrderTotal();
		order.setPaymentMethod("");
		order.setEshop(shopDao.findEshopById(1L)); //shop moet verbonden worden aan Order

		orderDao.saveOrder(order);
	}

	@Override
	public List<Product> listProducts(String name) {

		return productDao.findProducts(name);
	}

	@Override
	public List<Order> listOrders(Customer customer) {

		return orderDao.findOrderForCustomer(customer);
	}
}