package ph.mramos.vcps.section01.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleOrderConfig.class)
public class OrderTest {

	@Autowired
	private List<SampleOrderBeanInterface> sampleOrderBeanInterfaces;

	@Autowired
	private List<SampleOrderComponentInterface> sampleOrderComponentInterface;

	@Test
	public void testOrder() {
		sampleOrderBeanInterfaces.forEach(SampleOrderBeanInterface::run);
		sampleOrderComponentInterface.forEach(SampleOrderComponentInterface::run);
	}

}
