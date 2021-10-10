package ph.mramos.vcps.section01.appcontext.nonweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleNonWebConfig {

	@Bean
	public SampleNonWebBean sampleBean() {
		return new SampleNonWebBean();
	}
	
}
