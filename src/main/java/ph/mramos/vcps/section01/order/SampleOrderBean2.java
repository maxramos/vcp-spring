package ph.mramos.vcps.section01.order;

import org.springframework.beans.factory.InitializingBean;

public class SampleOrderBean2 implements InitializingBean, SampleOrderBeanInterface {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleOrderBean2#afterPropertiesSet");
	}

	@Override
	public void run() {
		System.out.println("SampleOrderBean2#run");
	}

}
