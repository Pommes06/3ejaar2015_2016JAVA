package be.groept.hibernate.exercise1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Address;
import be.groept.hibernate.exercise1.entities.Person;

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