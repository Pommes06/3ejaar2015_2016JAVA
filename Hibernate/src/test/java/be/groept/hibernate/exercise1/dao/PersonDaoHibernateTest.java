package be.groept.hibernate.exercise1.dao;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import be.groept.demo.DemoEntity;
import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles("hibernate")
public class PersonDaoHibernateTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private SessionFactory sessionFactory;
	
	private Person johnDoe, steveWilson;

	@BeforeMethod
	private void dataSetup() {
		johnDoe = new PersonBuilder() {
			{
				firstName("John").name("Doe");
				address(new AddressBuilder() {
					{
						country("belgium");
						municipality("brussels").postalCode("1000");
						street("nieuwstraat");
						houseNumber("1").box("A");
					}
				}.build());
			}
		}.build();

		steveWilson = new PersonBuilder() {
			{
				firstName("Steve").name("Wilson");
				address(new AddressBuilder() {
					{
						country("belgium");
						municipality("antwerp").postalCode("2000");
						street("meir");
						houseNumber("10");
					}
				}.build());

				address(new AddressBuilder() {
					{
						country("spain");
						municipality("madrid").postalCode("57867");
						street("lospolloshermanos");
						houseNumber("1");
					}
				}.build());
			}
		}.build();
		
		DemoEntity d = new DemoEntity();
		sessionFactory.getCurrentSession().save(d);

		personDao.savePerson(johnDoe);
		personDao.savePerson(steveWilson);
	}

	public void testAll() {
		List<Person> persons = personDao.findAll();
		assertEquals(persons.size(), 2);

		Person john = persons.stream().filter(p -> p.getFirstName().equals("John")).findFirst().get();
		Person steve = persons.stream().filter(p -> p.getFirstName().equals("Steve")).findFirst().get();

		assertEquals(john.getAddress().size(), 1);
		assertEquals(john.getName(), "Doe");

		assertEquals(steve.getAddress().size(), 2);
		assertEquals(steve.getName(), "Wilson");
	}


	public void testFindByName() {
		List<Person> persons = personDao.findByName("doe");
		assertEquals(persons.size(), 1);

		Person john = persons.stream().filter(p -> p.getFirstName().equals("John")).findFirst().get();

		assertEquals(john.getFirstName(), "John");
		assertEquals(john.getName(), "Doe");
		assertEquals(john.getAddress().size(), 1);
	}

	public void testFindByAddressCriteria() {
		AddressSearchCriteria addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		addressSearchCriteria.setMunicipality("antwerp");

		List<Person> persons = personDao.findByAddress(addressSearchCriteria);
		assertEquals(persons.size(), 1);
		Person steve = persons.stream().filter(p -> p.getFirstName().equals("Steve")).findFirst().get();

		assertEquals(steve.getFirstName(), "Steve");
		assertEquals(steve.getName(), "Wilson");
		assertEquals(steve.getAddress().size(), 2);

		addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		addressSearchCriteria.setMunicipality("brussels");

		persons = personDao.findByAddress(addressSearchCriteria);
		assertEquals(persons.size(), 1);

		Person john = persons.stream().filter(p -> p.getFirstName().equals("John")).findFirst().get();

		assertEquals(john.getFirstName(), "John");
		assertEquals(john.getName(), "Doe");
		assertEquals(john.getAddress().size(), 1);

		addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		persons = personDao.findByAddress(addressSearchCriteria);
		assertEquals(persons.size(), 2);
	}

	public void testDelete() {
		personDao.removePerson(personDao.findByName("Doe").iterator().next());
		personDao.removePerson(personDao.findByName("Wilson").iterator().next());
		assertEquals(personDao.findByName("Wilson").size(), 0);
		assertEquals(personDao.findByName("Doe").size(), 0);
	}
}