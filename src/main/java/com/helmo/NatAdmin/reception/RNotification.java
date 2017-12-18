package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.models.NotificationStatus;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RNotification extends IdentifiedModel
		implements ReceptionObject<Notification> {
	
	private String caption;
	
	private String description;
	
	private Timestamp date;
	
	private RNotificationStatus status;
	
	@JsonProperty("observation")
	private RObservation rObservation;
	
	public RNotification() {
	}
	
	public RNotification(Notification not) {
		this.setId(not.getId());
		this.caption = not.getCaption();
		this.description = not.getDescription();
		this.date = new Timestamp(not.getDate().getTime());
		this.status = new RNotificationStatus(not.getStatus());
		this.rObservation = new RObservation(not.getObservation());
	}
	
	@Override
	public Notification getModel() {
		Notification rtn = new Notification();
		rtn.setId(this.getId());
		rtn.setCaption(this.caption);
		rtn.setDescription(this.description);
		rtn.setDate(this.date);
		rtn.setStatus(this.status.getModel());
		rtn.setObservation(this.rObservation.getModel());
		return rtn;
	}
}
