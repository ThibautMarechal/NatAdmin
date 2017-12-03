package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.reception.CallREST;
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
	}
	
	
	@Override
	public long create(Bird toCreate) {
		//TODO REST CALL
		return 1;
	}
	
	@Override
	public void delete(Bird toDelete) {
		//TODO REST CALL
	}
	
	@Override
	public void delete(long idToDelete) {
		//TODO REST CALL
	}
	
	@Override
	public List<Bird> getAll() {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		List<RBird> rBirds = caller.getAll(RBird[].class, CONTROLLER_NAME, restTemplate);
		
		List<Bird> rtn = new ArrayList<>();
		for (RBird item : rBirds)
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public Bird getById(long id) {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		return caller.getById(RBird.class, CONTROLLER_NAME, id, restTemplate).getModel();
	}
	
	@Override
	public void update(Bird toUpdate) {
		//TODO REST CALL
	}
}
