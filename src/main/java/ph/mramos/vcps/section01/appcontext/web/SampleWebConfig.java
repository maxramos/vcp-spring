package ph.mramos.vcps.section01.appcontext.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleWebConfig {

	@Bean
	public SampleWebBean sampleWebBean() {
		return new SampleWebBean();
	}
	
}
