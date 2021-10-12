package ph.mramos.vcps.section01.appcontext.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ph.mramos.vcps.section01.appcontext.nonweb.SampleNonWebConfig;

public class SampleWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("SampleWebInitializer#getRootConfigClasses");
		return new Class[] { SampleNonWebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("SampleWebInitializer#getServletConfigClasses");
		return new Class[] { SampleWebConfig.class, SampleController.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("SampleWebInitializer#getServletMappings");
		return new String[] { "/" }; // Note that this is different from the context root which is usually the name of the app.
	}

}
