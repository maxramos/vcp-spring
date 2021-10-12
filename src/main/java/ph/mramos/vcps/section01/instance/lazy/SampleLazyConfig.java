package ph.mramos.vcps.section01.instance.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan
public class SampleLazyConfig {

	@Lazy
	@Bean
	public SampleLazyBean sampleLazyBean() {
		return new SampleLazyBean();
	}

}
