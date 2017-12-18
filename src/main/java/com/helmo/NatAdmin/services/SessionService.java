package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RSession;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService implements ICrudService<Session> {
	
	private final String CONTROLLER_NAME = "sessions";
	
	private final RestTemplate restTemplate;
	private final CallREST caller;
	
	
	public SessionService(RestTemplate template, CallREST caller) {
		restTemplate = template;
		this.caller = caller;
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
	}
	
	@Override
	public long create(Session toCreate, User cred) {
		return caller.create(
			  RSession[].class, CONTROLLER_NAME,
			  new RSession[] {new RSession(toCreate)}, restTemplate
		)[0].getId();
	}
	
	@Override
	public void delete(Session toDelete, User cred) {
		caller.delete(
			  RSession[].class, CONTROLLER_NAME,
			  new RSession[] {new RSession(toDelete)}, restTemplate
		);
	}
	
	@Override
	public void delete(long idToDelete, User cred) {
		caller.deleteById(
			  RSession.class, CONTROLLER_NAME,
			  idToDelete, restTemplate
		);
	}
	
	@Override
	public List<Session> getAll(User cred) {
		List<Session> rtn = new ArrayList<>();
		for (RSession ses : caller.getAll(RSession[].class, CONTROLLER_NAME, restTemplate))
			rtn.add(ses.getModel());
		return rtn;
	}
	
	@Override
	public Session getById(long id, User cred) {
		return caller.getById(RSession.class, CONTROLLER_NAME, id, restTemplate).getModel();
	}
	
	@Override
	public void update(Session toUpdate, User cred) {
		caller.update(
			  RSession[].class, CONTROLLER_NAME,
			  new RSession[] {new RSession(toUpdate)}, restTemplate);
	}
}
