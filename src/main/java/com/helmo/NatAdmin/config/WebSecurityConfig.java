package com.helmo.NatAdmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
			  .authorizeRequests()
			  .antMatchers("/resources/**").permitAll()
				  .anyRequest().authenticated()
				  .and()
				  .formLogin()
			  .loginPage("/login")
				  .permitAll()
				  .and()
			  .logout()
			    .permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder pass) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(pass);
	}
}