package ph.mramos.vcps.section01.instance.eager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SampleEagerConfig {

	@Bean
	public SampleEagerBean sampleEagerBean() {
		return new SampleEagerBean();
	}

}
