package ph.mramos.vcps.section01.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test1")
@Configuration
@ComponentScan
public class SampleProfiledConfig1 {

	@Bean // // Must have both profile: test1 to be executed.
	public SampleProfiledBeanInterface sampleProfiledBean1() {
		return new SampleProfiledBean1();
	}

	@Profile("test2") // Must have both profiles: test1, test2 to be executed.
	@Bean
	public SampleProfiledBeanInterface sampleProfiledBean2() {
		return new SampleProfiledBean2();
	}

}
