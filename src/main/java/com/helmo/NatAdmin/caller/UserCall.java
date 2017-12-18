package com.helmo.NatAdmin.caller;

import com.helmo.NatAdmin.reception.RUser;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserCall extends CallREST {
	
	public UserCall(Environment env) {
		super(env);
	}
	
	public RUser getByEmail(String email, RestTemplate template) {
		return template.exchange(
			  env.getProperty("rest.url") + "/users/email/" + email,
			  HttpMethod.GET, null, RUser.class
		).getBody();
	}
}
