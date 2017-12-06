package com.helmo.NatAdmin.reception;

import com.helmo.NatAdmin.models.NotificationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RNotificationStatus extends IdentifiedModel
	  implements ReceptionObject<NotificationStatus> {
	
	private String name;
	
	public RNotificationStatus(NotificationStatus status) {
		this.name = status.getName();
	}
	
	@Override
	public NotificationStatus getModel() {
		NotificationStatus rtn = new NotificationStatus();
		rtn.setName(this.name);
		return rtn;
	}
}
