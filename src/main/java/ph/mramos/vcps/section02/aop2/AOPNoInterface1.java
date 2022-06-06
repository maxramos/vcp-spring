package ph.mramos.vcps.section02.aop2;

import org.springframework.stereotype.Component;

@Component
public class AOPNoInterface1 {

	public String runTarget(String str) {
		return "AOPNoInterface1#runTarget: " + str;
	}

}
