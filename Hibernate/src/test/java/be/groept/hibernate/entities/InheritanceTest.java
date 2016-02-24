package be.groept.hibernate.entities;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.PlatformTransactionManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import be.groept.hibernate.entities.inheritance.Address;
import be.groept.hibernate.entities.inheritance.BillingAddress;
import be.groept.hibernate.entities.inheritance.ContactAddress;
import be.groept.hibernate.entities.inheritance.DeliveryAddress;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class InheritanceTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@BeforeMethod
	public void dataSetup() {

		BillingAddress billingAddress = new BillingAddress();
		billingAddress.setCountry("BillingLand");
		billingAddress.setHouseNumber("1");
		billingAddress.setIndexNumber("1");
		billingAddress.setMunicipality("BillingCity");
		billingAddress.setPostalCode("1");
		billingAddress.setStreet("BillingStreet");

		ContactAddress contactAddress = new ContactAddress();
		contactAddress.setCountry("ContactLand");
		contactAddress.setHouseNumber("2");
		contactAddress.setIndexNumber("2");
		contactAddress.setMunicipality("ContactCity");
		contactAddress.setPostalCode("2");
		contactAddress.setStreet("ContactStreet");

		DeliveryAddress deliveryAddress = new DeliveryAddress();
		deliveryAddress.setCountry("DeliveryLand");
		deliveryAddress.setHouseNumber("3");
		deliveryAddress.setIndexNumber("3");
		deliveryAddress.setMunicipality("DeliveryCity");
		deliveryAddress.setPostalCode("3");
		deliveryAddress.setStreet("DeliveryStreet");

		sessionFactory.getCurrentSession().save(billingAddress);
		sessionFactory.getCurrentSession().save(contactAddress);
		sessionFactory.getCurrentSession().save(deliveryAddress);

		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	public void testPolymorphicQuery() {
		List<Address> addresses = sessionFactory.getCurrentSession()
				.createQuery("from AddressInh a where a.country like :country").setString("country", "%Land%").list();

		Address address = addresses.iterator().next();
		
		System.err.println(address.getAddressType());
		System.err.println(address.getCountry());
		System.err.println(address.getHouseNumber());
		System.err.println(address.getIndexNumber());
		System.err.println(address.getMunicipality());
		System.err.println(address.getPostalCode());
		System.err.println(address.getStreet());
	}
}
