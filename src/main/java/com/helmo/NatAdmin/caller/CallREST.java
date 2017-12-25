package com.helmo.NatAdmin.caller;

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
	
	public <T> List<T> getAll(Class<T[]> receptionObject, String controllerName) {
		return Arrays.asList(
			  createRestTemplate().getForObject(
					env.getProperty("rest.url") + "/" + controllerName,
					receptionObject));
	}
	
	public <T> T getById(Class<T> receptionObject, String controllerName, long id) {
		return createRestTemplate().getForObject(
			  env.getProperty("rest.url") + "/" + controllerName + "/" + id,
			  receptionObject
		);
	}
	
	public <T> T[] create(Class<T[]> rObject, String controllerName, T[] object) {
		return createRestTemplate().postForObject(
			  env.getProperty("rest.url") + "/" + controllerName,
			  object, rObject);
//		return callWithMultiEntity(rObject, controllerName, object, HttpMethod.POST);
	}
	
	public <T> void update(Class<T[]> rObject, String controllerName, T[] object) {
//		new RestTemplate.postForEntity(env.getProperty("rest.url") + "/" + controllerName, object, rObject);
		createRestTemplate().put(
			  env.getProperty("rest.url") + "/" + controllerName,
			  object
		);
//		return callWithMultiEntity(rObject, controllerName, object, HttpMethod.PUT);
	}
	
	public <T> void delete(Class<T[]> rObject, String controllerName, T[] object) {
		HttpEntity<T[]> entity = new HttpEntity<>(object);
		createRestTemplate().exchange(
			  env.getProperty("rest.url") + "/" + controllerName,
			  HttpMethod.DELETE, entity, rObject
		);
	}
	
	public <T> void deleteById(Class<T> rObject, String controllerName, long id) {
		createRestTemplate().delete(
			  env.getProperty("rest.url") + "/" + controllerName + "/" + id
		);
	}
}
