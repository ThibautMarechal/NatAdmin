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
	
	private final CallREST caller;
	
	
	public SessionService(@Qualifier("callREST") CallREST caller) {
		this.caller = caller;
	}
	
	@Override
	public long create(Session toCreate) {
		return caller.create(
			  RSession[].class, CONTROLLER_NAME,
			  new RSession[]{new RSession(toCreate)}
		)[0].getId();
	}
	
	@Override
	public void delete(Session toDelete) {
		caller.delete(
			  RSession[].class, CONTROLLER_NAME,
			  new RSession[]{new RSession(toDelete)}
		);
	}
	
	@Override
	public void delete(long idToDelete) {
		caller.deleteById(
			  RSession.class, CONTROLLER_NAME,
			  idToDelete
		);
	}
	
	@Override
	public List<Session> getAll() {
		List<Session> rtn = new ArrayList<>();
		caller.getAll(RSession[].class, CONTROLLER_NAME)
			  .forEach(s -> rtn.add(s.getModel()));
		return rtn;
	}
	
	@Override
	public Session getById(long id) {
		return caller.getById(RSession.class, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public void update(Session toUpdate) {
		caller.update(
			  RSession[].class, CONTROLLER_NAME,
			  new RSession[]{new RSession(toUpdate)});
	}
}
