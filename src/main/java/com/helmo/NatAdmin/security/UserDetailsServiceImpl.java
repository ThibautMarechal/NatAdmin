package com.helmo.NatAdmin.security;

import com.helmo.NatAdmin.models.Role;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService usrSrv;
	private final Environment env;
	private final PasswordEncoder passEnc;
	private User system;
	
	public UserDetailsServiceImpl(Environment env, PasswordEncoder passEnc) {
		this.env = env;
		this.passEnc = passEnc;
		this.system = new User();
		system.setEmail(env.getProperty("rest.user.system.email"));
		system.setPassword(passEnc.encode(env.getProperty("rest.user.system.password")));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usrSrv.findByEmail(username, system);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()){
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
	}
}
