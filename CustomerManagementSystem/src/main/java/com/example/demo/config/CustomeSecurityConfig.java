package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.roleBaseAuthentication.CustomeUserDetailsServiceImple;

@Configuration
public class CustomeSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomeUserDetailsServiceImple();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProviderMethod() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return daoAuthenticationProvider;
	}

//	
	@Bean
	public SecurityFilterChain securityFilterChainMethod(AuthenticationManagerBuilder http) throws Exception {
		http.authenticationProvider(this.daoAuthenticationProviderMethod());

		return null;
	}

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.requestMatchers("/api/user/**")
		.hasRole("user")
		.requestMatchers("/api/customer/")
		.hasRole("manager")
		.requestMatchers("/**")
		.permitAll()
		.and().formLogin()
		.and().csrf()
		.disable();

		return http.build();
	}

}
