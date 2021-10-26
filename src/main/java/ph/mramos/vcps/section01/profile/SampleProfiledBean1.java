package ph.mramos.vcps.section01.profile;

import org.springframework.beans.factory.InitializingBean;

public class SampleProfiledBean1 implements InitializingBean, SampleProfiledBeanInterface {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleProfiledBean1#afterPropertiesSet");
	}

	@Override
	public void run() {
		System.out.println("SampleProfiledBean1#run");
	}

}
