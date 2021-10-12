package ph.mramos.vcps.section01.instance.eager;

import org.springframework.beans.factory.InitializingBean;

public class SampleEagerBean implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleEagerBean#afterPropertiesSet");
	}

	public void run() {
		System.out.println("SampleEagerBean#run");
	}

}
