package ph.mramos.vcps.section01.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SampleAutowiredComponent {

	@Autowired
	private SampleAutowiredBean0 sampleAutowiredBean0; // Has only 1 instance. Even if the bean name does NOT match it's still autowired.

	@Autowired
	private SampleAutowiredBean1 sampleAutowiredBean1; // Has @Primary but with non existent bean name. Note that when @Primary is applied to a component class (i.e. @Component) then it will only be processed if component scanning is used (@ComponentScan).

	@Autowired
	@Qualifier("sampleAutowiredBean2Instance1")
	private SampleAutowiredBean2 sampleAutowiredBean2; // Has @Qualifier but with non existent bean name.

	@Autowired
	private SampleAutowiredBean3 sampleAutowiredBean3Instance1; // Has no @Primary and no @Qualifier but with correct bean name. Default behavior.

	@Autowired
	private SampleAutowiredBean1 sampleAutowiredBean1Instance2; // Has @Primary but with the other bean name. Primary takes precedence even if the name matches the other bean.

	@Autowired
	@Qualifier("sampleAutowiredBean1Instance2")
	private SampleAutowiredBean1 sampleAutowiredBean1Instance1; // Has @Qualifier but with the other bean name. Qualifier takes precedence even if the name matches the other bean and has @Primary.

	public void run() {
		System.out.println("SampleAutowiredComponent#run");

		System.out.println("Field Name: sampleAutowiredBean0 -- Only 1 instance");
		sampleAutowiredBean0.run();

		System.out.println("Field Name: sampleAutowiredBean1 -- Has @Primary (Instance 1)");
		sampleAutowiredBean1.run();

		System.out.println("Field Name: sampleAutowiredBean2 -- Has @Qualifier(\"sampleAutowiredBean2Instance1\")");
		sampleAutowiredBean2.run();

		System.out.println("Field Name: sampleAutowiredBean3Instance1 -- No @Primary and No @Qualifier but matches bean name");
		sampleAutowiredBean3Instance1.run();

		System.out.println("Field Name: sampleAutowiredBean1Instance2 -- Has @Primary (Instance 1) but with the other bean name");
		sampleAutowiredBean1Instance2.run();

		System.out.println("Field Name: sampleAutowiredBean1Instance1 -- Has @Qualifier(\"sampleAutowiredBean1Instance2\") but with the other bean name and with @Primary (Instance 1)");
		sampleAutowiredBean1Instance1.run();
	}

}
