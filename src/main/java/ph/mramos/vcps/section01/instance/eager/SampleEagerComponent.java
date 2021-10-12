package ph.mramos.vcps.section01.instance.eager;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SampleEagerComponent implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleEagerComponent#afterPropertiesSet");
	}

	public void run() {
		System.out.println("SampleEagerComponent#run");
	}

}
