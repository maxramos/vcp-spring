package ph.mramos.vcps.section01.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Order of injection:
 * 1. Constructor
 * 2. Field
 * 3. Method
 */
@Component
public class SampleInjectionComponent {

	@Autowired
	private SampleAutowiredBean0 sampleBean0; // 2nd to execute.

	private SampleAutowiredBean2 sampleBean2;

	private SampleAutowiredBean3 sampleBean3;

	private SampleInjectionComponent() {
		System.out.println("SampleInjectionComponent#default-constructor");
		this.sampleBean2 = new SampleAutowiredBean2(3);
	}

	/**
	 * Default behavior when there are multiple instances of the target bean is to base the bean name from the parameter name.
	 * When there are multiple constructors but not one is annotated with @Autowired then call the default constructor.
	 * Non required dependencies must be marked as @Nullable or wrapped in Optional.
	 * Only the required dependencies have bearing when evaluating an annotated constructor regardless if @Autowired(required = true) or @Autowired(required = false).
	 *
	 * If @Autowired(required = true),
	 * 			then all required dependencies must be satisfied or throw an error (e.g. NoUniqueBeanDefinitionException).
	 * If @Autowired(required = false) and there's no default constructor,
	 * 			then all required dependencies must be satisfied or throw an error (e.g. NoUniqueBeanDefinitionException).
	 * If @Autowired(required = false) and there's a default constructor,
	 * 			then execute that default constructor only if there are unsatisfied required dependencies.
	 */
	@Autowired(required = false)
	private SampleInjectionComponent(SampleAutowiredBean2 sampleAutowiredBean2Instance1, @Nullable WebApplicationContext webAppContext) { // 1st to execute.
		this.sampleBean2 = sampleAutowiredBean2Instance1;
		System.out.println("SampleInjectionComponent#constructor");
		System.out.println("sampleBean0 is null: " + (sampleBean0 == null));
		System.out.println("sampleBean2 is null: " + (sampleBean2 == null));
		System.out.println("sampleBean3 is null: " + (sampleBean3 == null));
		System.out.println("webAppContext is null: " + (webAppContext == null));
	}

	/**
	 * Default behavior when there are multiple instances of the target bean is to base the bean name from the parameter name.
	 * Non required dependencies can be marked as @Nullable or wrapped in Optional but it's no use since any unsatisfied optional dependencies will cause the method to be NOT executed.
	 *
	 * If @Autowired(required = true),
	 * 			then all required dependencies must be satisfied or throw an error (e.g. NoUniqueBeanDefinitionException).
	 * If @Autowired(required = false) and NON required parameter is annotated by @Nullable,
	 * 			then all dependencies (even NON required ones) must be satisfied or else the method will NOT be executed (no error will be thrown).
	 *  * If @Autowired(required = false) and NON required parameter is enclosed by Optional,
	 * 			then all required dependencies must be satisfied or else the method will NOT be executed (no error will be thrown).
	 */
	@Autowired(required = false)
	private void setSampleBean3(SampleAutowiredBean3 sampleAutowiredBean3Instance1, @Nullable WebApplicationContext webAppContext) { // 3rd to execute.
		this.sampleBean3 = sampleAutowiredBean3Instance1;
		System.out.println();
		System.out.println("SampleInjectionComponent#setter");
		System.out.println("sampleBean0 is null: " + (sampleBean0 == null));
		System.out.println("sampleBean2 is null: " + (sampleBean2 == null));
		System.out.println("sampleBean3 is null: " + (sampleBean3 == null));
		System.out.println("webAppContext is null: " + (webAppContext == null));
	}

	public void run() {
		System.out.println();
		System.out.println("SampleInjectionComponent#run");

		if (sampleBean0 != null) {
			sampleBean0.run();
		}

		if (sampleBean2 != null) {
			sampleBean2.run();
		}

		if (sampleBean3 != null) {
			sampleBean3.run();
		}
	}

}
