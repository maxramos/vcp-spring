package ph.mramos.vcps.section01.propertysource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource({
	"classpath:/config/application.properties", // Doesn't matter if it starts with '/' or not, it always relative to root classpath.
	"file:config/web.properties" // If it starts with '/' then it's an absolute path; if not then it's relative to the folder where the jar is being executed.
})
public class SamplePropertySourceConfig {

	@Bean
	public SamplePropertySourceBean samplePropertySourceBean() {
		return new SamplePropertySourceBean();
	}

}
