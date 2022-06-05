package ph.mramos.vcps.section01.postprocessor.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * PropertySourcesPlaceholderConfigurer is another example of BeanFactoryPostProcessor that enables the processing of @Value("${}")
 */
//@Component
//@Order(1) // Can use this when @Component is being used.
public class SampleBeanFactoryPostProcessor implements BeanFactoryPostProcessor, InitializingBean/*, Ordered*/ { // Ordered can be implemented instead of annotating with @Order

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleBeanFactoryPostProcessor#afterPropertiesSet");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println();
		System.out.println("SampleBeanFactoryPostProcessor#postProcessBeanFactory");
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("sampleBeanToBeProcessed");
		System.out.println(beanDefinition.getFactoryBeanName()); // The @Configuration annotated class, not the actual bean definition.
		System.out.println(beanDefinition.getFactoryMethodName()); // The @Bean annotated method.
		System.out.println(beanDefinition.getResolvableType()); // Class of sampleBeanToBeProcessed.
		beanDefinition.setLazyInit(true); // If uncommented then bean instantiation is lazy.
		System.out.println();
	}

//	@Override
//	public int getOrder() {
//		return 1;
//	}

}
