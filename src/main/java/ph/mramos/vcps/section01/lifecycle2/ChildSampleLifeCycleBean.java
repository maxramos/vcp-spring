package ph.mramos.vcps.section01.lifecycle2;

import javax.annotation.PostConstruct;

public class ChildSampleLifeCycleBean extends ParentSampleLifeCycleBean {

	@PostConstruct
	private void postConstruct() { // Get executed after its parent's @PostConstruct.
		System.out.println("ChildSampleLifeCycleBean#postConstruct");
	}

	@Override
	public void run() {
		System.out.println("ChildSampleLifeCycleBean#run");
	}

}
