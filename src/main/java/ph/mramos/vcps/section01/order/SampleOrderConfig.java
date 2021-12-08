package ph.mramos.vcps.section01.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * The use of the @Order only affects the order of an autowired list of beans (i.e. @Autowired).
 * It does not affect the instantiation order of Singleton beans.
 */
@Configuration
@ComponentScan
public class SampleOrderConfig {

	@Bean
	@Order(2)
	public SampleOrderBean1 sampleOrderBean1() {
		return new SampleOrderBean1();
	}

	@Bean
	@Order(3)
	public SampleOrderBean2 sampleOrderBean2() {
		return new SampleOrderBean2();
	}

	@Bean
	@Order(1)
	public SampleOrderBean3 sampleOrderBean3() {
		return new SampleOrderBean3();
	}

}
