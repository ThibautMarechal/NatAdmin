//package com.helmo.NatAdmin.security;
//
//import com.helmo.NatAdmin.models.Role;
//import com.helmo.NatAdmin.models.User;
//import com.helmo.NatAdmin.services.UserService;
//import com.helmo.NatAdmin.tools.SystemProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//	@Autowired
//	private UserService usrRepo;
//
//	@Autowired
//	private PasswordEncoder passEnc;
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//		String name = authentication.getName();
//		String password = authentication.getCredentials().toString();
//
//		User admin = new User();
//		admin.setPassword("adminadmin");
//		admin.setEmail("admin@nat.be");
//
//		User usr = usrRepo.findByEmail(name, admin);
////		User usr = usrRepo.findByEmail(name, SystemProvider.getSystem());
//
//		if (usr != null && passEnc.matches(password, usr.getPassword())) {
//
//			List<GrantedAuthority> auths = new ArrayList<>();
//			for (Role role : usr.getRoles()) {
//				auths.add(new SimpleGrantedAuthority(role.getName()));
//			}
//			if (usr.isAdmin() && !auths.contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
//				auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//
//			// use the credentials
//			// and authenticate against the third-party system
//			return new UsernamePasswordAuthenticationToken(
//				  name, password, auths);
//		} else {
//			throw new UsernameNotFoundException("User doesn't exist");
//		}
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return authentication.equals(
//			  UsernamePasswordAuthenticationToken.class);
//	}
//}
