package ph.mramos.vcps.section02.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = AOPConfig.class)
public class AOPTest {

	@Qualifier("imp")
	@Autowired
	private AOPInterface aopInterface;

	@Qualifier("imp2")
	@Autowired
	private AOPInterface aopInterface2;

	@Qualifier("imp3")
	@Autowired
	private AOPInterface aopInterface3;

	@Test
	public void testBefore() {
		aopInterface.run1("test1");
	}

	@Test
	public void testAfterReturning() {
		aopInterface.run2("test2");
	}

	@Test
	public void testAfterThrowing() {
		aopInterface.run3("test3");
	}

	@Test
	public void testAfter() {
		aopInterface.run4("test4");
	}

	@Test
	public void testAround() {
		aopInterface.run5("test5.1", "test5.2");
	}

	@Test
	public void testExecution() {
		aopInterface.run6("test6");
	}

	@Test
	public void testWithin() {
		aopInterface2.run1("test1_2");
	}

	@Test
	public void testThis() {
		aopInterface2.run2("test2_2");
	}

	@Test
	public void testTarget() {
		aopInterface3.run4("test4_3");
	}

	@Test
	public void testArgs() {
		aopInterface3.run5("test5_3.1", "test5_3.2");
	}

	@Test
	public void testBean() {
		aopInterface2.run4("test4_2");
	}

}
