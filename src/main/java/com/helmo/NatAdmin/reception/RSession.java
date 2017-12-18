package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.helmo.NatAdmin.models.Observation;
import com.helmo.NatAdmin.models.Session;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties("RUser")
public class RSession extends IdentifiedModel
	  implements ReceptionObject<Session> {
	
	private String name;
	
	private Timestamp dateStart;
	private Timestamp dateEnd;
	
	
	private String latitude;
	private String longitude;
	
	@JsonProperty("observations")
	private List<RObservation> rObservations;
	
	@JsonProperty("user")
	private RUser rUser;
	
	public RSession() {
	}
	
	public RSession(Session ses) {
		this.setId(ses.getId());
		this.name = ses.getName();
		this.dateStart = new Timestamp(ses.getStart().getTime());
		this.dateEnd = new Timestamp(ses.getEnd().getTime());
		this.latitude = ses.getLatitude();
		this.longitude = ses.getLongitude();
		this.rObservations = convertRObservations(ses.getObservations());
	}
	
	private List<RObservation> convertRObservations(List<Observation> observations) {
		List<RObservation> rtn = new ArrayList<>();
		for (Observation obs : observations)
			rtn.add(new RObservation(obs));
		return rtn;
	}
	
	@Override
	public Session getModel() {
		Session rtn = new Session();
		rtn.setId(this.getId());
		rtn.setName(this.name);
		rtn.setLatitude(this.latitude);
		rtn.setLongitude(this.longitude);
		rtn.setStart(this.dateStart);
		rtn.setEnd(this.dateEnd);
		rtn.setUser((rUser != null)
			  ? rUser.getModel()
			  : null);
		rtn.setObservations(getObservations());
		
		return rtn;
	}
	
	public List<Observation> getObservations() {
		List<Observation> output = new ArrayList<>();
		for (RObservation item : rObservations)
			output.add(item.getModel());
		return output;
	}
}
