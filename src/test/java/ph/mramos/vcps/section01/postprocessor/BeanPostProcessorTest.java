package ph.mramos.vcps.section01.postprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ph.mramos.vcps.section01.postprocessor.bean.SampleBeanPostProcessorConfig;

@SpringJUnitConfig(classes = SampleBeanPostProcessorConfig.class)
public class BeanPostProcessorTest {

	@Autowired
	private ApplicationContext appContext;

	@Test
	public void test_bean_post_processor() {
		System.out.println(appContext.getBeanDefinitionCount());
	}

}
