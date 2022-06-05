package ph.mramos.vcps.section01.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SampleLifeCycleBean implements InitializingBean, DisposableBean {

	@PostConstruct
	private void postConstruct() { // Can have any visibility
		System.out.println("SampleLifeCycleBean#postConstruct");
	}

	@PreDestroy
	private void preDestroy() { // Can have any visibility
		System.out.println("SampleLifeCycleBean#preDestroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleLifeCycleBean#afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("SampleLifeCycleBean#destroy");
	}

	public void initMethod() {
		System.out.println("SampleLifeCycleBean#initMethod");
	}

	public void destroyMethod() {
		System.out.println("SampleLifeCycleBean#destroyMethod");
	}

	public void run() {
		System.out.println("SampleLifeCycleBean#run");
	}

}
