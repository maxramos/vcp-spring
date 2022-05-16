package ph.mramos.vcps.section05.webmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration // Required in either WebMvcConfigurer or WebMvcConfigurationSupport.
@EnableWebMvc // If implements WebMvcConfigurer then @EnableWebMvc must be present. if extends WebMvcConfigurationSupport then @EnableWebMvc must NOT be present.
@ComponentScan(basePackages = {
		"ph.mramos.vcps.section05.webmvc.controller",
		"ph.mramos.vcps.section07.rest.controller"
	})
public class SampleWebMvcConfig implements WebMvcConfigurer /* extends WebMvcConfigurationSupport */ {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) { //
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false); // Enables @MatrixVariable to work.

		configurer.setUrlPathHelper(urlPathHelper);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/error/403").setViewName("error/403");
	}

}
