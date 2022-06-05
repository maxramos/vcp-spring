package ph.mramos.vcps.section01.postprocessor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
//@Order(1) // Can use this when @Component is being used.
public class SampleBeanPostProcessor implements BeanPostProcessor, InitializingBean/*, Ordered*/ { // Ordered can be implemented instead of annotating with @Order

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleBeanPostProcessor#afterPropertiesSet");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println();
		System.out.println("SampleBeanPostProcessor#postProcessBeforeInitialization");


		if ("sampleBeanToBeProcessed".equals(beanName)) {
			System.out.println("BEFORE - MATCHED: " + beanName + " : " + bean);
		} else {
			System.out.println("BEFORE - NOT MATCHED: " + beanName + " : " + bean);
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SampleBeanPostProcessor#postProcessAfterInitialization");

		if ("sampleBeanToBeProcessed".equals(beanName)) {
			System.out.println("ATER - MATCHED: " + beanName + " : " + bean);
		} else {
			System.out.println("AFTER - NOT MATCHED: " + beanName + " : " + bean);
		}

		System.out.println();
		return bean;
	}

//	@Override
//	public int getOrder() {
//		return 1;
//	}

}
