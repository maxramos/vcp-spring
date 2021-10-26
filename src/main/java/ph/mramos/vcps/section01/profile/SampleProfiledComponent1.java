package ph.mramos.vcps.section01.profile;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({ "test1", "test3" })
@Component
public class SampleProfiledComponent1 implements InitializingBean, SampleProfiledComponentInterface {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleProfiledComponent1#afterPropertiesSet");
	}

	@Override
	public void run() {
		System.out.println("SmpleProfiledComponent1#run");
	}

}
