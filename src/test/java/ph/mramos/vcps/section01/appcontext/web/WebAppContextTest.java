package ph.mramos.vcps.section01.appcontext.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import ph.mramos.vcps.section01.appcontext.nonweb.SampleNonWebConfig;

@SpringJUnitWebConfig(classes = { SampleNonWebConfig.class, SampleWebConfig.class, SampleController.class })
public class WebAppContextTest {

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private SampleController sampleController;

	@Test
	public void test_webAppContext() {
		System.out.println(appContext);
		System.out.println(sampleController.doGet());
	}

}
