package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.UserCall;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RUser;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import com.helmo.NatAdmin.tools.SystemProvider;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements ICrudService<User> {
	
	private final String CONTROLLER_NAME = "users";
	
	private final UserCall caller;
	
	
	public UserService(UserCall userCall) {
		this.caller = userCall;
	}
	
	private void setCredential(User user) {
//		restTemplate.getInterceptors().add(
//			  new BasicAuthorizationInterceptor(
//					user.getEmail(),
//					user.getPassword())
//		);
	}
	
	@Override
	public List<User> getAll(User cred) {
		setCredential(cred);
		
		List<RUser> rUsers = caller.getAll(RUser[].class, CONTROLLER_NAME);
		
		List<User> rtn = new ArrayList<>();
		for (RUser item : rUsers)
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public User getById(long id, User cred) {
		setCredential(cred);
		return caller.getById(RUser.class, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public void update(User toUpdate, User cred) {
		setCredential(cred);
		caller.update(RUser[].class, CONTROLLER_NAME, new RUser[]{new RUser(toUpdate)});
	}
	
	@Override
	public long create(User toCreate, User cred) { //TODO Return the object itself
		setCredential(cred);
		return caller.create(RUser[].class, CONTROLLER_NAME, new RUser[]{new RUser(toCreate)})[0].getId();
	}
	
	@Override
	public void delete(User toDelete, User cred) {
		setCredential(cred);
		caller.delete(RUser[].class, CONTROLLER_NAME, new RUser[]{new RUser(toDelete)});
	}
	
	@Override
	public void delete(long idToDelete, User cred) {
		setCredential(cred);
		caller.deleteById(RUser.class, CONTROLLER_NAME, idToDelete);
	}
	
	public User findByEmail(String email, String credentials) {
//		return SystemProvider.getSystem();
		return caller.getByEmail(email, credentials).getModel();
	}
}
