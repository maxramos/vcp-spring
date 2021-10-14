package ph.mramos.vcps.section01.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SampleAutowiredComponent {

	@Autowired
	private SampleAutowiredBean0 sampleAutowiredBean0; // Has only 1 instance.

	@Autowired
	private SampleAutowiredBean1 sampleAutowiredBean1; // Has @Primary but with non existent bean name.

	@Autowired
	@Qualifier("sampleAutowiredBean2Instance1")
	private SampleAutowiredBean2 sampleAutowiredBean2; // Has @Qualifier but with non existent bean name.

	@Autowired
	private SampleAutowiredBean3 sampleAutowiredBean3Instance1; // Has no @Primary and no @Qualifier but with correct bean name. Default behavior.

	@Autowired
	private SampleAutowiredBean1 sampleAutowiredBean1Instance2; // Has @Primary but with the other bean name. Primary takes precedence even if the name matches the other bean.

	@Autowired
	@Qualifier("sampleAutowiredBean1Instance2")
	private SampleAutowiredBean1 sampleAutowiredBean1Instance1; // Has @Qualifier but with the other bean name. Qualifier takes precedence even if the name matches the other bean.

	public void run() {
		System.out.println("SampleAutowiredComponent#run");
		sampleAutowiredBean0.run();
		sampleAutowiredBean1.run();
		sampleAutowiredBean2.run();
		sampleAutowiredBean3Instance1.run();
		sampleAutowiredBean1Instance2.run();
		sampleAutowiredBean1Instance1.run();
	}

}
