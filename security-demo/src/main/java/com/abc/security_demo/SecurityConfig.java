package com.abc.security_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	UserDetailsService appUserDetails() {
		
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		
		userDetailsManager.createUser(User.withUsername("abc12").password("{noop}abc@123").roles("USER").build());
		userDetailsManager.createUser(User.withUsername("sam18").password("{noop}sam@18").roles("USER").build());
		userDetailsManager.createUser(User.withUsername("sk17").password("{noop}sk@17").roles("USER","ADMIN").build());
		
		return userDetailsManager;
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((authorize) -> 
		      authorize.requestMatchers("/api/user/**").hasAnyRole("USER")
		       .requestMatchers("/api/admin/**").hasAnyRole("ADMIN")
		       .requestMatchers("/api/home").permitAll()
		        .anyRequest().authenticated()
		        )
		       .httpBasic(Customizer.withDefaults())
		       .formLogin(Customizer.withDefaults());
		
		return http.build();
	}
}
