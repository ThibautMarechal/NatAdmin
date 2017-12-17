package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.LoginForm;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.UserService;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final PasswordEncoder passEnc;
	private final UserService usrSrv;
	private final Environment env;
	
	private User systemUser;
	
	public LoginController(PasswordEncoder passEnc, UserService usrSrv, Environment env) {
		this.passEnc = passEnc;
		this.usrSrv = usrSrv;
		this.env = env;
		
		systemUser = new User();
		systemUser.setEmail(env.getProperty("rest.user.system.email"));
		systemUser.setPassword(passEnc.encode(env.getProperty("rest.user.system.password")));
	}
	
	@GetMapping
	public void index(LoginForm model) {
		User user = new User();
		user.setEmail(model.getUsername());
		user.setPassword(passEnc.encode(model.getPassword()));
		
		User dbUser = usrSrv.findByEmail(user.getEmail(), systemUser);
	}
}
