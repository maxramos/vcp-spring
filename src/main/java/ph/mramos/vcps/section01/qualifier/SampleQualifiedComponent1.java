package ph.mramos.vcps.section01.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("sampleComponent")
@Component("sqc1")
public class SampleQualifiedComponent1 {

	public void run() {
		System.out.println("SampleQualifiedComponent1#run");
	}

}
