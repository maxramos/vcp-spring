package ph.mramos.vcps.section01.propertysource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SamplePropertySourceConfig.class)
@TestPropertySource( // If locations and properties attributes are not specified then default to the property file with the same name as the enclosing class located at the same classpath (e.g. classpth:ph/mramos/vcps/section01/propertysource/PropertySourceTest.properties).
		locations = "classpath:/config/application-test.properties", // Overrides value in application.properties (for matching keys). Has higher precendence than @PropertySource and any other property sources.
		properties = "sample.key.web=Sample Test Key Web") // Overrides value in web.properties (for matching keys). Has higher precedence than the 'locations' attribute.
public class PropertySourceTest { // @TestPropertySource should be used with @ContextConfiguration or those annotations that has it as meta annotation (e.g. @SpringJUnitConfig, @SpringJUnitWebConfig).

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
