package ph.mramos.vcps.section01.instance.lazy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleLazyConfig.class)
public class LazyInstanceTest {

	@Autowired
	private ApplicationContext appContext;

	@Test
	public void test_lazy_instance() {
		System.out.println("Lazy Instance Test"); // Should be executed first.
		appContext.getBean(SampleLazyBean.class);
		appContext.getBean(SampleLazyComponent.class);
	}

}
