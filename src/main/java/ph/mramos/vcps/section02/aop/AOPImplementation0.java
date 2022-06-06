package ph.mramos.vcps.section02.aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("imp0")
@Component
public class AOPImplementation0 implements AOPInterface1 {

	@Override
	public String runBefore(String str) {
		return "AOPImplementation0#runBefore: " + str;
	}

	@Override
	public String runAfterReturning(String str) {
		return "AOPImplementation0#runAfterReturning: " + str;
	}

	@Override
	public String runAfterThrowing(String str) {
		throw new RuntimeException("AOPImplementation0#runAfterThrowing: " + str);
	}

	@Override
	public String runAfter(String str) {
		return "AOPImplementation0#runAfter: " + str;
	}

	@Override
	public String runAround(String str) {
		return "AOPImplementation0#runAround: " + str;
	}

	@Override
	public String runExecution(String str) throws IllegalStateException {
		throw new IllegalStateException("AOPImplementation0#runExecution: " + str);
	}

	@Override
	public String runArgs(String str, double num) {
		return "AOPImplementation0#runArgs: " + str + ", " + num;
	}

}
