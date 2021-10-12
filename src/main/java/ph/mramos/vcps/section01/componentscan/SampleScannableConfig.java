package ph.mramos.vcps.section01.componentscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

import ph.mramos.vcps.section01.componentscan.scannable.PackageMarker;
import ph.mramos.vcps.section01.componentscan.scannable.SampleScannableBean;

@Configuration
@ComponentScan(
		basePackageClasses = PackageMarker.class,
		basePackages = "ph.mramos.vcps.section01.componentscan.scannable",
		includeFilters = @Filter(type = FilterType.REGEX, pattern = ".*Repository"), // Doesn't need to be annotated to be included.
		excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Service.class)
		)
public class SampleScannableConfig {

	@Bean
	public SampleScannableBean sampleScannableBean() {
		return new SampleScannableBean();
	}

}
