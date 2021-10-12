package ph.mramos.vcps.section01.postprocessor.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ph.mramos.vcps.section01.postprocessor.SampleBeanToBeProcessed;

@Configuration
//@ComponentScan
public class SampleBeanFactoryPostProcessorConfig {

	@Bean
	public static SampleBeanFactoryPostProcessor sampleBeanFactoryPostProcessor() {
		return new SampleBeanFactoryPostProcessor();
	}

	@Bean
	public SampleBeanToBeProcessed sampleBeanToBeProcessed() {
		return new SampleBeanToBeProcessed();
	}

}
