package be.groept.hibernate.exercise1.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		// TODO make me work
		return null;
	}

	@Override
	public List<Person> findByName(String name) {
		// TODO make me work
		return null;
		 }

	@Override
	public void removePerson(Person person) {
		// TODO make me work
	}

	@Override
	public void savePerson(Person person) {
		// TODO make me work
	}

	@Override
	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria) {
		// TODO make me work
		return null;
	}
}