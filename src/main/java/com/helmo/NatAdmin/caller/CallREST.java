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
	
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		String password = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(email, password));
		return restTemplate;
	}
	
	public <T> List<T> getAll(Class<T[]> receptionObject, String controllerName) {
		return Arrays.asList(createRestTemplate().exchange(
			  env.getProperty("rest.url") + "/" + controllerName,
			  HttpMethod.GET, null, receptionObject
		).getBody());
	}
	
	public <T> T getById(Class<T> receptionObject, String controllerName, long id) {
		return createRestTemplate().exchange(
			  env.getProperty("rest.url") + "/" + controllerName + "/" + id,
			  HttpMethod.GET, null, receptionObject
		).getBody();
	}
	
	public <T> T[] create(Class<T[]> rObject, String controllerName, T[] object) {
		return callWithMultiEntity(rObject, controllerName, object, HttpMethod.POST);
	}
	
	public <T> T[] update(Class<T[]> rObject, String controllerName, T[] object) {
//		new RestTemplate.postForEntity(env.getProperty("rest.url") + "/" + controllerName, object, rObject);
		return callWithMultiEntity(rObject, controllerName, object, HttpMethod.PUT);
	}
	
	private <T> T[] callWithMultiEntity(Class<T[]> rObject, String controllerName, T[] object, HttpMethod method) {
		HttpEntity<T[]> entity = new HttpEntity<>(object);
		return createRestTemplate().exchange(
			  env.getProperty("rest.url") + "/" + controllerName,
			  method, entity, rObject
		).getBody();
	}
	
	public <T> T[] delete(Class<T[]> rObject, String controllerName, T[] object) {
		return callWithMultiEntity(rObject, controllerName, object, HttpMethod.DELETE);
	}
	
	public <T> T deleteById(Class<T> rObject, String controllerName, long id) {
		return createRestTemplate().exchange(
			  env.getProperty("rest.url") + "/" + controllerName + "/" + id,
			  HttpMethod.DELETE, null, rObject
		).getBody();
	}
}
