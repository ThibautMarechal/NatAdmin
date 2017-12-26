package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.reception.RBird;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BirdService implements ICrudService<Bird> {
	
	private final String CONTROLLER_NAME = "birds";
	private final Class<RBird> CLASS = RBird.class;
	private final Class<RBird[]> CLASS_TAB = RBird[].class;
	
	private final CallREST caller;
	
	public BirdService(@Qualifier("callREST") CallREST caller) {
		
		this.caller = caller;
	}
	
	@Override
	public long create(Bird toCreate) {
		return caller.create(
			  CLASS_TAB, CONTROLLER_NAME,
			  new RBird[]{new RBird(toCreate)}
		)[0].getId();
	}
	
	@Override
	public void delete(Bird toDelete) {
		caller.delete(
			  CLASS_TAB, CONTROLLER_NAME,
			  new RBird[]{new RBird(toDelete)}
		);
	}
	
	@Override
	public void delete(long idToDelete) {
		caller.deleteById(
			  CLASS, CONTROLLER_NAME,
			  idToDelete
		);
	}
	
	@Override
	public List<Bird> getAll() {
		List<RBird> rBirds = caller.getAll(CLASS_TAB, CONTROLLER_NAME);
		
		List<Bird> rtn = new ArrayList<>();
		for (RBird item : rBirds)
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public Bird getById(long id) {
		return caller.getById(CLASS, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public List<Bird> getRange(long one, long two) {
		List<Bird> rtn = new ArrayList<>();
		caller.getRange(CLASS_TAB, CONTROLLER_NAME, one, two)
			  .forEach(
					u -> rtn.add(u.getModel())
			  );
		return rtn;
	}
	
	@Override
	public void update(Bird toUpdate) {
		caller.update(
			  CLASS_TAB, CONTROLLER_NAME,
			  new RBird[]{new RBird(toUpdate)}
		);
	}
}
