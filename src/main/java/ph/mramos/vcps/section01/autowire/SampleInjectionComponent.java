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
	 * Default behavior when there are multiple instances is to base the bean name from the parameter name.
	 * When there are multiple constructors but not one is annotated then call the default constructor.
	 *
	 * If @Autowired(required = false) and there's no default constructor,
	 * 			then all required dependencies must be satisfied or throw an error.
	 * 			Non required dependencies must be marked as @Nullable or wrapped in Optional.
	 * If @Autowired(required = false) and all params are required and there's a default constructor,
	 * 			then execute that default constructor instead if there are unsatisfied dependencies.
	 * If @Autowired(required = false) and there are optional params,
	 * 			then execute it even if there's a default constructor.
	 */
	@Autowired(required = false)
	private SampleInjectionComponent(SampleAutowiredBean2 sampleAutowiredBean2Instance1, @Nullable WebApplicationContext webAppContext) { // 1st to execute.
		System.out.println("SampleInjectionComponent#constructor");
		System.out.println("sampleBean0 is null: " + (sampleBean0 == null));
		System.out.println("sampleBean3 is null: " + (sampleBean3 == null));
		System.out.println("webAppContext is null: " + (webAppContext == null));
		this.sampleBean2 = sampleAutowiredBean2Instance1;
	}

	/**
	 * Default behavior when there are multiple instances is to base the bean name from the parameter name.
	 *
	 * If @Autowired(required = false) then it's all or nothing regardless of dependencies being marked as @Nullable or wrapped in Optional,
	 * 			all dependencies must be satisfied or nothing will be injected but it will not throw an error even if some dependencies are not satisfied.
	 * If @Autowired(required = false) and non required params are wrapped in Optional then it will still be executed even if some dependencies are not satisfied.
	 */
	@Autowired
	private void setSampleBean3(SampleAutowiredBean3 sampleAutowiredBean3Instance1, @Nullable WebApplicationContext webAppContext) { // 3rd to execute.
		System.out.println("SampleInjectionComponent#setter");
		System.out.println("sampleBean0 is null: " + (sampleBean0 == null));
		System.out.println("webAppContext is null: " + (webAppContext == null));
		this.sampleBean3 = sampleAutowiredBean3Instance1;
	}

	public void run() {
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
