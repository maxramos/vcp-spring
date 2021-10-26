package ph.mramos.vcps.section01.profile;

import org.springframework.beans.factory.InitializingBean;

public class SampleProfiledBean2 implements InitializingBean, SampleProfiledBeanInterface {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleProfiledBean2#afterPropertiesSet");
	}

	@Override
	public void run() {
		System.out.println("SampleProfiledBean2#run");
	}

}
