package ph.mramos.vcps.section01.lifecycle2;

import javax.annotation.PostConstruct;

public class ParentSampleLifeCycleBean {

	@PostConstruct
	private void postConstruct() { // Get executed first prior to its child's @PostConstruct.
		System.out.println("ParentSampleLifeCycleBean#postConstruct");
	}

	public void run() {
		System.out.println("ParentSampleLifeCycleBean#run");
	}

}
