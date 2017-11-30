package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.security.RestTemplateFactory;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements ICrudService<User> {
	
	private final RestTemplate restTemplate;
	private final Environment env;
	
	
	public UserService(RestTemplate template, Environment env) {
		restTemplate = template;
		this.env = env;
	}
	
	@Override
	public List<User> getAll() {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		return Arrays.asList(restTemplate.exchange(
			  env.getProperty("rest.url") + "/users",
			  HttpMethod.GET, null, User[].class
		).getBody());
	}
	
	@Override
	public User getById(long id) {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		return restTemplate.exchange(
			  env.getProperty("rest.url") + "/users/" + id,
			  HttpMethod.GET, null, User.class
		).getBody();
	}
	
	@Override
	public void update(User toUpdate) {
		//TODO REST CALL
	}
	
	@Override
	public void create(User toUpdate) {
		//TODO REST CALL
	}
	
	@Override
	public void delete(User toUpdate) {
		//TODO REST CALL
	}
	
	@Override
	public void delete(long idToDelete) {
		//TODO REST CALL
	}
}
