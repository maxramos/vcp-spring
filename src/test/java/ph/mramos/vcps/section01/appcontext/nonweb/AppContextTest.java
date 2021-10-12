package ph.mramos.vcps.section01.appcontext.nonweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = { SampleNonWebConfig.class, SampleNonWebObj.class })
public class AppContextTest {

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private SampleNonWebBean sampleNonWebBean;

	@Autowired
	private SampleNonWebObj sampleNonWebObj;

	@Test
	public void test_app_context() {
		sampleNonWebBean.run();

		SampleNonWebBean bean1 = appContext.getBean(SampleNonWebBean.class);
		bean1.run();

		SampleNonWebBean bean2 = (SampleNonWebBean) appContext.getBean("sampleNonWebBean");
		bean2.run();

		System.out.println("Bean == Bean1: " + (sampleNonWebBean == bean1));
		System.out.println("Bean1 == Bean2: " + (bean1 == bean2));

		sampleNonWebObj.run();

		SampleNonWebObj obj1 = appContext.getBean(SampleNonWebObj.class);
		obj1.run();

		SampleNonWebObj obj2 = (SampleNonWebObj) appContext.getBean("sampleNonWebObj");
		obj2.run();

		System.out.println("Obj == Obj1: " + (sampleNonWebObj == obj1));
		System.out.println("Obj1 == Obj2: " + (obj1 == obj2));
	}

}
