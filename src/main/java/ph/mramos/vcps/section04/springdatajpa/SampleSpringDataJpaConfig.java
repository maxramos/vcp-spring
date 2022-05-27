package ph.mramos.vcps.section04.springdatajpa;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan(basePackages = "ph.mramos.vcps.section04.springdatajpa.service")
public class SampleSpringDataJpaConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource ("jdbc:mysql://localhost:3306/spring_cert", "admin", "giselles");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
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
