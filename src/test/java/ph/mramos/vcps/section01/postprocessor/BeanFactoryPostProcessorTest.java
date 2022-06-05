package ph.mramos.vcps.section01.postprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ph.mramos.vcps.section01.postprocessor.beanfactory.SampleBeanFactoryPostProcessorConfig;

@SpringJUnitConfig(classes = SampleBeanFactoryPostProcessorConfig.class)
public class BeanFactoryPostProcessorTest {

	@Autowired
	private ApplicationContext appContext;

	@Test
	public void test_bean_factory_post_processor() {
		System.out.println(appContext.getBeanDefinitionCount());
		appContext.getBean(SampleBeanToBeProcessed.class); // If beanDefinition.setLazyInit(true) then SampleBeanToBeProcessed will only be instantiated at this point.
	}

}
