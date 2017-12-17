package com.helmo.NatAdmin.caller;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class CallREST {
	protected final Environment env;
	
	public CallREST(Environment env) {
		this.env = env;
	}
	
	public <T> List<T> getAll(Class<T[]> receptionObject, String controllerName, RestTemplate restTemplate) {
		return Arrays.asList(restTemplate.exchange(
			  env.getProperty("rest.url") + "/" + controllerName,
			  HttpMethod.GET, null, receptionObject
		).getBody());
	}
	
	public <T> T getById(Class<T> receptionObject, String controllerName, long id, RestTemplate restTemplate) {
		return restTemplate.exchange(
			  env.getProperty("rest.url") + "/" + controllerName + "/" + id,
			  HttpMethod.GET, null, receptionObject
		).getBody();
	}
	
	public <T> T[] create(Class<T[]> rObject, String controllerName, T[] object, RestTemplate restTemplate) {
		return callWithMultiEntity(rObject, controllerName, object, restTemplate, HttpMethod.POST);
	}
	
	public <T> T[] update(Class<T[]> rObject, String controllerName, T[] object, RestTemplate restTemplate) {
		return callWithMultiEntity(rObject, controllerName, object, restTemplate, HttpMethod.PUT);
	}
	
	private <T> T[] callWithMultiEntity(Class<T[]> rObject, String controllerName, T[] object, RestTemplate restTemplate, HttpMethod method) {
		HttpEntity<T[]> entity = new HttpEntity<>(object);
		return restTemplate.exchange(
				env.getProperty("rest.url") + "/" + controllerName,
				method, entity, rObject
		).getBody();
	}
	
	public <T> T[] delete(Class<T[]> rObject, String controllerName, T[] object, RestTemplate restTemplate) {
		return callWithMultiEntity(rObject, controllerName, object, restTemplate, HttpMethod.DELETE);
	}
	
	public <T> T deleteById(Class<T> rObject, String controllerName, long id, RestTemplate restTemplate) {
		return restTemplate.exchange(
			  env.getProperty("rest.url") + "/" + controllerName + "/" + id,
			  HttpMethod.DELETE, null, rObject
		).getBody();
	}
}