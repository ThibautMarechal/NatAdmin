package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.reception.CallREST;
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
	}
	
	@Override
	public long create(Session toCreate) {
		//TODO
		return 1;
	}
	
	@Override
	public void delete(Session toDelete) {
		//TODO
	}
	
	@Override
	public void delete(long idToDelete) {
		//TODO
	}
	
	@Override
	public List<Session> getAll() {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		List<RSession> rSessions = caller.getAll(RSession[].class, CONTROLLER_NAME, restTemplate);
		
		List<Session> rtn = new ArrayList<>();
		for (RSession ses : rSessions)
			rtn.add(ses.getModel());
		return rtn;
	}
	
	@Override
	public Session getById(long id) {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		return caller.getById(RSession.class, CONTROLLER_NAME, id, restTemplate).getModel();
	}
	
	@Override
	public void update(Session toUpdate) {
	
	}
}
