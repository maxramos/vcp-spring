package ph.mramos.vcps.section01.propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SamplePropertySourceComponent {

	@Value("${sample.key}")
	private String sampleKey;

	@Value("${sample.key.web}")
	private String sampleKeyWeb;

	public void run() {
		System.out.println("SamplePropertySourceComponent: " + sampleKey);
		System.out.println("SamplePropertySourceComponent: " + sampleKeyWeb);
	}

}
