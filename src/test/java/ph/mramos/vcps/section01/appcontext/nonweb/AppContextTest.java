package ph.mramos.vcps.section01.appcontext.nonweb;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContextTest {

	@Test
	public void test_create_appContext_instance_through_configuration_classes() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SampleNonWebConfig.class);
		
		SampleNonWebBean bean1 = appContext.getBean(SampleNonWebBean.class);
		bean1.run();
		
		SampleNonWebBean bean2 = (SampleNonWebBean) appContext.getBean("sampleBean");
		bean2.run();
		
		System.out.println(bean1 == bean2);
	}
	
	@Test
	public void test_create_appContext_instance_through_base_packages() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext("ph.mramos.vcps.section01.appcontext.nonweb"); // Includes sub packages.
		
		SampleNonWebBean bean1 = appContext.getBean(SampleNonWebBean.class);
		bean1.run();
		
		SampleNonWebBean bean2 = (SampleNonWebBean) appContext.getBean("sampleBean");
		bean2.run();
		
		System.out.println(bean1 == bean2);
	}
	
}
