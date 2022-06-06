package ph.mramos.vcps.section02.aop3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ph.mramos.vcps.section02.aop.AOPInterface1;

@Qualifier("imp3")
@Component
public class AOPImplementation3 implements AOPInterface1 {

	@Override
	public String runBean(String str) {
		return "AOPImplementation3#runBean: " + str;
	}

}
