package com.helmo.NatAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class NatAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(NatAdminApplication.class, args);
	}
	
}
