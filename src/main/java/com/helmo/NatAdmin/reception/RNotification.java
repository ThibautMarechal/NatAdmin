package com.helmo.NatAdmin.reception;

import com.helmo.NatAdmin.models.Notification;
import lombok.Getter;
import lombok.Setter;

import javax.naming.NoInitialContextException;
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
