package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.UserCall;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RUser;
import com.helmo.NatAdmin.reception.ReceptionObject;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements ICrudService<User> {
	
	private final String CONTROLLER_NAME = "users";
	
	private final UserCall caller;
	private final Class<RUser> CLASS = RUser.class;
	private final Class<RUser[]> CLASS_TAB = RUser[].class;
	
	
	public UserService(UserCall userCall) {
		this.caller = userCall;
	}
	
	@Override
	public List<User> getAll() {
		List<User> rtn = new ArrayList<>();
		caller.getAll(CLASS_TAB, CONTROLLER_NAME)
			  .forEach(
			  	  u -> rtn.add(u.getModel())
			  );
		return rtn;
	}
	
	@Override
	public User getById(long id) {
		return caller.getById(CLASS, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public List<User> getRange(long one, long two) {
		List<User> rtn = new ArrayList<>();
		caller.getRange(CLASS_TAB, CONTROLLER_NAME, one, two)
			  .forEach(
					u -> rtn.add(u.getModel())
			  );
		return rtn;
	}
	
	@Override
	public void update(User toUpdate) {
		caller.update(CLASS_TAB, CONTROLLER_NAME, new RUser[]{new RUser(toUpdate)});
	}
	
	@Override
	public long create(User toCreate) { //TODO Return the object itself
		return caller.create(CLASS_TAB, CONTROLLER_NAME, new RUser[]{new RUser(toCreate)})[0].getId();
	}
	
	@Override
	public void delete(User toDelete) {
		caller.delete(CLASS_TAB, CONTROLLER_NAME, new RUser[]{new RUser(toDelete)});
	}
	
	@Override
	public void delete(long idToDelete) {
		caller.deleteById(CLASS, CONTROLLER_NAME, idToDelete);
	}
	
	public User findByEmail(String email, String credentials) {
//		return SystemProvider.getSystem();
		return caller.getByEmail(email, credentials).getModel();
	}
}
