package be.groept.hibernate.exercise1.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.hibernate.transform.RootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

@Profile("hibernate")
@Repository
@Transactional
public class PersonDaoImpl extends HibernateTemplate implements PersonDao {

	private SessionFactory sessionFactory;

	@Autowired
	public PersonDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Person> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Person p").
				setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE).list();
		//we nemen distinct personen van de db

	}

	@Override
	public List<Person> findByName(String name) {
		return sessionFactory.getCurrentSession().createQuery("from Person p where p.name = :name ").setParameter("name",name)
				.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE).list();

		 }

	@Override
	public void removePerson(Person person) {
		sessionFactory.getCurrentSession().delete(person);
	}

	@Override
	public void savePerson(Person person) {
		sessionFactory.getCurrentSession().save(person);
	}

	@Override
	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria) {



		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Person.class,"p")
				.createAlias("p.address", "a");

		//of met querybuilder:
		//Criteria criteria = new StringBuilder("select p from Person p join p.address a where "); //??
		//Map<String, String> parameters = new HashMap<>();

		if (StringUtils.isNotBlank(addressSearchCriteria.getStreet())){
			criteria.add(Restrictions.ilike("a.street", addressSearchCriteria.getStreet()));
		}
		if (StringUtils.isNotBlank(addressSearchCriteria.getBox())){
			criteria.add(Restrictions.and(Restrictions.ilike("a.box", addressSearchCriteria.getBox())));
		}
		if (StringUtils.isNotBlank(addressSearchCriteria.getCountry())){
			criteria.add(Restrictions.ilike("a.country", addressSearchCriteria.getCountry()));
		}
		if (StringUtils.isNotBlank(addressSearchCriteria.getHouseNumber())){
			criteria.add(Restrictions.ilike("a.housenumber", addressSearchCriteria.getHouseNumber()));
		}
		if (StringUtils.isNotBlank(addressSearchCriteria.getMunicipality())){
			criteria.add(Restrictions.ilike("a.municipality", addressSearchCriteria.getMunicipality()));
		}
		if (StringUtils.isNotBlank(addressSearchCriteria.getPostalCode())){
			criteria.add(Restrictions.ilike("a.postalcode", addressSearchCriteria.getPostalCode()));
		}
		return criteria.list();
	}


}