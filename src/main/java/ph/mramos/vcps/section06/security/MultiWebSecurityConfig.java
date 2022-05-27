package ph.mramos.vcps.section06.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration // No need to add @Configuration if either @EnableWebSecurity or @EnableGlobalMethodSecurity is present since they are both meta annotated by @Configuration.
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MultiWebSecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
//				.passwordEncoder(NoOpPasswordEncoder.getInstance()) // Must have a noop password encoder set if no prefix is provided to prevent errors.
				.withUser("max")
					.password("{noop}password1") // If there's no prefix set then no need to set explicitly the password encoder. By default it will be the DelegatingPasswordEncoder.
					.roles("admin")
					.and()
				.withUser("therese")
					.password("{noop}password2")
					.roles("user");
	}

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/api/**")
				.authorizeRequests()
					.antMatchers("/api/person/**").hasRole("admin")
					.and()
				.httpBasic();
		}
	}

	@Configuration
//	@Order(2) // No need to specify @Order since it will default to lowest order.
	public static class FormLoginWebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(WebSecurity web) throws Exception {
			web
				.ignoring()
					.antMatchers("/", "/resources/**");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.antMatchers("/person/**").hasRole("admin")
					.and()
				.exceptionHandling()
					.accessDeniedPage("/error/403") // Must match the value in SampleWebMvcConfig#addViewControllers()
					.and()
				.formLogin();
		}
	}
}
