package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.reception.CallREST;
import com.helmo.NatAdmin.reception.RNotification;
import com.helmo.NatAdmin.services.crudServices.IReadService;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements IReadService<Notification> {
	
	private final String CONTROLLER_NAME = "notifications";
	
	private final RestTemplate restTemplate;
	private final CallREST caller;
	
	public NotificationService(RestTemplate restTemplate, CallREST caller) {
		this.restTemplate = restTemplate;
		this.caller = caller;
	}
	
	
	public List<Notification> getAll() {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		List<RNotification> rUsers = caller.getAll(RNotification[].class, CONTROLLER_NAME, restTemplate);
		
		List<Notification> rtn = new ArrayList<>();
		for (RNotification item : rUsers)
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public Notification getById(long id) {
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		return caller.getById(RNotification.class, CONTROLLER_NAME, id, restTemplate).getModel();
	}
	
	public void acceptNotification(long id) {
		//TODO REST CALL
	}
	
	public void refuseNotification(long id) {
		//TODO REST CALL
	}
}
