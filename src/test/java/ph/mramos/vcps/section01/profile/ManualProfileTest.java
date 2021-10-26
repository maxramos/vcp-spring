package ph.mramos.vcps.section01.profile;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ManualProfileTest {

	@Test
	public void test_profile() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
//		appContext.getEnvironment().setActiveProfiles("test1");
		appContext.getEnvironment().setActiveProfiles("test0", "test4");
		appContext.scan("ph.mramos.vcps.section01.profile");
		appContext.refresh();

		SampleProfiledBeanInterface sampleProfiledBeanInterface = appContext.getBean(SampleProfiledBeanInterface.class);
		SampleProfiledComponentInterface sampleProfiledComponentInterface = appContext.getBean(SampleProfiledComponentInterface.class);

		sampleProfiledBeanInterface.run();
		sampleProfiledComponentInterface.run();
	}

}
