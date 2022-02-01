package ph.mramos.vcps.section02.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "ph.mramos.vcps.section02.aop", "ph.mramos.vcps.section02.aop2", "ph.mramos.vcps.section02.aop3" })
@EnableAspectJAutoProxy
public class AOPConfig {

}
