package com.helmo.NatAdmin.caller;

import com.helmo.NatAdmin.reception.ReceptionObject;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CallREST {
	protected final Environment env;
	
	public CallREST(Environment env) {
		this.env = env;
	}
	
	RestTemplate createRestTemplate() { //Package-Private scope
		RestTemplate restTemplate = new RestTemplate();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		String password = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(email, password));
		return restTemplate;
	}
	
	public <T extends ReceptionObject> List<T> getAll(Class<T[]> receptionObject, String controllerName) {
		return Arrays.asList(
			  createRestTemplate().getForObject(
					env.getProperty("rest.url") + "/" + controllerName,
					receptionObject));
	}
	
	public <T extends ReceptionObject> T getById(Class<T> receptionObject, String controllerName, long id) {
		return createRestTemplate().getForObject(
			  env.getProperty("rest.url") + "/" + controllerName + "/" + id,
			  receptionObject
		);
	}
	
	public <T extends ReceptionObject> List<T> getRange(Class<T[]> receptionObject, String controllerName, long one, long two) {
		return Arrays.asList(
			  createRestTemplate().getForObject(
				    env.getProperty("rest.url") + "/" + controllerName + "/" + one + "/" + two,
					receptionObject));
	}
	
	public <T extends ReceptionObject> T[] create(Class<T[]> rObject, String controllerName, T[] object) {
		return createRestTemplate().postForObject(
			  env.getProperty("rest.url") + "/" + controllerName,
			  object, rObject);
	}
	
	public <T extends ReceptionObject> void update(Class<T[]> rObject, String controllerName, T[] object) {
		createRestTemplate().put(
			  env.getProperty("rest.url") + "/" + controllerName,
			  object
		);
	}
	
	public <T extends ReceptionObject> void delete(Class<T[]> rObject, String controllerName, T[] object) {
		HttpEntity<T[]> entity = new HttpEntity<>(object);
		createRestTemplate().exchange(
			  env.getProperty("rest.url") + "/" + controllerName,
			  HttpMethod.DELETE, entity, rObject
		);
	}
	
	public <T extends ReceptionObject> void deleteById(Class<T> rObject, String controllerName, long id) {
		createRestTemplate().delete(
			  env.getProperty("rest.url") + "/" + controllerName + "/" + id
		);
	}
}
