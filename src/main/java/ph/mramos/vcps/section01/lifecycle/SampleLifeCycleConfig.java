package ph.mramos.vcps.section01.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleLifeCycleConfig {

	@Bean(initMethod = "init", destroyMethod = "close")
	public SampleLifeCycleBean sampleLifeCycleBean() {
		return new SampleLifeCycleBean();
	}

}
