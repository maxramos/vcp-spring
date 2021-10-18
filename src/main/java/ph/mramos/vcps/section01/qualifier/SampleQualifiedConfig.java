package ph.mramos.vcps.section01.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SampleQualifiedConfig {

	@Qualifier("sampleBean")
	@Bean(name = "sqb0") // Bean name/alias must be unique across the app context.
	public SampleQualifiedBean0 sampleQualifiedBean0() {
		return new SampleQualifiedBean0();
	}

	@Qualifier("sampleBean") // Qualifier value must be unique between definition of the same class (e.g. sqb1i1, sqb1i2) but can be duplicated between different bean classes (e.g. sqb0, sqb1i1).
	@Bean(name = "sqb1i1")
	public SampleQualifiedBean1 sampleQualifiedBean1Instance1() {
		return new SampleQualifiedBean1();
	}

//	@Qualifier("sampleBean") // This will cause an error if uncommented since this definition (i.e. sqb1i2) has the same class as sqb1i1.
	@Bean(name = "sqb1i2")
	public SampleQualifiedBean1 sampleQualifiedBean1Instance2() {
		return new SampleQualifiedBean1();
	}

	@SampleQualifierAnnotation
	@Bean(name = "sqb2")
	public SampleQualifiedBean2 sampleQualifiedBean2() {
		return new SampleQualifiedBean2();
	}

}
