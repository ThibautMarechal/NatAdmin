package com.helmo.NatAdmin.config;

import com.helmo.NatAdmin.models.Role;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final UserService userService;
	
	public WebSecurityConfig(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//				.csrf().disable()
			  .authorizeRequests()
			  .antMatchers("/resources/**").permitAll()
				  .anyRequest().authenticated()
				  .and()
				  .formLogin();
//			  .loginPage("/login")
//				  .permitAll()
//				  .and()
//			  .logout()
//			    .permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder pass) throws Exception {
		auth.authenticationProvider(new AuthenticationProvider() {
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				if (!(authentication instanceof UsernamePasswordAuthenticationToken)) {
					return null;
				}
				
				String password = authentication.getCredentials().toString();
				User user;
				try {
					user = userService.findByEmail(authentication.getName(), password);
				} catch (Exception e) {
					throw new BadCredentialsException(e.getMessage(), e);
				}
				return new Authentication() {
					@Override
					public Collection<? extends GrantedAuthority> getAuthorities() {
						return user.getRoles().stream()
								.map(Role::getName)
								.map(SimpleGrantedAuthority::new)
								.collect(Collectors.toList());
					}
					
					@Override
					public Object getCredentials() {
						return password;
					}
					
					@Override
					public Object getDetails() {
						return null;
					}
					
					@Override
					public Object getPrincipal() {
						return user;
					}
					
					@Override
					public boolean isAuthenticated() {
						return true;
					}
					
					@Override
					public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
						throw new UnsupportedOperationException();
					}
					
					@Override
					public String getName() {
						return user.getEmail();
					}
				};
			}
			
			@Override
			public boolean supports(Class<?> authentication) {
				return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
			}
		});
	}
}