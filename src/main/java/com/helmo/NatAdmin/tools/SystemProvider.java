package com.helmo.NatAdmin.tools;

import com.helmo.NatAdmin.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SystemProvider {
	
	@Autowired
	private static Environment env;
	@Autowired
	private static PasswordEncoder passEnc;
	
	public static User getSystem() {
		User rtn = new User();
		rtn.setEmail(env.getProperty("rest.user.system.email"));
		rtn.setPassword(passEnc.encode(env.getProperty("rest.user.system.password")));
		return rtn;
	}
}
