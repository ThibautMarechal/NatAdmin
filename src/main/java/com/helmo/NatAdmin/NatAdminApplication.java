package com.helmo.NatAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class NatAdminApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(NatAdminApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(NatAdminApplication.class);
	}
	
	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
}
