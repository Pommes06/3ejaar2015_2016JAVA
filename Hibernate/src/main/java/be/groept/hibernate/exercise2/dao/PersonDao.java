package be.groept.hibernate.exercise2.dao;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

import java.util.List;


public interface PersonDao {

	public List<Person> findAll();

	public List<Person> findByName(String name);

	public void savePerson(Person person);

	public void removePerson(Person person);

	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria);

}
