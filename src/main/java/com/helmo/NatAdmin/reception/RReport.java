package com.helmo.NatAdmin.reception;

import com.helmo.NatAdmin.models.Report;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RReport extends IdentifiedModel implements ReceptionObject<Report> {
	
	private String commentary;
	
	private Timestamp date;
	
	private RUser rUser;
	
	private RObservation rObservation;
	
	public RReport() {
	}
	
	@Override
	public Report getModel() {
		Report rtn = new Report();
		rtn.setId(this.getId());
		rtn.setCommentary(this.commentary);
		rtn.setDate(this.date);
		rtn.setUser(this.rUser.getModel());
		rtn.setObservation(this.rObservation.getModel());
		return rtn;
	}
}
