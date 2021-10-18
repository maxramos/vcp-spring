package ph.mramos.vcps.section01.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleQualifiedConfig.class)
public class QualifierTest {

	@Qualifier("sampleBean")
	@Autowired
	private SampleQualifiedBean0 sampleQualifiedBean0;

	@Qualifier("sqb1i1")
	@Autowired
	private SampleQualifiedBean1 sampleQualifiedBean1Field1;

	@Qualifier("sampleBean")
	@Autowired
	private SampleQualifiedBean1 sampleQualifiedBean1Field2;

	@Qualifier("sqb2")
	@Autowired
	private SampleQualifiedBean2 sampleQualifiedBean2Field1;

	@SampleQualifierAnnotation
	@Autowired
	private SampleQualifiedBean2 sampleQualifiedBean2Field2;

	@Qualifier("sampleQualifier")
	@Autowired
	private SampleQualifiedBean2 sampleQualifiedBean2Field3;

	@Qualifier("sampleComponent")
	@Autowired
	private SampleQualifiedComponent0 sampleQualifiedComponent0;

	@Qualifier("sqc1")
	@Autowired
	private SampleQualifiedComponent1 sampleQualifiedComponent1Field1;

	@Qualifier("sampleComponent")
	@Autowired
	private SampleQualifiedComponent1 sampleQualifiedComponent1Field2;

	@Qualifier("sqc2")
	@Autowired
	private SampleQualifiedComponent2 sampleQualifiedComponent2Field1;

	@SampleQualifierAnnotation
	@Autowired
	private SampleQualifiedComponent2 sampleQualifiedComponent2Field2;

	@Qualifier("sampleQualifier")
	@Autowired
	private SampleQualifiedComponent2 sampleQualifiedComponent2Field3;

	@Test
	public void test_qualifier() {
		sampleQualifiedBean0.run();

		sampleQualifiedBean1Field1.run();
		sampleQualifiedBean1Field2.run();

		System.out.println("SampleQualifiedBean1 1 == 2: " + (sampleQualifiedBean1Field1 == sampleQualifiedBean1Field2));

		sampleQualifiedBean2Field1.run();
		sampleQualifiedBean2Field2.run();
		sampleQualifiedBean2Field3.run();

		System.out.println("SampleQualifiedBean2 1 == 2: " + (sampleQualifiedBean2Field1 == sampleQualifiedBean2Field2));
		System.out.println("SampleQualifiedBean2 2 == 3: " + (sampleQualifiedBean2Field2 == sampleQualifiedBean2Field3));

		System.out.println();

		sampleQualifiedComponent0.run();

		sampleQualifiedComponent1Field1.run();
		sampleQualifiedComponent1Field2.run();

		System.out.println("SampleQualifiedComponent1 1 == 2: " + (sampleQualifiedComponent1Field1 == sampleQualifiedComponent1Field2));

		sampleQualifiedComponent2Field1.run();
		sampleQualifiedComponent2Field2.run();
		sampleQualifiedComponent2Field3.run();

		System.out.println("SampleQualifiedComponent2 1 == 2: " + (sampleQualifiedComponent2Field1 == sampleQualifiedComponent2Field2));
		System.out.println("SampleQualifiedComponent2 2 == 3: " + (sampleQualifiedComponent2Field2 == sampleQualifiedComponent2Field3));
	}

}
