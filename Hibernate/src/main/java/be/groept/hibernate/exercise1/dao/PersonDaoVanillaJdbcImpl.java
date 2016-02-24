package be.groept.hibernate.exercise1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

@Repository
@Transactional
@Profile("vanilla-jdbc")
public class PersonDaoVanillaJdbcImpl implements  PersonDao{

	private DataSource dataSource;

	@Autowired
	public PersonDaoVanillaJdbcImpl(DataSource dataSource) {
		this.dataSource =dataSource;
	}

	@Override
	public List<Person> findAll() {
		// TODO make me work
		return null;
	}

	@Override
	public List<Person> findByName(final String name) {
		// TODO make me work
		return null;
	}

	@Override
	public void savePerson(final Person person) {
		// TODO make me work
	}

	@Override
	public void removePerson(final Person person) {
		// TODO make me work
	}

	@Override
	public List<Person> findByAddress(final AddressSearchCriteria addressSearchCriteria) {
		// TODO make me work
		return null;
	}
}
