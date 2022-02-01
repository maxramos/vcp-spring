package ph.mramos.vcps.section02.aop3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ph.mramos.vcps.section02.aop.AOPInterface;

@Qualifier("imp3")
@Component
public class AOPImplementation3 implements AOPInterface {

	@Override
	public String run1(String str) {
		return "AOPImplementation3#run1: " + str;
	}

	@Override
	public String run2(String str) {
		return "AOPImplementation3#run2: " + str;
	}

	@Override
	public String run3(String str) {
		throw new RuntimeException();
	}

	@Override
	public String run4(String str) {
		return "AOPImplementation3#run4: " + str;
	}

	@Override
	public String run5(String str1, String str2) {
		return "AOPImplementation3#run5: " + str1 + ", " + str2;
	}

	@Override
	public String run6(String str) throws IllegalStateException {
		throw new IllegalStateException();
	}

}
