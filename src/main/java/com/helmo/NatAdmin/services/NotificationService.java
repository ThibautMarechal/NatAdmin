package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RNotification;
import com.helmo.NatAdmin.services.crudServices.IReadService;
import com.helmo.NatAdmin.services.crudServices.IUpdateService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements IReadService<Notification>, IUpdateService<Notification> {
	
	private final String CONTROLLER_NAME = "notifications";
	
	private final CallREST caller;
	
	public NotificationService(@Qualifier("callREST") CallREST caller) {

		this.caller = caller;
	}
	
	private void setCredential(User user) {
//		BasicAuthorizationInterceptor auth = new BasicAuthorizationInterceptor(
//			  user.getEmail(),
//			  user.getPassword());
//		BasicAuthorizationInterceptor auth = new BasicAuthorizationInterceptor(
//			  "admin@nat.be",
//			  "adminadmin");
//		if(!restTemplate.getInterceptors().contains(auth))
//			restTemplate.getInterceptors().add(auth);
	}
	
	
	public List<Notification> getAll(User cred) {
		setCredential(cred);
		List<Notification> rtn = new ArrayList<>();
		for (RNotification item : caller.getAll(RNotification[].class, CONTROLLER_NAME))
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public Notification getById(long id, User cred) {
		setCredential(cred);
		return caller.getById(RNotification.class, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public void update(Notification toUpdate, User cred) {
		setCredential(cred);
		caller.update(
			  RNotification[].class,
			  CONTROLLER_NAME,
			  new RNotification[]{new RNotification(toUpdate)});
	}
}
