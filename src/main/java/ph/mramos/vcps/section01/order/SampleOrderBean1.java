package ph.mramos.vcps.section01.order;

import org.springframework.beans.factory.InitializingBean;

public class SampleOrderBean1 implements InitializingBean, SampleOrderBeanInterface {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleOrderBean1#afterPropertiesSet");
	}

	@Override
	public void run() {
		System.out.println("SampleOrderBean1#run");
	}

}
