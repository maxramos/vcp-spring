package ph.mramos.vcps.section03.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class SampleDataSourceConfig {

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/spring_cert", "admin", "giselles"); // com.mysql.cj.jdbc.Driver or com.mysql.jdbc.Driver (deprecated)
	}
//
//	@Bean // Uncomment H2 maven dependency when using embedded database.
	public DataSource embeddedDataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addDefaultScripts() // classpath:schema.sql and classpath:data.sql
				.build();
	}

}
