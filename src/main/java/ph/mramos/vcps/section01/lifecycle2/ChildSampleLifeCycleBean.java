package ph.mramos.vcps.section01.lifecycle2;

import javax.annotation.PostConstruct;

public class ChildSampleLifeCycleBean extends ParentSampleLifeCycleBean {

	@PostConstruct
	private void postConstruct() {
		System.out.println("ChildSampleLifeCycleBean#postConstruct");
	}

	@Override
	public void run() {
		System.out.println("ChildSampleLifeCycleBean#run");
	}

}
