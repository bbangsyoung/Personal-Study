package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		//루트에 한해서는 무조건 허락해라 !!!!
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/member/**").authenticated()
				.antMatchers("/manager/**").hasRole("MANAGER")
				.antMatchers("/admin/**").hasRole("ADMIN");
		
		
		http.csrf().disable();
		http.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess",true);
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		
		return http.build();
	}
	
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("manager")
		.password("{noop}manager123")
		.roles("MANAGER");
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}admin123")
		.roles("ADMIN");
	}
	
	
	

}
