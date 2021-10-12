package ph.mramos.vcps.section01.componentscan.scannable;

import org.springframework.stereotype.Service;

@Service
public class ExcludedService {

	public void run() {
		System.out.println("Included Service.");
	}

}
