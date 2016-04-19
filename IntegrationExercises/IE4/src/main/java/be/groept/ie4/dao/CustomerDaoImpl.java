package be.groept.ie4.dao;

import be.groept.ie4.entities.Customer;
import be.groept.ie4.entities.Eshop;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> findCustomers(String name, String firstName, String userName) {

		List<Customer> customers = new ArrayList<>();
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Customer.class);
		int noinput = 0;

		if(name!=null){
			cr.add(Restrictions.eq("name",name));
			noinput++;
		}
		if(firstName!=null){
			cr.add(Restrictions.eq("firstname",firstName));
			noinput++;
		}
		if(userName!=null){
			cr.add(Restrictions.eq("username",userName));
			noinput++;
		}

		if (noinput == 0) return null; //indien geen input gegeven is wordt een lege lijst teruggegeven.

		customers = cr.list();
		return customers;

	}
}
