package ph.mramos.vcps.section02.aop4;

import org.springframework.stereotype.Repository;

@Repository
public class AOPNoInterface3 {

	public String runAnnoTarget(String str) {
		return "AOPNoInterface3#runAnnoTarget: " + str;
	}

}
