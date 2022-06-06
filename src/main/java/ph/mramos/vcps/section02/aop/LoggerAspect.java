package ph.mramos.vcps.section02.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Order of execution:
 * 1. @Around before proceed
 * 2. @Before
 * 3. @AfterReturning or @AfterThrowing
 * 5. @After
 * 6. @Around after proceed
 */
@Aspect
@Component
public class LoggerAspect {

	@Pointcut("execution(* ph.mramos.vcps.section02..*Implementation0.runBefore(String))")
	private void pc_before() {}

	@Pointcut("execution(* ph.mramos.vcps.section02..*Implementation0.runAfterReturning(String))")
	private void pc_afterReturning() {}

	@Pointcut("execution(* ph.mramos.vcps.section02..*Implementation0.runAfterThrowing(String))")
	private void pc_afterThrowing() {}

	@Pointcut("execution(* ph.mramos.vcps.section02..*Implementation0.runAfter(String))")
	private void pc_after() {}

	@Pointcut("execution(* ph.mramos.vcps.section02..*Implementation0.runAround(String))")
	private void pc_around() {}

	@Pointcut("execution(public * ph.mram*.vcps..aop.*Implementation0.runExecut*(..) throws IllegalStateException)")
	private void pc_execution() {}

	@Pointcut("within(ph.mramos.vcps.section02.aop.*Implementation1)")
	private void pc_within() {}

	@Pointcut("this(ph.mramos.vcps.section02.aop2.AOPInterface2) && within(ph.mramos.vcps.section02.aop2.*)") // Add the within PCD to prevent unnecessary advice.
	private void pc_this() {}

	@Pointcut("target(ph.mramos.vcps.section02.aop2.AOPNoInterface1) && within(ph.mramos.vcps.section02.aop2.*)") // Add the within PCD to prevent unnecessary advice.
	private void pc_target() {}

	@Pointcut("args(String, double)")
	private void pc_args() {}

	@Pointcut("bean(imp3) && within(ph.mramos.vcps.section02.aop3.*)") // Add the within PCD to prevent unnecessary advice.
	private void pc_bean() {} // The bean pointcut designator only exists in Spring, not present in AspectJ.

	@Pointcut("@within(org.springframework.stereotype.Service)")
	private void pc_anno_within() {}

	@Pointcut("@target(org.springframework.stereotype.Repository) && within(ph.mramos.vcps.section02.aop4.*)") // Add the within PCD to prevent unnecessary advice.
	private void pc_anno_target() {}

	@Pointcut("@args(javax.persistence.Entity)") // Applied on the class, not the parameter.
	private void pc_anno_args() {}

	@Pointcut("@annotation(Deprecated)") // Applied on the mthod.
	private void pc_anno_annotation() {}

	@Before("pc_before()")
	public void ad_before(JoinPoint jp) {
		System.out.println("********** Before **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@AfterReturning(pointcut = "pc_afterReturning()", returning = "returnValue")
	public void ad_afterReturning(JoinPoint jp, String returnValue) {
		System.out.println("********** After Returning **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();

		System.out.println("Return Value: " + returnValue);
		System.out.println();
	}

//
	@AfterThrowing(pointcut = "pc_afterThrowing()", throwing = "throwable")
	public void ad_afterThrowing(JoinPoint jp, Throwable throwable) {
		System.out.println("********** After Throwing **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();

		System.out.println("Throwable Class: " + throwable.getClass());
		System.out.println();
	}

//
	@After("pc_after()")
	public void ad_after(JoinPoint jp) {
		System.out.println("********** After **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

//
	@Around("pc_around()")
	public void ad_around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("********** Around (Before Proceed - Return) **********");
		System.out.println("Signature: " + pjp.getSignature());
		System.out.println("Args: " + Arrays.toString(pjp.getArgs()));
		System.out.println("Kind: " + pjp.getKind());
		System.out.println("Source Location: " + pjp.getSourceLocation());
		System.out.println("This: " + pjp.getThis());
		System.out.println("Target: " + pjp.getTarget());
		System.out.println();

		Object returnValue = pjp.proceed();

		System.out.println("           Around (After Proceed - Return)           ");
		System.out.println("Return Value: " + returnValue);
		System.out.println();
	}

	@Around("pc_execution()")
	public void ad_execution(ProceedingJoinPoint pjp) {
		System.out.println("********** Execution (Around - Before Proceed - Throw) **********");
		System.out.println("Signature: " + pjp.getSignature());
		System.out.println("Args: " + Arrays.toString(pjp.getArgs()));
		System.out.println("Kind: " + pjp.getKind());
		System.out.println("Source Location: " + pjp.getSourceLocation());
		System.out.println("This: " + pjp.getThis());
		System.out.println("Target: " + pjp.getTarget());
		System.out.println();

		try {
			Object returnValue = pjp.proceed();
			System.out.println("Return Value: " + returnValue); // Not executed.
		} catch (Throwable e) {
			System.out.println("           Execution (Around - After Proceed - Throw)           ");
			System.out.println("Throwable Class: " + e.getClass());
		}
	}

	@Before("pc_within()")
	public void ad_within(JoinPoint jp) {
		System.out.println("********** Within (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("pc_this()")
	public void ad_this(JoinPoint jp) {
		System.out.println("********** This (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("pc_target()")
	public void ad_target(JoinPoint jp) {
		System.out.println("********** Target (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("pc_args()")
	public void ad_args(JoinPoint jp) {
		System.out.println("********** Args (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("pc_bean()")
	public void ad_bean(JoinPoint jp) {
		System.out.println("********** Bean (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("pc_anno_within()")
	public void ad_anno_within(JoinPoint jp) {
		System.out.println("********** @Withtin (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("pc_anno_target()")
	public void ad_anno_target(JoinPoint jp) {
		System.out.println("********** @Target (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("pc_anno_args()")
	public void ad_anno_args(JoinPoint jp) {
		System.out.println("********** @Args (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("pc_anno_annotation()")
	public void ad_anno_annotation(JoinPoint jp) {
		System.out.println("********** @Annotation (Before) **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

}
