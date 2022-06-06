package ph.mramos.vcps.section02.aop4;

import org.springframework.stereotype.Service;

@Service
public class AOPNoInterface2 {

	public String runAnnoWithin(String str) {
		return "AOPNoInterface2#runAnnoWithin: " + str;
	}

}
