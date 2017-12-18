package com.helmo.NatAdmin.tools;

import com.helmo.NatAdmin.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SystemProvider {
	
	public static User getSystem() {
		PasswordEncoder passEnc = new BCryptPasswordEncoder();
		User rtn = new User();
		rtn.setEmail("system@nat.be");
		rtn.setPassword(passEnc.encode("rootroot"));
		return rtn;
	}
}
