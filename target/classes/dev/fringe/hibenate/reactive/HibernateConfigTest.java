package dev.fringe.hibenate.reactive;

import org.hibernate.reactive.mutiny.Mutiny;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HibernateConfig.class)
public class HibernateConfigTest {
	
	@Autowired
	private Mutiny.SessionFactory sessionFactory;
	
	@Test
	public void retrieveAccount() {
		Account a = sessionFactory.withSession(session -> session.find(Account.class, 1L).onItem().invoke( account ->{})
		).await().indefinitely();
		Assert.assertEquals(a.getCashBalance(), 500.0, 0.01);
	}
}
