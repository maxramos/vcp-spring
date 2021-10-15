package ph.mramos.vcps.section01.propertysource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SamplePropertySourceConfig.class)
@TestPropertySource(
		locations = "classpath:/config/application-test.properties", // Overrides value in application.properties
		properties = "sample.key.web=Sample Test Key Web") // Overrides value in web.properties
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
