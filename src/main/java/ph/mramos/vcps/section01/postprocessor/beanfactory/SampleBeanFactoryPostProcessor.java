package ph.mramos.vcps.section01.postprocessor.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//@Component
public class SampleBeanFactoryPostProcessor implements BeanFactoryPostProcessor, InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleBeanFactoryPostProcessor#afterPropertiesSet");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("SampleBeanFactoryPostProcessor#postProcessBeanFactory");
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("sampleBeanToBeProcessed");
		System.out.println(beanDefinition.getFactoryBeanName()); // The @Configuration annotated class, not the actual bean definition.
	}

}
