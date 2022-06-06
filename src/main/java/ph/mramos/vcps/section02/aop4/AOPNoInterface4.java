package ph.mramos.vcps.section02.aop4;

import org.springframework.stereotype.Component;

import ph.mramos.vcps.section03.entity.Person;

@Component
public class AOPNoInterface4 {

	public String runAnnoArgs(Person person) {
		return "AOPNoInterface4#runAnnoArgs: " + person;
	}

	@Deprecated
	public String runAnnoAnnotation(String str) {
		return "AOPNoInterface4#runAnnoAnnotation: " + str;
	}

}
