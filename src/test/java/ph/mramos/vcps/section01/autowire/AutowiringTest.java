package ph.mramos.vcps.section01.autowire;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleAutowiredConfig.class)
public class AutowiringTest {

	@Autowired
	private SampleAutowiredComponent sampleAutowiredComponent;

	@Autowired
	private SampleAutowiredBean1[] sampleAutowiredBean1Array;

	@Autowired
	private List<SampleAutowiredBean1> sampleAutowiredBean1List;

	@Autowired
	private List<SampleAutowiredBean2> sampleAutowiredBean2List;

	@Autowired
	private List<SampleAutowiredBean3> sampleAutowiredBean3List;

	@Autowired
	private Map<String, SampleAutowiredBean1> sampleAutowiredBean1Map;

	@Test
	public void test_autowiring() {
		sampleAutowiredComponent.run();
	}

	@Test
	public void test_bean_array() {
		Stream.of(sampleAutowiredBean1Array).forEach(System.out::println);
	}

	@Test
	public void test_bean_list() {
		sampleAutowiredBean1List.forEach(System.out::println);
		sampleAutowiredBean2List.forEach(System.out::println);
		sampleAutowiredBean3List.forEach(System.out::println);
	}

	@Test
	public void test_bean_map() {
		sampleAutowiredBean1Map.forEach((key, value) -> System.out.println(key + " : " + value));
	}

}
