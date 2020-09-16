package com.linkdev.todolist.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement /* Spring container sẽ quản lý transaction == (đóng mở connection) */
@PropertySource({ "classpath:datasource-conf.properties" })
public class JPAConf {
	@Autowired
	private Environment env; // Contains Properties Load by @PropertySource

	@Bean
	protected DataSource dataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(env.getProperty("db.mysql.driver"));
		dataSourceConfig.setJdbcUrl(env.getProperty("db.mysql.url"));
		dataSourceConfig.setUsername(env.getProperty("db.mysql.username"));
		dataSourceConfig.setPassword(env.getProperty("db.mysql.password"));
		return new HikariDataSource(dataSourceConfig);
		// HikariConfig giúp tạo connection pool(tạo sẵn 100db trong database(mysql tối
		// đa 200db))
	}

	@Bean
	protected LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		Properties jpaProperties = new Properties();
		// Configures the used database dialect. This allows Hibernate to create SQL
		// that is optimized for the used database.
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		// Specifies the action that is invoked to the database when the Hibernate
		// SessionFactory is created or closed.
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		// Configures the naming strategy that is used when Hibernate creates new
		// database objects and schema elements
		jpaProperties.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
		// If the value of this property is true, Hibernate writes all SQL statements to
		// the console.
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		// If the value of this property is true, Hibernate will format the SQL that is
		// written to the console.
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());// Nhà cung cấp, kho chứa

		// package chứa các entities.
		entityManagerFactoryBean.setPackagesToScan("com.linkdev.todolist");
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	}

	@Bean
	protected JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
