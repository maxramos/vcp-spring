package ph.mramos.vcps.section01.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ActiveProfiles(profiles = "test1")
@ActiveProfiles(profiles = { "test0", "test4" })
@SpringJUnitConfig(classes = { SampleProfiledConfig1.class, SampleProfiledConfig2.class })
public class ProfileTest {

	@Autowired
	private SampleProfiledBeanInterface sampleProfiledBeanInterface;

	@Autowired
	private SampleProfiledComponentInterface sampleProfiledComponentInterface;

	@Test
	public void test_profile() {
		sampleProfiledBeanInterface.run();
		sampleProfiledComponentInterface.run();
	}

}
