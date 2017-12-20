package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.models.NotificationStatus;
import com.helmo.NatAdmin.models.Observation;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.NotificationService;
import com.helmo.NatAdmin.services.ObservationService;
import com.helmo.NatAdmin.tools.SystemProvider;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private User system;
	
	public NotificationController(NotificationService notificationService, ObservationService obsSrv) {
		this.notificationService = notificationService;
		this.obsSrv = obsSrv;
		system = SystemProvider.getSystem();
		
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		List<Notification> notifications = notificationService.getAll(system);
		model.addAttribute("notifications", notifications);
		return "notifications/all";
	}
	
	@RequestMapping(value = "accept/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String accept(@PathVariable("id") long id, Notification model) {
		Notification notification = notificationService.getById(id, system);
	
		NotificationStatus status = new NotificationStatus();
		status.setName("ACCEPTED");
		
		long idObs = notification.getObservation().getId();
		
		notification.setStatus(status);
		notification.setId(model.getId());
		notification.setObservation(null);
		notificationService.update(notification, system);
		
		//TODO Update Observation
//		Observation obsToUpdate = obsSrv.getById(idObs, system);
//		obsToUpdate.setValid(true);
//		obsSrv.update(obsToUpdate, system);
		obsSrv.validate(idObs);
		return "{\"status\":1}";
	}
	
	@RequestMapping(value = "refuse/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String refuse(@PathVariable("id") long id, Model model) {
		Notification notification = new Notification();
		NotificationStatus status = new NotificationStatus();
		status.setName("REFUSED");
		//TODO Receive a good model and define Notification
		notification.setStatus(status);
		notificationService.update(notification, system);
		
		//TODO Update Observation
		Observation obsToUpdate = notification.getObservation();
		obsToUpdate.setValid(false);
		return "{\"status\":1}";
	}
}
