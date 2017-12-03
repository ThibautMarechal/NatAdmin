package com.helmo.NatAdmin.reception;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CallREST {
	private final Environment env;
	
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
	
	public <T> T create(Class<T> rObject, String controllerName, T object, RestTemplate restTemplate) {
		HttpEntity<T> entity = new HttpEntity<>(object);
		return restTemplate.exchange(
			  env.getProperty("rest.url") + "/" + controllerName,
			  HttpMethod.POST, entity, rObject
		).getBody();
	}
}
