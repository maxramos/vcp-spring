package ph.mramos.vcps.section02.aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("imp")
@Component
public class AOPImplementation implements AOPInterface {

	@Override
	public String run1(String str) {
		return "AOPImplementation#run1: " + str;
	}

	@Override
	public String run2(String str) {
		return "AOPImplementation#run2: " + str;
	}

	@Override
	public String run3(String str) {
		throw new RuntimeException();
	}

	@Override
	public String run4(String str) {
		return "AOPImplementation#run4: " + str;
	}

	@Override
	public String run5(String str1, String str2) {
		return "AOPImplementation#run5: " + str1 + ", " + str2;
	}

	@Override
	public String run6(String str) throws IllegalStateException {
		throw new IllegalStateException();
	}

}
