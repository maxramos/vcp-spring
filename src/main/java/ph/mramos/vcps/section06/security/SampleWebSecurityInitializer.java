package ph.mramos.vcps.section06.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Configures the DelegatingFilterProxy named 'springSecurityFilterChain' to make spring security work.
 */
public class SampleWebSecurityInitializer extends AbstractSecurityWebApplicationInitializer { // No need for @Configuration since this is a WebApplicationInitializer which will be auto detected.
	// Required for loading security config.
	// The MultiWebSecurityConfig is loaded in SampleWebMvcInitializer's getRootConfigClasses() instead of here since we are using Web MVC.
}
