package ph.mramos.vcps.section01.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test0")
@Configuration
@ComponentScan
public class SampleProfiledConfig2 {

	@Profile("test3") // Must have both profiles: test0, test3 to be executed.
	@Bean
	public SampleProfiledBeanInterface sampleProfiledBean1() {
		return new SampleProfiledBean1();
	}

	@Profile("test4") // Must have both profiles: test0, test4 to be executed.
	@Bean
	public SampleProfiledBeanInterface sampleProfiledBean2() {
		return new SampleProfiledBean2();
	}

}
