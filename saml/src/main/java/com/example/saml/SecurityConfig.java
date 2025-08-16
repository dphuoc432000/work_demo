package com.example.saml;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity	
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(authorize -> authorize
	            .anyRequest().authenticated()
	        )
	        .saml2Login(Customizer.withDefaults())
	        .saml2Logout(Customizer.withDefaults())
	        .saml2Metadata(Customizer.withDefaults())
	        .csrf(Customizer.withDefaults());
	    return http.build();
	}
	
	@Bean
	public FilterRegistrationBean<ServletFilter> loggingFilter(){
	    FilterRegistrationBean<ServletFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new ServletFilter());
	    registrationBean.addUrlPatterns("/*");
	    registrationBean.setOrder(1);
	        
	    return registrationBean;    
	}
}
