package ph.mramos.vcps.section01.propertysource;

import org.springframework.beans.factory.annotation.Value;

public class SamplePropertySourceBean {

	@Value("${sample.key}")
	private String sampleKey;

	@Value("${sample.key2:Default Key 2}")
	private String sampleKey2;

	@Value("${sample.key3:${sample.key4}}")
	private String sampleKey3;

	@Value("${sample.key3:${sample.key5:Default Key 5}}")
	private String sampleKey4;

	@Value("${sample.key3:${sample.key5:${sample.key6}}}")
	private String sampleKey5;

	@Value("${sample.key.web}")
	private String sampleKeyWeb;

	public void run() {
		System.out.println("SamplePropertySourceBean#run");
		System.out.println("sampleKey: " + sampleKey);
		System.out.println("sampleKey2: " + sampleKey2);
		System.out.println("sampleKey3: " + sampleKey3);
		System.out.println("sampleKey4: " + sampleKey4);
		System.out.println("sampleKey5: " + sampleKey5);
		System.out.println("sampleKeyWeb: " + sampleKeyWeb);
	}

}
