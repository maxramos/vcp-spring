package ph.mramos.vcps.section01.lifecycle2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleLifeCycleConfig {

	@Bean
	public ChildSampleLifeCycleBean sampleLifeCycleBean() {
		return new ChildSampleLifeCycleBean();
	}

}
