package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RBird;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BirdService implements ICrudService<Bird> {
	
	private final String CONTROLLER_NAME = "birds";
	
	private final RestTemplate restTemplate;
	private final CallREST caller;
	
	public BirdService(RestTemplate restTemplate, CallREST caller) {
		this.restTemplate = restTemplate;
		this.caller = caller;
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
	}
	
	
	@Override
	public long create(Bird toCreate, User cred) {
		return caller.create(
			  RBird[].class, CONTROLLER_NAME,
			  new RBird[] {new RBird(toCreate)}, restTemplate
		)[0].getId();
	}
	
	@Override
	public void delete(Bird toDelete, User cred) {
		caller.delete(
			  RBird[].class, CONTROLLER_NAME,
			  new RBird[] {new RBird(toDelete)}, restTemplate
		);
	}
	
	@Override
	public void delete(long idToDelete, User cred) {
		caller.deleteById(
			  RBird.class, CONTROLLER_NAME,
			  idToDelete, restTemplate
		);
	}
	
	@Override
	public List<Bird> getAll(User cred) {
		List<RBird> rBirds = caller.getAll(RBird[].class, CONTROLLER_NAME, restTemplate);
		
		List<Bird> rtn = new ArrayList<>();
		for (RBird item : rBirds)
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public Bird getById(long id, User cred) {
		return caller.getById(RBird.class, CONTROLLER_NAME, id, restTemplate).getModel();
	}
	
	@Override
	public void update(Bird toUpdate, User cred) {
		caller.update(
			  RBird[].class, CONTROLLER_NAME,
			  new RBird[] {new RBird(toUpdate)}, restTemplate
		);
	}
}
