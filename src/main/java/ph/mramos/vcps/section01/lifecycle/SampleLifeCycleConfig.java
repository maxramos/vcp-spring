package ph.mramos.vcps.section01.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleLifeCycleConfig {

	/**
	 * Called for singleton beans but not necessarily for prototype beans.
	 */
	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod") // destroyMethod, when not specified is implicitly set to either close or shutdown.
	public SampleLifeCycleBean sampleLifeCycleBean() {
		return new SampleLifeCycleBean();
	}

}
