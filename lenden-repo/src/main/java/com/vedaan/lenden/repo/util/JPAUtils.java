/**
 * 
 */
package com.vedaan.lenden.repo.util;

/**
 * @author mayank
 *
 */
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-mysql.properties" })
@ComponentScan({ "com.vedaan.lenden" })
@EnableJpaRepositories(basePackages = "com.vedaan.lenden")
public class JPAUtils {

	@Autowired
	private Environment env;
	private final String PACKAGES_TO_SCAN = "com.vedaan.lenden";

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDataSource());
		em.setPackagesToScan(PACKAGES_TO_SCAN);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	@Scope("singleton")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	public Properties additionalProperties() {
		return new Properties() {
			private static final long serialVersionUID = -4496310006095041101L;

			{

				setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));

				setProperty("hibernate.globally_quoted_identifiers",
						env.getProperty("hibernate.globally_quoted_identifiers"));

				setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

				setProperty("hibernate.bytecode.use_reflection_optimizer ",
						env.getProperty("hibernate.bytecode.use_reflection_optimizer"));

				setProperty("cache.provider_class", env.getProperty("cache.provider_class"));

				setProperty("current_session_context_class", env.getProperty("current_session_context_class"));

				setProperty("hibernate.globally_quoted_identifiers",
						env.getProperty("hibernate.globally_quoted_identifiers"));

			}
		};
	}
}
