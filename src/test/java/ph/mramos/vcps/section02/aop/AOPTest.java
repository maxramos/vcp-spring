package ph.mramos.vcps.section02.aop;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ph.mramos.vcps.section02.aop2.AOPInterface2;
import ph.mramos.vcps.section02.aop2.AOPNoInterface1;
import ph.mramos.vcps.section02.aop4.AOPNoInterface2;
import ph.mramos.vcps.section02.aop4.AOPNoInterface3;
import ph.mramos.vcps.section02.aop4.AOPNoInterface4;
import ph.mramos.vcps.section03.entity.Person;

@SpringJUnitConfig(classes = AOPConfig.class)
public class AOPTest {

	@Qualifier("imp0")
	@Autowired
	private AOPInterface1 aopInterface0;

	@Qualifier("imp1")
	@Autowired
	private AOPInterface1 aopInterface1;

	@Autowired
	private AOPInterface2 aopInterface2;

	@Qualifier("imp3")
	@Autowired
	private AOPInterface1 aopInterface3;

	@Autowired
	private AOPNoInterface1 aopNoInterface1;

	@Autowired
	private AOPNoInterface2 aopNoInterface2;

	@Autowired
	private AOPNoInterface3 aopNoInterface3;

	@Autowired
	private AOPNoInterface4 aopNoInterface4;

	@Test
	public void test_before() {
		aopInterface0.runBefore("runBefore");
	}

	@Test
	public void test_afterReturning() {
		aopInterface0.runAfterReturning("runAfterReturning");
	}

	@Test
	public void test_afterThrowing() {
		assertThrows(RuntimeException.class, () -> aopInterface0.runAfterThrowing("runAfterThrowing"));
	}

	@Test
	public void test_after() {
		aopInterface0.runAfter("runAfter");
	}

	@Test
	public void test_around() {
		aopInterface0.runAround("runAround");
	}

	@Test
	public void test_execution() {
		aopInterface0.runExecution("runExecution");
	}

	@Test
	public void test_within() {
		aopInterface1.runWithin("runWithin");
	}

	@Test
	public void test_this() {
		aopInterface2.runThis("runThis");
	}

	@Test
	public void test_target() {
		aopNoInterface1.runTarget("runTarget");
	}

	@Test
	public void test_args() {
		aopInterface0.runArgs("runArgs", 1.2);
	}

	@Test
	public void test_bean() {
		aopInterface3.runBean("runBean");
	}

	@Test
	public void test_anno_within() {
		aopNoInterface2.runAnnoWithin("runAnnoWithin");
	}

	@Test
	public void test_anno_target() {
		aopNoInterface3.runAnnoTarget("runAnnoTarget");
	}

	@Test
	public void test_anno_args() {
		Person person = new Person();
		aopNoInterface4.runAnnoArgs(person);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_anno_annotation() {
		aopNoInterface4.runAnnoAnnotation("runAnnoAnnotation");
	}

}
