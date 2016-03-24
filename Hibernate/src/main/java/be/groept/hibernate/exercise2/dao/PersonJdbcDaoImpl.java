package be.groept.hibernate.exercise2.dao;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
@Profile("jdbc")
public class PersonJdbcDaoImpl extends JdbcTemplate implements PersonDao {

	@Autowired
	public PersonJdbcDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	public List<Person> findAll() {
		// TODO make me work



		return null;
	}

	public List<Person> findByName(String name) {
		// TODO make me work
		return null;
	}

	public void removePerson(Person person) {
		// TODO make me work
	}

	public void savePerson(Person person) {
		// TODO make me work
	}

	@Override
	public List<Person> findByAddress(final AddressSearchCriteria addressSearchCriteria) {
		// TODO make me work
		return null;
	}

}