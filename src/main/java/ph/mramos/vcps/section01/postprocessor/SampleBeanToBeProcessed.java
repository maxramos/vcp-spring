package ph.mramos.vcps.section01.postprocessor;

import org.springframework.beans.factory.InitializingBean;

public class SampleBeanToBeProcessed implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleBeanToBeProcessed#afterPropertiesSet");
	}

}
