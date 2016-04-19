package be.groept.ie4.dao;

import be.groept.ie4.entities.Customer;
import be.groept.ie4.entities.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> findProducts(String productName) {

		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Product.class);
		cr.add(Restrictions.like("name",productName + "%"));

		return cr.list();
	}
}
