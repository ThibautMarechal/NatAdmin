package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helmo.NatAdmin.models.Report;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RReport extends IdentifiedModel
	  implements ReceptionObject<Report> {
	
	private String commentary;
	private Timestamp date;
	@JsonProperty("user")
	private RUser rUser;
	@JsonProperty("observations")
	private RObservation rObservation;
	
	public RReport() {
	}
	
	public RReport(Report rep) {
		this.commentary = rep.getCommentary();
		this.date = new Timestamp(rep.getDate().getTime());
		this.rUser = new RUser(rep.getUser());
		this.rObservation = new RObservation(rep.getObservation());
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
