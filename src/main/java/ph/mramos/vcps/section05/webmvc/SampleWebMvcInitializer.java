package ph.mramos.vcps.section05.webmvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ph.mramos.vcps.section04.springdatajpa.SampleSpringDataJpaConfig;

public class SampleWebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SampleSpringDataJpaConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SampleWebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" }; // Note that this is different from the context root which is usually the name of the app. Use http://localhost:8080/vcp-spring/ when testing
	}

}
