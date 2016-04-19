package be.groept.util;

import be.groept.ie4.entities.*;
import be.groept.ie4.entities.types.Password;
import org.hibernate.SessionFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

public class InitialDataSetup {

	private TransactionTemplate transactionTemplate;
	private SessionFactory sessionFactory;

	public InitialDataSetup(TransactionTemplate transactionTemplate,
			SessionFactory sessionFactory) {
		this.transactionTemplate = transactionTemplate;
		this.sessionFactory = sessionFactory;
	}

	public void initData() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				// Setup test data
				{
					Eshop eshop = new Eshop();
					eshop.setName("mijn eshop");
					sessionFactory.getCurrentSession().save(eshop);

					Customer cust1 = new Customer();
					cust1.setFirstname("Thomas");
					cust1.setName("Vermaelen");
					cust1.setPassword(new Password("thomas"));
					cust1.setUsername("THOVER");
					sessionFactory.getCurrentSession().save(cust1);

					Customer cust2 = new Customer();
					cust2.setFirstname("Romelu");
					cust2.setName("Lukaku");
					cust2.setPassword(new Password("romelu"));
					cust2.setUsername("ROMLUK");
					sessionFactory.getCurrentSession().save(cust2);

					Product prod1 = new Product();
					prod1.setName("stofzuiger Dyson Animal");
					prod1.setNumberInStock(112);
					prod1.setPrice(new BigDecimal(1000));
					prod1.setShortname("Dyson");
					sessionFactory.getCurrentSession().save(prod1);

					Product prod2 = new Product();
					prod2.setName("stofzuiger ElectroLux Green");
					prod2.setNumberInStock(52);
					prod2.setPrice(new BigDecimal(1200));
					prod2.setShortname("ElectroLux");
					sessionFactory.getCurrentSession().save(prod2);

					Product prod3 = new Product();
					prod3.setName("Apple ipad mini air");
					prod3.setNumberInStock(46);
					prod3.setPrice(new BigDecimal(700.99));
					prod3.setShortname("ipad mini");
					sessionFactory.getCurrentSession().save(prod3);

					Product prod4 = new Product();
					prod4.setName("Samsung Galaxy S4");
					prod4.setNumberInStock(850);
					prod4.setPrice(new BigDecimal(800.99));
					prod4.setShortname("Galaxy");
					sessionFactory.getCurrentSession().save(prod4);

					Product prod5 = new Product();
					prod5.setName("Whirlpool flux oven HS457");
					prod5.setNumberInStock(14);
					prod5.setPrice(new BigDecimal(2500.05));
					prod5.setShortname("Whirlpool");
					sessionFactory.getCurrentSession().save(prod5);

					Order order1 = new Order();
					order1.setEshop(eshop);
					order1.setOrderTotal(new BigDecimal(13902.23));
					order1.setPaymentMethod("credit card");
					sessionFactory.getCurrentSession().save(order1);

					OrderDetail orderdetail1 = new OrderDetail();
					orderdetail1.setAmount(new BigDecimal(2));
					orderdetail1.setOrder(order1);
					orderdetail1.setProduct(prod3);
					orderdetail1.setTotal(new BigDecimal(1401.98));
					sessionFactory.getCurrentSession().save(orderdetail1);

					OrderDetail orderdetail2 = new OrderDetail();
					orderdetail2.setAmount(new BigDecimal(5));
					orderdetail2.setOrder(order1);
					orderdetail2.setProduct(prod5);
					orderdetail2.setTotal(new BigDecimal(12500.25));
					sessionFactory.getCurrentSession().save(orderdetail2);


				}
			}
		});
	}

	public void tearDown() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
			}
		});
	}
}
