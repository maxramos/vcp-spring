package ph.mramos.vcps.section01.postprocessor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
public class SampleBeanPostProcessor implements BeanPostProcessor, InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleBeanPostProcessor#afterPropertiesSet");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SampleBeanPostProcessor#postProcessBeforeInitialization");

		if ("sampleBeanToBeProcessed".equals(beanName)) {
			System.out.println(beanName + " : " + bean);
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SampleBeanPostProcessor#postProcessAfterInitialization");

		if ("sampleBeanToBeProcessed".equals(beanName)) {
			System.out.println(beanName + " : " + bean);
		}

		return bean;
	}

}
