package ph.mramos.vcps.section01.el;

import org.springframework.stereotype.Component;

@Component
public class SampleELComponent3 implements SampleELComponentInterface {

	@Override
	public String getString() {
		return "SampleELComponent3#getString";
	}

}
