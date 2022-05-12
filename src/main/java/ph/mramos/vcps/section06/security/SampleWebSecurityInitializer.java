package ph.mramos.vcps.section06.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SampleWebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	// Required for loading security config.
	// The SampleWebSecurityConfig is loaded in SampleWebMvcInitializer's getRootConfigClasses() instead of here.
}
