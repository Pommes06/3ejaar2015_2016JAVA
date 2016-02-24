package be.groept.hibernate.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.testng.annotations.Test;

import be.groept.hibernate.entities.caching.Description;
import be.groept.hibernate.entities.caching.DescriptionTranslation;
import be.groept.hibernate.entities.caching.Item;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CachingTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@SuppressWarnings("all")
	public void testCaching() {

		// -BEGIN DATA SETUP -- must run in a separate transaction to demonstrate the caching in a single test
		TransactionTemplate transactionTemplate= new TransactionTemplate(platformTransactionManager);
		transactionTemplate.setPropagationBehavior(TransactionTemplate.PROPAGATION_REQUIRES_NEW);
		transactionTemplate.execute(new TransactionCallback<Void>() {
			@Override
			public Void doInTransaction(TransactionStatus status) {
				Item item = new Item();
				Description description = new Description();
				DescriptionTranslation descriptionTranslation = new DescriptionTranslation();
				descriptionTranslation.setLanguage("NL");
				descriptionTranslation.setTranslation("testing");
				description.getTranslations().add(descriptionTranslation);
				item.setItemDescription(description);
				sessionFactory.getCurrentSession().save("CachedItem", item);
				return null;
			}
		});
		// -END DATA SETUP

		Session session = sessionFactory.getCurrentSession();

		// ----------2ND LEVEL CACHE EXAMPLE---------
		// Triggers a query to load the item
		Item item = (Item) session.get("CachedItem", new Long(1));
		// Triggers two queries, one for the description, another for the translation
		item.getItemDescription().getTranslations().iterator().next()
				.getTranslation();
		// Clear the session: removes everything from first level cache (but NOT the second level!)
		session.clear();

		// No more queries!
		item = (Item) session.get("CachedItem", new Long(1));
		item.getItemDescription().getTranslations().iterator().next()
				.getTranslation();

		// Clear second level cache so we can prove that the caching really worked
		session.clear();
		sessionFactory.getCache().evictAllRegions(); //<--- clear the second level cache, you normally never do this

		// We will now again see queries, since the 2nd level cache was cleared
		item = (Item) session.get("CachedItem", new Long(1));
		item.getItemDescription().getTranslations().iterator().next()
				.getTranslation();

		// Clear everything up again so we can start cleanly for the next test
		session.clear();
		sessionFactory.getCache().evictAllRegions();
		
		item = (Item) session.get("CachedItem", new Long(1));
		item.getItemDescription().getTranslations().iterator().next()
				.getTranslation();

		session.clear();
		sessionFactory.getCache().evictAllRegions();
		// ----------QUERY CACHE EXAMPLE---------

		// Triggers a query
		List<Item> items = session.createQuery("from CachedItem")
				.list();
		// Triggers another two queries to load the description and the translations
		items.iterator().next().getItemDescription().getTranslations()
				.iterator().next();

		// Clear the session: removes everything from first level cache
		session.clear();

		// Doing the same but with CACHEABLE set to true
		// This will trigger a query just like the previous example
		items = session.createQuery("from CachedItem")
				.setCacheable(true).list();
		// No more queries here ! getting the values from second level cache
		items.iterator().next().getItemDescription().getTranslations()
				.iterator().next();

		// Clear the session: removes everything from first level cache
		session.clear();
		
		// Does not trigger a query anymore, query is now served from cache
		// and the id's returned from cache are pulled from 2nd level cache
		items = session.createQuery("from CachedItem")
				.setCacheable(true).list();
		items.iterator().next().getItemDescription().getTranslations()
				.iterator().next();

	}
}
