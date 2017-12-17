package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.UserCall;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.reception.RUser;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements ICrudService<User> {
	
	private final String CONTROLLER_NAME = "users";
	
	private final RestTemplate restTemplate;
	private final UserCall caller;
	
	
	public UserService(RestTemplate template, UserCall userCall) {
		restTemplate = template;
		this.caller = userCall;
	}
	
	@Override
	public List<User> getAll(User cred) {
		restTemplate.getInterceptors().add(
				new BasicAuthorizationInterceptor(
						cred.getEmail(),
						cred.getPassword())
		);
		
		List<RUser> rUsers = caller.getAll(RUser[].class, CONTROLLER_NAME, restTemplate);
		
		List<User> rtn = new ArrayList<>();
		for (RUser item : rUsers)
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public User getById(long id, User cred) {
		
		return caller.getById(RUser.class, CONTROLLER_NAME, id, restTemplate).getModel();
	}
	
	@Override
	public void update(User toUpdate, User cred) {
		caller.update(RUser[].class, CONTROLLER_NAME, new RUser[] {new RUser(toUpdate)}, restTemplate);
	}
	
	@Override
	public long create(User toCreate, User cred) { //TODO Return the object itself
		return caller.create(RUser[].class, CONTROLLER_NAME, new RUser[] {new RUser(toCreate)}, restTemplate)[0].getId();
	}
	
	@Override
	public void delete(User toDelete, User cred) {
		caller.delete(RUser[].class, CONTROLLER_NAME, new RUser[] {new RUser(toDelete)}, restTemplate);
	}
	
	@Override
	public void delete(long idToDelete, User cred) {
		caller.deleteById(RUser.class, CONTROLLER_NAME, idToDelete, restTemplate);
	}
	
	public User findByEmail(String email, User cred) {
		return caller.getByEmail(email, restTemplate).getModel();
	}
}
