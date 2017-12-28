package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.reception.RNotification;
import com.helmo.NatAdmin.services.crudServices.IRangeService;
import com.helmo.NatAdmin.services.crudServices.IReadService;
import com.helmo.NatAdmin.services.crudServices.IUpdateService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService 
	  implements IReadService<Notification>, IUpdateService<Notification>, IRangeService<Notification> {
	
	private final String CONTROLLER_NAME = "notifications";
	private final Class<RNotification> CLASS = RNotification.class;
	private final Class<RNotification[]> CLASS_TAB = RNotification[].class;
	
	private final CallREST caller;
	
	public NotificationService(@Qualifier("callREST") CallREST caller) {
		
		this.caller = caller;
	}	
	
	public List<Notification> getAll() {
		List<Notification> rtn = new ArrayList<>();
		for (RNotification item : caller.getAll(CLASS_TAB, CONTROLLER_NAME))
			rtn.add(item.getModel());
		return rtn;
	}
	
	@Override
	public Notification getById(long id) {
		return caller.getById(CLASS, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public List<Notification> getRange(long one, long two) {
		List<Notification> rtn = new ArrayList<>();
		caller.getRange(CLASS_TAB, CONTROLLER_NAME, one, two)
			  .forEach(
					u -> rtn.add(u.getModel())
			  );
		return rtn;
	}
	
	@Override
	public void update(Notification toUpdate) {
		caller.update(
			  CLASS_TAB,
			  CONTROLLER_NAME,
			  new RNotification[]{new RNotification(toUpdate)});
	}
}
