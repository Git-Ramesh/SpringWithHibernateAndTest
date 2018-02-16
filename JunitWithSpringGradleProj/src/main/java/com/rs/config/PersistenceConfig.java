package com.rs.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@ComponentScan(basePackages="com.rs.dao")
public class PersistenceConfig {
	
	
	@Bean
	public SessionFactory sessionFactory() {
		System.out.println("sessionFactory()");
		return new LocalSessionFactoryBuilder(dataSource()).buildSessionFactory();
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	@Bean
	public JndiObjectFactoryBean jndiObjectFactoryBean() {
		JndiObjectFactoryBean jofb=null;
		
		jofb=new JndiObjectFactoryBean();
		jofb.setResourceRef(true);
		jofb.setJndiName("DsJndi");
		
		return jofb;
	}
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		return new HibernateTransactionManager(sessionFactory()); 
	}
	@Bean
	@Primary
	public DataSource dataSource() {
		return (DataSource) jndiObjectFactoryBean().getObject();
	}
}
