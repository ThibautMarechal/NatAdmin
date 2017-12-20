package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.caller.ObservationCaller;
import com.helmo.NatAdmin.models.Observation;
import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RObservation;
import com.helmo.NatAdmin.reception.RSession;
import com.helmo.NatAdmin.services.crudServices.ICreateService;
import com.helmo.NatAdmin.services.crudServices.IReadService;
import com.helmo.NatAdmin.services.crudServices.IUpdateService;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationService implements IUpdateService<Observation>, IReadService<Observation> {
	
	private final String CONTROLLER_NAME = "observations";
	
	private final ObservationCaller caller;
	
	
	public ObservationService(ObservationCaller caller) {
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
	public List<Observation> getAll(User cred) {
		setCredential(cred);
		List<Observation> rtn = new ArrayList<>();
		for (RObservation obs : caller.getAll(RObservation[].class, CONTROLLER_NAME))
			rtn.add(obs.getModel());
		return rtn;
	}
	
	@Override
	public Observation getById(long id, User cred) {
		setCredential(cred);
		return  caller.getById(RObservation.class, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public void update(Observation toUpdate, User cred) {
		setCredential(cred);
		caller.update(
			  RObservation[].class, CONTROLLER_NAME,
			  new RObservation[]{new RObservation(toUpdate)});
	}
	
	public void validate(long id) {
		caller.validate(id);
	}
	
}
