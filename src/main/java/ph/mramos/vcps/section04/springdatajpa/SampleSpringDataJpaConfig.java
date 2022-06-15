package ph.mramos.vcps.section04.springdatajpa;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories // By default picks up classes that extends Repository or one of its sub interfaces starting from the package where this config is located.
@ComponentScan(basePackages = "ph.mramos.vcps.section04.springdatajpa.service")
public class SampleSpringDataJpaConfig {

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource ("jdbc:mysql://localhost:3306/spring_cert", "admin", "giselles");
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		return dataSource;
//	}

	@Bean // Uncomment H2 maven dependency when using embedded database.
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addDefaultScripts() // classpath:schema.sql and classpath:data.sql
				.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() { // Name should be entityManagerFactory() to match the default value in @EnableJpaRepositories.
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
//		factoryBean.setPersistenceUnitName("default"); // Set a persistence unit name if there are mulitple entity manager factory.
		factoryBean.setPackagesToScan("ph.mramos.vcps.section03.entity");
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		return factoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager() { // Name should be transactionManager() to match the default value in @EnableJpaRepositories.
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

}
