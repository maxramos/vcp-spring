package ph.mramos.vcps.section05.webmvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SampleWebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
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
