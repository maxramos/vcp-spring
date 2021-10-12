package ph.mramos.vcps.section01.instance.eager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleEagerConfig.class)
public class EagerInstanceTest {

	@Autowired
	private ApplicationContext appContext;

	@Test
	public void test_eager_instance() {
		System.out.println("Should be executed last."); // Should be executed last.
		appContext.getBean(SampleEagerBean.class);
		appContext.getBean(SampleEagerComponent.class);
	}

}
