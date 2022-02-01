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

@Aspect
@Component
public class LoggerAspect {

	@Pointcut("!within(ph.mramos.vcps.section02.aop2.*) && !within(ph.mramos.vcps.section02.aop3.*) && execution(* ph.mramos.vcps.section02..AOP*.run1(..))")
	private void run1() {}

	@Pointcut("!within(ph.mramos.vcps.section02.aop2.*) && !within(ph.mramos.vcps.section02.aop3.*) && execution(* ph.mramos.vcps.section02..AOP*.run2(..))")
	private void run2() {}

	@Pointcut("!within(ph.mramos.vcps.section02.aop2.*) && !within(ph.mramos.vcps.section02.aop3.*) && execution(* ph.mramos.vcps.section02..AOP*.run3(..))")
	private void run3() {}

	@Pointcut("!within(ph.mramos.vcps.section02.aop2.*) && !within(ph.mramos.vcps.section02.aop3.*) && execution(* ph.mramos.vcps.section02..AOP*.run4(..))")
	private void run4() {}

	@Pointcut("!within(ph.mramos.vcps.section02.aop2.*) && !within(ph.mramos.vcps.section02.aop3.*) && execution(* ph.mramos.vcps.section02..AOP*.run5(..))")
	private void run5() {}

	@Pointcut("!within(ph.mramos.vcps.section02.aop2.*) && !within(ph.mramos.vcps.section02.aop3.*) && execution(public * ph.mramos.vcps.section02..AOP*.run*(..) throws IllegalStateException)")
	private void run6() {}

	@Pointcut("within(ph.mramos.vcps.section02.aop2.*)")
	private void run1_2() {}

	@Pointcut("this(ph.mramos.vcps.section02.aop.AOPInterface) && within(ph.mramos.vcps.section02.aop2.*)") // Add the within PCD to prevent unnecessary advice.
	private void run2_2() {}

	@Pointcut("target(ph.mramos.vcps.section02.aop3.AOPImplementation3) && within(ph.mramos.vcps.section02.aop3.*)") // Add the within PCD to prevent unnecessary advice.
	private void run4_3() {}

	@Pointcut("args(String, String)")
	private void run5_3() {}

	@Pointcut("bean(imp2) && within(ph.mramos.vcps.section02.aop2.*)") // Add the within PCD to prevent unnecessary advice.
	private void run4_2() {}

	@Before("run1()")
	public void beforeLogger(JoinPoint jp) {
		System.out.println("********** Before **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("run1_2()")
	public void beforeLogger2(JoinPoint jp) {
		System.out.println("********** Before 2 **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("run2_2()")
	public void beforeLogger3(JoinPoint jp) {
		System.out.println("********** Before 3 **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("run4_3()")
	public void beforeLogger4(JoinPoint jp) {
		System.out.println("********** Before 4 **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("run5_3()")
	public void beforeLogger5(JoinPoint jp) {
		System.out.println("********** Before 5 **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Before("run4_2()")
	public void beforeLogger6(JoinPoint jp) {
		System.out.println("********** Before 6 **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@AfterReturning(pointcut = "run2()", returning = "returnValue")
	public void afterReturningLogger(JoinPoint jp, String returnValue) {
		System.out.println("********** After Returning **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Return Value: " + returnValue);
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@AfterThrowing(pointcut = "run3()", throwing = "throwable")
	public void afterThrowingLogger(JoinPoint jp, Throwable throwable) {
		System.out.println("********** After Throwing **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Throwable Class: " + throwable.getClass());
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@After("run4()")
	public void afterLogger(JoinPoint jp) {
		System.out.println("********** After **********");
		System.out.println("Signature: " + jp.getSignature());
		System.out.println("Args: " + Arrays.toString(jp.getArgs()));
		System.out.println("Kind: " + jp.getKind());
		System.out.println("Source Location: " + jp.getSourceLocation());
		System.out.println("This: " + jp.getThis());
		System.out.println("Target: " + jp.getTarget());
		System.out.println();
	}

	@Around("run5()")
	public void aroundLogger(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("********** Around **********");
		Object returnValue = pjp.proceed();
		System.out.println("Signature: " + pjp.getSignature());
		System.out.println("Args: " + Arrays.toString(pjp.getArgs()));
		System.out.println("Return Value: " + returnValue);
		System.out.println("Kind: " + pjp.getKind());
		System.out.println("Source Location: " + pjp.getSourceLocation());
		System.out.println("This: " + pjp.getThis());
		System.out.println("Target: " + pjp.getTarget());
		System.out.println();
	}

	@Around("run6()")
	public void executionLogger(ProceedingJoinPoint pjp) {
		try {
			Object returnValue = pjp.proceed();
			System.out.println("Return Value: " + returnValue); // Not executed.
		} catch (Throwable e) {
			System.out.println("Signature: " + pjp.getSignature());
			System.out.println("Args: " + Arrays.toString(pjp.getArgs()));
			System.out.println("Throwable Class: " + e.getClass());
			System.out.println("Kind: " + pjp.getKind());
			System.out.println("Source Location: " + pjp.getSourceLocation());
			System.out.println("This: " + pjp.getThis());
			System.out.println("Target: " + pjp.getTarget());
		}
	}

}
