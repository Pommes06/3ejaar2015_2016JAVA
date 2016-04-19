package be.groept.ie4.dao;

import be.groept.ie4.entities.Customer;
import be.groept.ie4.entities.Order;
import be.groept.ie4.entities.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Order> findOrderForCustomer(Customer customer) {

		return customer.getOrders();
	}

	@Override
	public void saveOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}
}
