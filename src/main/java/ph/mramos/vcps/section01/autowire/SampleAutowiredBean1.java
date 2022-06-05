package ph.mramos.vcps.section01.autowire;

public class SampleAutowiredBean1 {

	private int instance;

	public SampleAutowiredBean1(int instance) {
		this.instance = instance;
	}

	public void run() {
		System.out.println("Result: sampleAutowiredBean1Instance" + instance);
	}

	@Override
	public String toString() {
		return String.format("SampleAutowiredBean1 [instance=%s]", instance);
	}

}
