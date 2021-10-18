package ph.mramos.vcps.section01.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("sampleComponent") // Qualifier can be duplicated between different component classes (e.g. sqc0, sqc1).
@Component("sqc0") // Component value/name must be unique across the app context.
public class SampleQualifiedComponent0 {

	public void run() {
		System.out.println("SampleQualifiedComponent0#run");
	}

}
