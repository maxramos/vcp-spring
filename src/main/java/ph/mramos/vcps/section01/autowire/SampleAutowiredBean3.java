package ph.mramos.vcps.section01.autowire;

public class SampleAutowiredBean3 {

	private int instance;

	public SampleAutowiredBean3(int instance) {
		this.instance = instance;
	}

	public void run() {
		System.out.println("Result: sampleAutowiredBean3Instance" + instance);
	}

	@Override
	public String toString() {
		return String.format("SampleAutowiredBean3 [instance=%s]", instance);
	}

}
