package ph.mramos.vcps.section01.instance.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan
public class SampleLazyConfig {

	@Lazy // Can be applied to @Autowired field, in that case the field is not yet injected with an actual instance until it's actually used.
	@Bean
	public SampleLazyBean sampleLazyBean() {
		return new SampleLazyBean();
	}

}
