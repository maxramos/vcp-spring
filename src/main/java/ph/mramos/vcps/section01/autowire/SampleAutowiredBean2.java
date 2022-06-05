package ph.mramos.vcps.section01.autowire;

import org.springframework.core.Ordered;

public class SampleAutowiredBean2 implements Ordered { // @Order takes precedence over the Ordered interface when both are present.

	private int instance;

	public SampleAutowiredBean2(int instance) {
		this.instance = instance;
	}

	@Override
	public int getOrder() {
		return instance > 1 ? 1 : 2;
	}

	public void run() {
		System.out.println("Result: sampleAutowiredBean2Instance" + instance);
	}

	@Override
	public String toString() {
		return String.format("SampleAutowiredBean2 [instance=%s]", instance);
	}

}
