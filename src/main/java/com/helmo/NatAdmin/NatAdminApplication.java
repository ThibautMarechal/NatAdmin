package com.helmo.NatAdmin;

import com.helmo.NatAdmin.config.ServletInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class NatAdminApplication extends ServletInitializer
{
	public static void main(String[] args)
	{
		SpringApplication.run(NatAdminApplication.class, args);
	}
}
