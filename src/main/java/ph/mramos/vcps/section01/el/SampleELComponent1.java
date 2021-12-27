package ph.mramos.vcps.section01.el;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SampleELComponent1 {

	// Literal expressions
	@Value("#{'String value'}")
	private String str;

	@Value("#{1}")
	private int intVal;

	@Value("#{true}")
	private boolean booleanVal;

	// arrays, list, maps, properties
	@Value("#{arrayVal[0]}")
	private String arrayVal; // If specified in page then it's like this: #arrayVal[0]

	@Value("#{listVal[0]}")
	private String listVal; // If specified in page then it's like this: #listVal[0]

	@Value("#{mapStrVal['key1']}")
	private String mapStrVal; // If specified in page then it's like this: #mapStrVal['key1']

	@Value("#{mapIntVal[1]}")
	private String mapIntVal; // If specified in page then it's like this: #mapIntVal[1]

	@Value("#{systemProperties['os.name']}") // JVM Properties
	private String osName; // If specified in page then it's like this: @systemProperties['os.name']

	@Value("#{systemEnvironment['JAVA_HOME']}")
	private String javaHome; // If specified in page then it's like this: @systemEnvironment['JAVA_HOME']

	@Value("#{environment['defaultProfiles']}") // Spring environment
	private String defaultProfile; // If specified in page then it's like this: @systemEnvironment['path']

	// Method invocation
	@Value("#{sampleELComponent2.getString()}") // Bean names can be prefixed with @
	private String methodInvocation; // Remember to put the () in the method name.

	@Value("#{T(ph.mramos.vcps.section01.el.SampleELComponent2).getStaticString()}")
	private String methodInvocationStatic; // Remember to put the () in the method name.

	@Value("#{T(ph.mramos.vcps.section01.el.SampleELComponent2).staticName}") // Must have a static getStaticName().
	private String fieldInvocationStatic;

	// Operators
	@Value("#{true ? 'new String' : null}")
	private String ternary;

	@Value("#{sampleELComponent3 ?: sampleELComponent2}")
	private SampleELComponentInterface elvis;

	@Value("#{null?.name}") // Must have an instance method getName() if component is not null.
	private String safeNavigation;

	@Value("#{'1234' matches '\\d{1,3}'}")
	private boolean regexMatches;

	// Collection selection and projection
	@Value("#{mapIntVal.?[key % 2 == 0]}")
	private Map<String, String> mapStrValSelection;

	@Value("#{mapStrVal.!['[Key: ' + key + ', Value: ' + value + ']']}")
	private List<String> mapStrValProjection;

	public void run() {
		System.out.println("String literal: " + str);
		System.out.println("int literal: " + intVal);
		System.out.println("boolean literal: " + booleanVal);
		System.out.println("Array: " + arrayVal);
		System.out.println("List: " + listVal);
		System.out.println("Map String: " + mapStrVal);
		System.out.println("Map Integer: " + mapIntVal);
		System.out.println("System Properties = OS Name: " + osName);
		System.out.println("System Environment = Java Home: " + javaHome);
		System.out.println("Spring Environment = default profiles: " + defaultProfile);
		System.out.println("Method Invocation: " + methodInvocation);
		System.out.println("Method Invocation Static: " + methodInvocationStatic);
		System.out.println("Field Invocation Static: " + fieldInvocationStatic);
		System.out.println("Ternary: " + ternary);
		System.out.println("Elvis: " + elvis.getString());
		System.out.println("Safe Navigation: " + safeNavigation);
		System.out.println("Regex matches: " + regexMatches);
		System.out.println("Map Selection: " + mapStrValSelection);
		System.out.println("Map Projection: " + mapStrValProjection);
	}

}
