package com.helmo.NatAdmin.caller;

import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RUser;
import com.helmo.NatAdmin.tools.SystemProvider;
import org.json.HTTP;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserCall extends CallREST {
	
	public UserCall(Environment env) {
		super(env);
	}
	
	public RUser getByEmail(String email, String password) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(email, password));
		return restTemplate.getForObject(
				env.getProperty("rest.url") + "/users/email",
				RUser.class);

//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("email", email);
//		return template.getForObject(
//			  "/users/email", RUser.class, params
//		);
	}
}
