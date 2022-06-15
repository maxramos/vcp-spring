package ph.mramos.vcps.section03.jpa_transaction;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* - @EnableTransactionManagement enables the use of @Transactional.
* - If @EnableTransactionManagement is missing then even if a method is annotated by @Transactional it will throw an error (TransactionRequiredException).
*/
@Configuration
@EnableTransactionManagement // Must be applied only once. Should applied to @Configuration file. Enables annotation driven transaction management.
public class SampleJpaTransactionConfig {

//	@Bean
//	public DataSource dataSource() {
//		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/spring_cert", "admin", "giselles");
//	}

	@Bean // Uncomment H2 maven dependency when using embedded database.
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addDefaultScripts() // classpath:schema.sql and classpath:data.sql
				.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() { // Has a counterpart LocalEntityManagerFactoryBean but has no datasource setter.
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("ph.mramos.vcps.section03.entity");
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		return factoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager() { // If @Transactional is present then PlatformTransactionManager must be present as a bean otherwise an error will be thrown.
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

}
