package ph.mramos.vcps.section01.qualifier2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleQualifiedConfig.class)
public class QualifierTest {

	@Autowired
	private List<SampleQualifiedInterface> all;

	@Qualifier("group1")
	@Autowired
	private List<SampleQualifiedInterface> group1;

	@Qualifier("group2")
	@Autowired
	private List<SampleQualifiedInterface> group2;

	@Test
	public void test_qualifier() {
		all.forEach(SampleQualifiedInterface::run);

		System.out.println();

		group1.forEach(SampleQualifiedInterface::run);

		System.out.println();

		group2.forEach(SampleQualifiedInterface::run);

	}

}
