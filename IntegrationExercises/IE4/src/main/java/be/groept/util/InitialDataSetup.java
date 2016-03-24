package be.groept.util;

import org.hibernate.SessionFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import be.groept.ie4.entities.Eshop;

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
