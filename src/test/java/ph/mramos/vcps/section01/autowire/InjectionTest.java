package ph.mramos.vcps.section01.autowire;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleAutowiredConfig.class)
public class InjectionTest {

	@Autowired
	private SampleInjectionComponent sampleInjectionComponent;

	@Test
	public void test_injection() {
		sampleInjectionComponent.run();
	}

}
