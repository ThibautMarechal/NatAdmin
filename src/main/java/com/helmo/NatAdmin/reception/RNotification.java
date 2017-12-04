package com.helmo.NatAdmin.reception;

import com.helmo.NatAdmin.models.Notification;
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
	
	private boolean status;
	
	private RObservation rObservation;
	
	public RNotification() {
	}
	
	public RNotification(Notification not) {
		this.setId(not.getId());
		this.caption = not.getCaption();
		this.description = not.getDescription();
		this.date = new Timestamp(not.getDate().getTime());
		this.status = not.isStatus();
		this.rObservation = new RObservation(not.getObservation());
	}
	
	@Override
	public Notification getModel() {
		Notification rtn = new Notification();
		rtn.setId(this.getId());
		rtn.setCaption(this.caption);
		rtn.setDescription(this.description);
		rtn.setDate(this.date);
		rtn.setStatus(this.status);
		rtn.setObservation(this.rObservation.getModel());
		return rtn;
	}
}
