package be.groept.ie4.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.groept.ie4.dao.ShopDao;
import be.groept.ie4.entities.Customer;
import be.groept.ie4.entities.Eshop;
import be.groept.ie4.entities.Order;
import be.groept.ie4.entities.Product;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	@Override
	@SuppressWarnings("unchecked")
	public List<Eshop> listEshops() {
		return shopDao.listAllShops();
	}

	@Override
	public Eshop loadShop(Long shopId) {
		// TODO complete me
		return null;
	}

	@Override
	public Customer loadCustomer(String username) {
		// TODO complete me
		return null;
	}

	@Override
	public void createOrder(List<Product> products) {
		// TODO complete me
	}

	@Override
	public List<Product> listProducts(String name) {
		// TODO complete me
		return null;
	}

	@Override
	public List<Order> listOrders(Customer customer) {
		// TODO complete me
		return null;
	}
}