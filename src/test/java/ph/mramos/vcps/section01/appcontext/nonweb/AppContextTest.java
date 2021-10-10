package ph.mramos.vcps.section01.appcontext.nonweb;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContextTest {

	@Test
	public void test_create_appContext_instance_through_configuration_classes() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SampleNonWebConfig.class, SampleNonWebObj.class);
		
		SampleNonWebBean bean1 = appContext.getBean(SampleNonWebBean.class);
		bean1.run();
		
		SampleNonWebBean bean2 = (SampleNonWebBean) appContext.getBean("sampleBean");
		bean2.run();
		
		System.out.println("Bean: " + (bean1 == bean2));

		SampleNonWebObj obj1 = appContext.getBean(SampleNonWebObj.class);
		obj1.run();
		
		SampleNonWebObj obj2 = (SampleNonWebObj) appContext.getBean("sampleNonWebObj");
		obj2.run();
		
		System.out.println("Obj: " + (obj1 == obj2));
	}
	
	@Test
	public void test_create_appContext_instance_through_base_packages() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext("ph.mramos.vcps.section01.appcontext.nonweb"); // Includes sub packages.
		
		SampleNonWebBean bean1 = appContext.getBean(SampleNonWebBean.class);
		bean1.run();
		
		SampleNonWebBean bean2 = (SampleNonWebBean) appContext.getBean("sampleBean");
		bean2.run();
		
		System.out.println("Bean: " + (bean1 == bean2));
		
		SampleNonWebComponent component1 = appContext.getBean(SampleNonWebComponent.class);
		component1.run();
		
		SampleNonWebComponent component2 = (SampleNonWebComponent) appContext.getBean("sampleNonWebComponent");
		component2.run();
		
		System.out.println("Component: " + (component1 == component2));
	}
	
}
