package ph.mramos.vcps.section01.el;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleELConfig.class)
public class SampleELTest {

	@Autowired
	private SampleELComponent1 sampleELComponent1;

	@Test
	public void testEL() {
		sampleELComponent1.run();
	}

}
