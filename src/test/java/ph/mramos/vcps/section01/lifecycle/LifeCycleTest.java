package ph.mramos.vcps.section01.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleLifeCycleConfig.class)
public class LifeCycleTest {

	@Autowired
	private SampleLifeCycleBean sampleLifeCycleBean;

	@Test
	public void test_life_cycle() {
		sampleLifeCycleBean.run();
	}

}
