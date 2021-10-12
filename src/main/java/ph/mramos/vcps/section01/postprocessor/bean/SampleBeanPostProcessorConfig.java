package ph.mramos.vcps.section01.postprocessor.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ph.mramos.vcps.section01.postprocessor.SampleBeanToBeProcessed;

@Configuration
//@ComponentScan
public class SampleBeanPostProcessorConfig {

	@Bean
	public static SampleBeanPostProcessor sampleBeanPostProcessor() {
		return new SampleBeanPostProcessor();
	}

	@Bean
	public SampleBeanToBeProcessed sampleBeanToBeProcessed() {
		return new SampleBeanToBeProcessed();
	}

}
