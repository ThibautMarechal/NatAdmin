package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.UserCall;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RUser;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements ICrudService<User> {
	
	private final String CONTROLLER_NAME = "users";
	
	private final UserCall caller;
	
	
	public UserService(UserCall userCall) {
		this.caller = userCall;
	}
	
	@Override
	public List<User> getAll() {
		List<User> rtn = new ArrayList<>();
		for (RUser item : caller.getAll(RUser[].class, CONTROLLER_NAME))
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public User getById(long id) {
		return caller.getById(RUser.class, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public void update(User toUpdate) {
		caller.update(RUser[].class, CONTROLLER_NAME, new RUser[]{new RUser(toUpdate)});
	}
	
	@Override
	public long create(User toCreate) { //TODO Return the object itself
		return caller.create(RUser[].class, CONTROLLER_NAME, new RUser[]{new RUser(toCreate)})[0].getId();
	}
	
	@Override
	public void delete(User toDelete) {
		caller.delete(RUser[].class, CONTROLLER_NAME, new RUser[]{new RUser(toDelete)});
	}
	
	@Override
	public void delete(long idToDelete) {
		caller.deleteById(RUser.class, CONTROLLER_NAME, idToDelete);
	}
	
	public User findByEmail(String email, String credentials) {
//		return SystemProvider.getSystem();
		return caller.getByEmail(email, credentials).getModel();
	}
}
