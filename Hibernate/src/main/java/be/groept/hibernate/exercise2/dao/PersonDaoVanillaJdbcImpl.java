package be.groept.hibernate.exercise2.dao;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Address;
import be.groept.hibernate.exercise1.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import java.util.function.Supplier;

@Repository
@Transactional
@Profile("vanilla-jdbc")
public class PersonDaoVanillaJdbcImpl implements PersonDao {

	private DataSource dataSource;

	@Autowired
	public PersonDaoVanillaJdbcImpl(DataSource dataSource) {
		this.dataSource =dataSource;
	}

	@Override
	public List<Person> findAll() {





		String query = "select p.*, a.*, a.id as aid from person p left join address a on a.person_id = p.id";
		// we maken een alias voor de id van address zodat die in de resultset via de naam onderscheiden kan worden van person id.
		try {
			final Map<Long, Person> map = new HashMap<>();

			Connection connection = dataSource.getConnection();
			final ResultSet rs =connection.createStatement().executeQuery(query);
			rs.beforeFirst(); //wellicht nodig om de cursor op de eertse result te zetten... niet zeker

			while (rs.next()){
				Long personId = rs.getLong("p.id");
				Optional<Person> personOptional = Optional.ofNullable(map.get(personId));
				//Optional komt erop neer if Null then, java8 manier.
				// vermijd de NullPointerException
				// normaal gebruik je Optional.Empty of Optional.of(Value) en zorgen dat value niet null is... compliqué.
				Person person = personOptional.orElseGet(new Supplier<Person>() {
					//Supplier maakt het object aan als er geen Person bestaat voor e personid
					//on évite ici de créer plusieurs fois la même personne dans le map, si celui-ci a plusieurs adresses.
					@Override
					public Person get() {
						try {
							Person person = new Person();
							person.setFirstName(rs.getString("firstname"));
							person.setName(rs.getString("name"));
							person.setId(rs.getLong("id"));
							map.put(personId,person);


							return person;

						}
						catch (Exception e){
							throw new RuntimeException(e);
						}

					}
				});

				Address address = new Address();
				address.setId(rs.getLong("aid"));
				address.setBox(rs.getString("box"));
				address.setCountry(rs.getString("country"));
				address.setHouseNumber(rs.getString("housenumber"));
				address.setMunicipality(rs.getString("municipality"));
				address.setPostalCode(rs.getString("postalcode"));
				address.setStreet(rs.getString("street"));
				person.getAddress().add(address);


			}

			return new ArrayList<Person>(map.values());


		}
		catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Person> findByName(final String name) {
		// TODO make me work
		return null;
	}

	@Override
	public void savePerson(final Person person) {
		try {
			Connection con = dataSource.getConnection();
		}catch (Exception e){

		}


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
