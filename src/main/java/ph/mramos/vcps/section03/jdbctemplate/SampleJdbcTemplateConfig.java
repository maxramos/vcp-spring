package ph.mramos.vcps.section03.jdbctemplate;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * - @EnableTransactionManagement enables the use of @Transactional.
 * - If @EnableTransactionManagement is missing then methods annotated with @Transactional will not run under a transaction and it will not throw an error.
 */
@Configuration
@EnableTransactionManagement // Must be applied only once. Should applied to @Configuration file. Enables annotation driven transaction management.
public class SampleJdbcTemplateConfig {

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
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager transactionManager() { // If @Transactional is present then PlatformTransactionManager must be present as a bean otherwise an error will be thrown.
		return new DataSourceTransactionManager(dataSource()); // Alternative to JpaTransactionManager when not using JPA.
	}

}
