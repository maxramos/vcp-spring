package ph.mramos.vcps.section01.componentscan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ph.mramos.vcps.section01.componentscan.scannable.SampleScannableBean;
import ph.mramos.vcps.section01.componentscan.scannable.SampleScannableComponent;

@SpringJUnitConfig(classes = SampleScannableConfig.class)
public class ComponentScanTest {

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private SampleScannableBean sampleScannableBean;

	@Autowired
	private SampleScannableComponent sampleScannableComponent;

	@Test
	public void test_component_scan() {
		sampleScannableBean.run();
		sampleScannableComponent.run();
		System.out.println(appContext.containsBean("includedRepository"));
		System.out.println(appContext.containsBean("excludedService"));
	}

}
