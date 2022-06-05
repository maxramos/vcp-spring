package ph.mramos.vcps.section01.instance.lazy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SampleLazyComponent1 implements InitializingBean {

	@Lazy // When applied to @Autowired field, the field is only injected with a proxy, the instantiating of the target (object being proxied) is not done until one of its method is actually used.
	@Autowired
	private SampleLazyComponent2 sampleLazyComponent2;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleLazyComponent1#afterPropertiesSet");
	}

	public void run() {
		System.out.println("SampleLazyComponent1#run");
		sampleLazyComponent2.run();

	}

}
