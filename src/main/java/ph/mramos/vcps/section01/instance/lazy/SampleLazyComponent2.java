package ph.mramos.vcps.section01.instance.lazy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SampleLazyComponent2 implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleLazyComponent2#afterPropertiesSet");
	}

	public void run() {
		System.out.println("SampleLazyComponent2#run");
	}

}
