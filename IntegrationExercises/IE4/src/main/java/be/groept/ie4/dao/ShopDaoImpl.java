package be.groept.ie4.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.groept.ie4.entities.Eshop;

@Repository
public class ShopDaoImpl implements ShopDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Eshop> listAllShops() {
		return sessionFactory.getCurrentSession().createQuery("from Eshop").list();
	}

	@Override
	public Eshop findEshopById(long eshopid) {

		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Eshop.class);
		cr.add(Restrictions.eq("eshop_id",eshopid));

		if(cr.list().size() > 0) return (Eshop)cr.list().get(0);
		else return null;
	}
}
