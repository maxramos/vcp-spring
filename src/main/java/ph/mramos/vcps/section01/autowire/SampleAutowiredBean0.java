package ph.mramos.vcps.section01.autowire;

public class SampleAutowiredBean0 {

	private int instance;

	public SampleAutowiredBean0(int instance) {
		this.instance = instance;
	}

	public void run() {
		System.out.println("SampleAutowiredBean0#run: instance" + instance);
	}

	@Override
	public String toString() {
		return String.format("SampleAutowiredBean0 [instance=%s]", instance);
	}

}
