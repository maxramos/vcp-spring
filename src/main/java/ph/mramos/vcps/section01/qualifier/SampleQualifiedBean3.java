package ph.mramos.vcps.section01.qualifier;

import org.springframework.beans.factory.InitializingBean;

public class SampleQualifiedBean3 implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleQualifiedBean3#afterPropertiesSet");
	}

	public void run() {
		System.out.println("SampleQualifiedBean3#run");
	}

}
