package ph.mramos.vcps.section01.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SampleLifeCycleBean implements InitializingBean, DisposableBean {

	@PostConstruct
	public void postConstruct() {
		System.out.println("SampleLifeCycleBean#postConstruct");
	}

	@PreDestroy
	public void preDestroy() {
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

	public void init() {
		System.out.println("SampleLifeCycleBean#init");
	}

	public void close() {
		System.out.println("SampleLifeCycleBean#close");
	}

	public void run() {
		System.out.println("SampleLifeCycleBean#run");
	}

}
