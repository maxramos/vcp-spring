package ph.mramos.vcps.section01.appcontext.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.mramos.vcps.section01.appcontext.nonweb.SampleNonWebBean;

@RequestMapping("/sample")
public class SampleController implements InitializingBean {

	@Autowired
	private SampleNonWebBean sampleNonWebBean;

	@Autowired
	private SampleWebBean sampleWebBean;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("SampleController#afterPropertiesSet");
	}

	@GetMapping("/doGet")
	@ResponseBody
	public String doGet() {
		System.out.println("SampleController#doGet");
		sampleNonWebBean.run();
		sampleWebBean.run();
		return "SampleController.";
	}

}
