package com.helmo.NatAdmin.caller;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ObservationCaller extends CallREST {
	public ObservationCaller(Environment env) {
		super(env);
	}
	
	public void validate(long id) {
		createRestTemplate().put(
			  env.getProperty("rest.url") + "/observations/validate/" + id,
			  null
		);
	}
	
	public void refused(long id) {
		createRestTemplate().put(
			  env.getProperty("rest.url") + "/observations/refused/" + id,
			  null
		);
	}
}
