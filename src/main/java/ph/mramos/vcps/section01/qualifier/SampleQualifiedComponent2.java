package ph.mramos.vcps.section01.qualifier;

import org.springframework.stereotype.Component;

@SampleQualifierAnnotation
@Component("sqc2")
public class SampleQualifiedComponent2 {

	public void run() {
		System.out.println("SampleQualifiedComponent2#run");
	}

}
