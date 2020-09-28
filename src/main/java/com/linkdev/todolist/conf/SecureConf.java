package com.linkdev.todolist.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecureConf extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

//	1. Authentication 
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		return encoder;
	}

//	AuthenticationManagerBuilder tạo ra authenticationManager để quản lý người dùng đăng nhập ứng dụng
//	https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-daoauthenticationprovider
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

//	2.Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/font/**", "/images/**", "/lib/**", "/files/**", "/signup",
						"/forget-password","/reset-password", "/confirm-reset", "/404", "/error")
				.permitAll()
				.antMatchers("/admin/**")
				.hasAnyAuthority("ROLE_ADMIN")
				.antMatchers("/*")
				.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
				
				.and()
				.formLogin().loginPage("/login")
				.loginProcessingUrl("/login-page")
				.usernameParameter("email").passwordParameter("password")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login?error=true")
				.permitAll()

				.and()
				.logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()

				.and().exceptionHandling().accessDeniedPage("/403")

//			.and()
//				.oauth2Login()
//				.loginPage("/login")
//				.loginProcessingUrl("/login/facebook")
//				.defaultSuccessUrl("/")
		;
	}

//	3.ignore resource
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
}
