package ph.mramos.vcps.section01.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * - @Profile annotated classes/method will not be loaded if there are no profile specified when starting the application.
 * - If a negation profile expression is present in the @Profile then a profile must be specified in the application startup that does not match the negated profile.
 *   Not specifying any profile on application startup will not load the class/method annotated with the @Profile with profile negation.
 *   Example: if a class/method is annotated with @Profile("!prd") then a profile must be specified in application startup like "dev".
 * - If there's no profile specified when starting the application then all classes/method without the @Profile annotation will be loaded.
 */
@Profile("test1")
@Configuration
@ComponentScan
public class SampleProfiledConfig1 {

	@Bean // // Must have profile: test1 to be executed.
	public SampleProfiledBeanInterface sampleProfiledBean1() {
		return new SampleProfiledBean1();
	}

	@Profile("test2") // Must have both profiles: test1, test2 to be executed.
	@Bean
	public SampleProfiledBeanInterface sampleProfiledBean2() {
		return new SampleProfiledBean2();
	}

}
