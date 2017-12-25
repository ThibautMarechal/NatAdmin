package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonProperty;
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
	
	@JsonProperty("status")
	private RNotificationStatus rStatus;
	
	@JsonProperty(value = "observation")
	private RObservation rObservation;
	
	public RNotification() {
	}
	
	public RNotification(Notification not) {
		this.setId(not.getId());
		this.caption = not.getCaption();
		this.description = not.getDescription();
		this.date = (not.getDate() != null)
			  ? new Timestamp(not.getDate().getTime())
			  : null;
		this.rStatus = new RNotificationStatus(not.getStatus());
		this.rObservation = (not.getObservation() != null)
			  ? new RObservation(not.getObservation())
			  : null;
	}
	
	@Override
	public Notification getModel() {
		Notification rtn = new Notification();
		rtn.setId(this.getId());
		rtn.setCaption(this.caption);
		rtn.setDescription(this.description);
		rtn.setDate(this.date);
		rtn.setStatus(this.rStatus.getModel());
		rtn.setObservation((this.rObservation != null)
			  ? this.rObservation.getModel()
			  : null);
		return rtn;
	}
}
