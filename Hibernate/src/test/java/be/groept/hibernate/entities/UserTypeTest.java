package be.groept.hibernate.entities;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import be.groept.hibernate.entities.types.Password;
import be.groept.hibernate.entities.types.User;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserTypeTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("all")
	public void testUserType() {
		User user = new User();
		user.setUsername("john");
		user.setPassword(new Password("doe"));

		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();

		User john = (User) sessionFactory.getCurrentSession().get(User.class,1L);

		System.err.println("Username:" + john.getUsername() + " Password:"
				+ john.getPassword().getPassword() + " Clear text password:"
				+ john.getPassword().getClearText());
	}
}
