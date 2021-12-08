package ph.mramos.vcps.section01.order;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SampleOrderComponent3 implements InitializingBean, SampleOrderComponentInterface {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleOrderComponent3#afterPropertiesSet");
	}

	@Override
	public void run() {
		System.out.println("SampleOrderComponent3#run");
	}

}
