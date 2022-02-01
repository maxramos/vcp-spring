package ph.mramos.vcps.section02.aop2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ph.mramos.vcps.section02.aop.AOPInterface;

@Qualifier("imp2")
@Component
public class AOPImplementation2 implements AOPInterface {

	@Override
	public String run1(String str) {
		return "AOPImplementation2#run1: " + str;
	}

	@Override
	public String run2(String str) {
		return "AOPImplementation2#run2: " + str;
	}

	@Override
	public String run3(String str) {
		throw new RuntimeException();
	}

	@Override
	public String run4(String str) {
		return "AOPImplementation2#run4: " + str;
	}

	@Override
	public String run5(String str1, String str2) {
		return "AOPImplementation2#run5: " + str1 + ", " + str2;
	}

	@Override
	public String run6(String str) throws IllegalStateException {
		throw new IllegalStateException();
	}

}
