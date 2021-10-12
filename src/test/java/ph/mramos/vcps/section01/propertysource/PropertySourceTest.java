package ph.mramos.vcps.section01.propertysource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SamplePropertySourceConfig.class)
public class PropertySourceTest {

	@Autowired
	private SamplePropertySourceBean samplePropertySourceBean;

	@Autowired
	private SamplePropertySourceComponent samplePropertySourceComponent;

	@Test
	public void test_property_source() {
		samplePropertySourceBean.run();
		samplePropertySourceComponent.run();
	}

}
