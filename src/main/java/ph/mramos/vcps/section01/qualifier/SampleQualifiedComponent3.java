package ph.mramos.vcps.section01.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("sampleComponent3")
@Component
public class SampleQualifiedComponent3 {

	public void run() {
		System.out.println("SampleQualifiedComponent3#run");
	}

}
