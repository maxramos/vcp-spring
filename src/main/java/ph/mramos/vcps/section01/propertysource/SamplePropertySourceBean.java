package ph.mramos.vcps.section01.propertysource;

import org.springframework.beans.factory.annotation.Value;

public class SamplePropertySourceBean {

	@Value("${sample.key}")
	private String sampleKey;

	@Value("${sample.key.web}")
	private String sampleKeyWeb;

	public void run() {
		System.out.println("SamplePropertySourceBean: " + sampleKey);
		System.out.println("SamplePropertySourceBean: " + sampleKeyWeb);
	}

}
