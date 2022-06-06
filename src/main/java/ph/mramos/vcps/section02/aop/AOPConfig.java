package ph.mramos.vcps.section02.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "ph.mramos.vcps.section02" })
@EnableAspectJAutoProxy
public class AOPConfig {

}
