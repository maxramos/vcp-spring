package ph.mramos.vcps.section02.aop2;

import org.springframework.stereotype.Component;

@Component
public class AOPImplementation2 implements AOPInterface2 {

	@Override
	public String runThis(String str) {
		return "AOPImplementation2#runThis: " + str;
	}

}
