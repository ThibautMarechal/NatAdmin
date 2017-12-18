package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.Attribute;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RAttribute;
import com.helmo.NatAdmin.reception.RUser;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeService implements ICrudService<Attribute> {
	
	private final String CONTROLLER_NAME = "attributes";
	
	private final RestTemplate restTemplate;
	private final CallREST caller;
	
	public AttributeService(RestTemplate restTemplate, CallREST caller) {
		this.restTemplate = restTemplate;
		this.caller = caller;
	}
	
	private void setCredential(User user) {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor(
					user.getEmail(),
					user.getPassword())
		);
	}
	
	@Override
	public long create(Attribute toCreate, User cred) {
		setCredential(cred);
		return caller.create(RAttribute[].class, CONTROLLER_NAME, new RAttribute[] {new RAttribute(toCreate)}, restTemplate)[0].getId();
	}
	
	@Override
	public void delete(Attribute toDelete, User cred) {
		setCredential(cred);
		caller.delete(RAttribute[].class, CONTROLLER_NAME, new RAttribute[] {new RAttribute(toDelete)}, restTemplate);
	}
	
	@Override
	public void delete(long idToDelete, User cred) {
		setCredential(cred);
		caller.deleteById(RAttribute.class, CONTROLLER_NAME, idToDelete, restTemplate);
	}
	
	@Override
	public List<Attribute> getAll(User cred) {
		setCredential(cred);
        List<RAttribute> rAttributes = caller.getAll(RAttribute[].class, CONTROLLER_NAME, restTemplate);
		
		List<Attribute> rtn = new ArrayList<>();
		for (RAttribute item : rAttributes)
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public Attribute getById(long id, User cred) {
		setCredential(cred);
		return caller.getById(RAttribute.class, CONTROLLER_NAME, id, restTemplate).getModel();
	}
	
	@Override
	public void update(Attribute toUpdate, User cred) {
		setCredential(cred);
		caller.update(RAttribute[].class, CONTROLLER_NAME, new RAttribute[] {new RAttribute(toUpdate)}, restTemplate);
	}
}
