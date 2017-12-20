package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RBird;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BirdService implements ICrudService<Bird> {
	
	private final String CONTROLLER_NAME = "birds";
	
	private final CallREST caller;
	
	public BirdService(@Qualifier("callREST") CallREST caller) {

		this.caller = caller;
	}
	
	private void setCredential(User user) {
//		restTemplate.getInterceptors().add(
//			  new BasicAuthorizationInterceptor(
//					user.getEmail(),
//					user.getPassword())
//		);
	}
	
	@Override
	public long create(Bird toCreate, User cred) {
		setCredential(cred);
		return caller.create(
			  RBird[].class, CONTROLLER_NAME,
			  new RBird[]{new RBird(toCreate)}
		)[0].getId();
	}
	
	@Override
	public void delete(Bird toDelete, User cred) {
		setCredential(cred);
		caller.delete(
			  RBird[].class, CONTROLLER_NAME,
			  new RBird[]{new RBird(toDelete)}
		);
	}
	
	@Override
	public void delete(long idToDelete, User cred) {
		setCredential(cred);
		caller.deleteById(
			  RBird.class, CONTROLLER_NAME,
			  idToDelete
		);
	}
	
	@Override
	public List<Bird> getAll(User cred) {
		setCredential(cred);
		List<RBird> rBirds = caller.getAll(RBird[].class, CONTROLLER_NAME);
		
		List<Bird> rtn = new ArrayList<>();
		for (RBird item : rBirds)
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public Bird getById(long id, User cred) {
		setCredential(cred);
		return caller.getById(RBird.class, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public void update(Bird toUpdate, User cred) {
		setCredential(cred);
		caller.update(
			  RBird[].class, CONTROLLER_NAME,
			  new RBird[]{new RBird(toUpdate)}
		);
	}
}
