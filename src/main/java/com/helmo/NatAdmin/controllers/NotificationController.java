package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.models.NotificationStatus;
import com.helmo.NatAdmin.services.NotificationService;
import com.helmo.NatAdmin.services.ObservationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("notifications")
public class NotificationController {
	
	private final NotificationService notificationService;
	private final ObservationService obsSrv;
	
	public NotificationController(NotificationService notificationService, ObservationService obsSrv) {
		this.notificationService = notificationService;
		this.obsSrv = obsSrv;
		
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		List<Notification> notifications = notificationService.getAll();
		model.addAttribute("notifications", notifications);
		return "notifications/all";
	}
	
	@RequestMapping(value = "accept/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String accept(@PathVariable("id") long id, Notification model) {
		Notification notification = changeNotificationStatus(new NotificationStatus("ACCEPTED"), id);
		//TODO Update Observation
		obsSrv.validate(notification.getObservation().getId());
		return "{\"status\":1}";
	}
	
	@RequestMapping(value = "refuse/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String refuse(@PathVariable("id") long id, Notification model) {
		Notification notification = changeNotificationStatus(new NotificationStatus("REFUSED"), id);
		//TODO Update Observation
		obsSrv.refused(notification.getObservation().getId());
		return "{\"status\":1}";
	}
	
	private Notification changeNotificationStatus(NotificationStatus status, long id) {
		Notification notification = notificationService.getById(id);
		
		notification.setStatus(status);
		notification.setId(id);
		notification.setObservation(null);
		notificationService.update(notification);
		return notification;
	}
}
