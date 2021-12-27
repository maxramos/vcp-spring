package ph.mramos.vcps.section01.el;

import org.springframework.stereotype.Component;

@Component
public class SampleELComponent2 implements SampleELComponentInterface {

	public static String getStaticString() {
		return "SampleELComponent2#getStaticString";
	}

	public static String getStaticName() {
		return "SampleELComponent2";
	}

	@Override
	public String getString() {
		return "SampleELComponent2#getString";
	}

	public String getName() {
		return "SampleELComponent2";
	}

}
