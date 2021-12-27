package ph.mramos.vcps.section01.el;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:/config/application.properties")
public class SampleELConfig {

	@Bean
	public String[] arrayVal() {
		return new String[] { "str0", "str1", "str2" };
	}

	@Bean
	public List<String> listVal() {
		return Arrays.asList("str0", "str1", "str2");
	}

	@Bean
	public Map<String, String> mapStrVal() {
		Map<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		return map;
	}

	@Bean
	public Map<Integer, String> mapIntVal() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "value1");
		map.put(2, "value2");
		map.put(3, "value3");
		return map;
	}

}
