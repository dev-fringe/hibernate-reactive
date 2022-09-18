package dev.fringe.hibenate.reactive;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableTransactionManagement
public class HibernateConfig {

//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean f = new LocalSessionFactoryBean();
//		f.setDataSource(datasource());
//		f.setHibernateProperties(hibernateProperties());
//		f.setPackagesToScan("hibernate.config.java");
//		return f;
//	}
//
//	@Bean
//	public HibernateTransactionManager transactionManager() {
//		HibernateTransactionManager t = new HibernateTransactionManager();
//		t.setSessionFactory(sessionFactory().getObject());
//		return t;
//	}

//	@Bean
//	public Mutiny.SessionFactory sessionFactory() {
//		return Persistence.createEntityManagerFactory("ReactivePU").unwrap(Mutiny.SessionFactory.class);
//	}
//	
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("ReactivePU");
    }

    @Bean
    public Mutiny.SessionFactory reactiveSessionFactory(final EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.unwrap(Mutiny.SessionFactory.class);
    }

    @Bean
    public Stage.SessionFactory futureSessionFactory(final EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.unwrap(Stage.SessionFactory.class);
    }

    private static class Wrapper {
        EntityManagerFactory entityManagerFactory;
    }
//}
//	@Bean
//	public DataSource datasource() {
//		HikariConfig c = new HikariConfig();
//		c.setDriverClassName("org.mariadb.jdbc.Driver");
//		c.setJdbcUrl("jdbc:mariadb://localhost:3306/test");
//		c.setUsername("hdlee");
//		c.setPassword("moby3776");
//		return new HikariDataSource(c);
//	}
//
//	private Properties hibernateProperties() {
//		return new Properties() {
//			private static final long serialVersionUID = 1L;
//			{
//				setProperty("hibernate.hbm2ddl.auto", "update");
//				setProperty("hibernate.show_sql", "true");
//				setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB53Dialect");
//				setProperty("hibernate.jdbc.time_zone", "Asia/Seoul");
//				setProperty("format_sql", "true");
//				setProperty("show_sql", "true");
//			}
//		};
//	}

}
