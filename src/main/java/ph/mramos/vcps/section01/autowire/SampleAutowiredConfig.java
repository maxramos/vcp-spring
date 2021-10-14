package ph.mramos.vcps.section01.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan
public class SampleAutowiredConfig {

	@Bean
	public SampleAutowiredBean0 sampleAutowiredBean0Instance1() {
		return new SampleAutowiredBean0(1);
	}

	@Primary
	@Bean
	public SampleAutowiredBean1 sampleAutowiredBean1Instance1() {
		return new SampleAutowiredBean1(1);
	}

	@Bean
	public SampleAutowiredBean1 sampleAutowiredBean1Instance2() {
		return new SampleAutowiredBean1(2);
	}

	@Bean
	public SampleAutowiredBean2 sampleAutowiredBean2Instance1() {
		return new SampleAutowiredBean2(1);
	}

	@Bean
	public SampleAutowiredBean2 sampleAutowiredBean2Instance2() {
		return new SampleAutowiredBean2(2);
	}

	@Bean
	@Order(2) // @Order takes precedence over the Ordered interface when both are present. @Priority from JavaEE can be an alternative.
	public SampleAutowiredBean3 sampleAutowiredBean3Instance1() {
		return new SampleAutowiredBean3(1);
	}

	@Bean
	@Order(1) // @Order takes precedence over the Ordered interface when both are present. @Priority from JavaEE can be an alternative.
	public SampleAutowiredBean3 sampleAutowiredBean3Instance2() {
		return new SampleAutowiredBean3(2);
	}

}
