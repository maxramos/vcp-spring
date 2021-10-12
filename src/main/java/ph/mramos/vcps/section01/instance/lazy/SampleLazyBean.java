package ph.mramos.vcps.section01.instance.lazy;

import org.springframework.beans.factory.InitializingBean;

public class SampleLazyBean implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleLazyBean#afterPropertiesSet");
	}

	public void run() {
		System.out.println("SampleLazyBean#run");
	}

}
