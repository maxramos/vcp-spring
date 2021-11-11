package ph.mramos.vcps.section01.lifecycle2;

import javax.annotation.PostConstruct;

public class ParentSampleLifeCycleBean {

	@PostConstruct
	private void postConstruct() {
		System.out.println("ParentSampleLifeCycleBean#postConstruct");
	}

	public void run() {
		System.out.println("ParentSampleLifeCycleBean#run");
	}

}
