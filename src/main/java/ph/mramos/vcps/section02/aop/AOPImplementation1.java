package ph.mramos.vcps.section02.aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("imp1")
@Component
public class AOPImplementation1 implements AOPInterface1 {

	@Override
	public String runWithin(String str) {
		return "AOPImplementation1#runWithin: " + str;
	}

}

