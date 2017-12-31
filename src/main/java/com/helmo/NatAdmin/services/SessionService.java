package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.reception.RSession;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService implements ICrudService<Session> {
	
	private final String CONTROLLER_NAME = "sessions";
	private final Class<RSession> CLASS = RSession.class;
	private final Class<RSession[]> CLASS_TAB = RSession[].class;
	
	private final CallREST caller;
	
	
	public SessionService(@Qualifier("callREST") CallREST caller) {
		this.caller = caller;
	}
	
	@Override
	public long create(Session toCreate) {
		return caller.create(
			  CLASS_TAB, CONTROLLER_NAME,
			  new RSession[]{new RSession(toCreate)}
		)[0].getId();
	}
	
	@Override
	public void delete(Session toDelete) {
		caller.delete(
			  CLASS_TAB, CONTROLLER_NAME,
			  new RSession[]{new RSession(toDelete)}
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
	public List<Session> getAll() {
		List<Session> rtn = new ArrayList<>();
		caller.getAll(CLASS_TAB, CONTROLLER_NAME)
			  .forEach(s -> rtn.add(s.getModel()));
		return rtn;
	}
	
	@Override
	public Session getById(long id) {
		return caller.getById(CLASS, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public List<Session> getRange(long one, long two) {
		List<Session> rtn = new ArrayList<>();
		caller.getRange(CLASS_TAB, CONTROLLER_NAME, one, two)
			  .forEach(
					u -> rtn.add(u.getModel())
			  );
		return rtn;
	}
	
	@Override
	public void update(Session toUpdate) {
		caller.update(
			  CLASS_TAB, CONTROLLER_NAME,
			  new RSession[]{new RSession(toUpdate)});
	}
}
