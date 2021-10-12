package ph.mramos.vcps.section01.instance.lazy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SampleLazyComponent implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleLazyComponent afterPropertiesSet");
	}

	public void run() {
		System.out.println("Sample Lazy Component.");
	}

}
