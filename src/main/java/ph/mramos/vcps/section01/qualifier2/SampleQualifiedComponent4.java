package ph.mramos.vcps.section01.qualifier2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("group2")
@Component
public class SampleQualifiedComponent4 implements SampleQualifiedInterface {

	@Override
	public void run() {
		System.out.println("SampleQualifiedComponent4#run");
	}

}
