package ph.mramos.vcps.section01.postprocessor.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ph.mramos.vcps.section01.postprocessor.SampleBeanToBeProcessed;

@Configuration
//@ComponentScan
public class SampleBeanFactoryPostProcessorConfig {

	@Bean
	public static SampleBeanFactoryPostProcessor sampleBeanFactoryPostProcessor() { // Use static method for BeanFactoryPostProcessor to initialize it earlier than other @Bean methods whose instances must be processed by this post processor.
		return new SampleBeanFactoryPostProcessor();
	}

	@Bean
	public SampleBeanToBeProcessed sampleBeanToBeProcessed() {
		return new SampleBeanToBeProcessed();
	}

}
