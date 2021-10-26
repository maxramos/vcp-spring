package ph.mramos.vcps.section01.profile;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({ "test2", "test4" })
@Component
public class SampleProfiledComponent2 implements InitializingBean, SampleProfiledComponentInterface {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleProfiledComponent2#afterPropertiesSet");
	}

	@Override
	public void run() {
		System.out.println("SmpleProfiledComponent2#run");
	}

}
