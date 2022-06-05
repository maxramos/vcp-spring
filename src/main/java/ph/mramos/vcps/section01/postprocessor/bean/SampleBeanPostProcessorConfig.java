package ph.mramos.vcps.section01.postprocessor.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ph.mramos.vcps.section01.postprocessor.SampleBeanToBeProcessed;

@Configuration
//@ComponentScan
public class SampleBeanPostProcessorConfig {

	@Bean
	public static SampleBeanPostProcessor sampleBeanPostProcessor() { // Use static method for BeanPostProcessor to initialize it earlier than other @Bean methods whose instances must be processed by this post processor.
		return new SampleBeanPostProcessor(); // If this method is static then it will also process this very @Configration class.
	}

	@Bean
	public SampleBeanToBeProcessed sampleBeanToBeProcessed() {
		return new SampleBeanToBeProcessed();
	}

}
