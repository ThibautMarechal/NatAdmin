package com.helmo.NatAdmin.models;

import com.helmo.NatAdmin.reception.RObservation;
import com.helmo.NatAdmin.reception.RSession;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Session extends IdentifiedModel
	  implements ExchangeObject<RSession> {
	private User user;
	private String name;
	private Date start;
	private Date end;
	private String latitude;
	private String longitude;
	private List<Observation> observations;
	private String location;
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
		this.location = String.format("%s - %s", longitude, latitude);
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
		this.location = String.format("%s - %s", longitude, latitude);
	}
	
	@Override
	public RSession getExchangeModel() {
		RSession rtn = new RSession();
//		rtn.setRUser(this.user.getExchangeModel());
		rtn.setName(this.name);
		rtn.setDateStart(new Timestamp(this.start.getTime()));
		rtn.setDateEnd(new Timestamp(this.end.getTime()));
		rtn.setLatitude(this.latitude);
		rtn.setLongitude(this.longitude);
		rtn.setRObservations(getRObservations());
		rtn.setName(this.name);
		rtn.setName(this.name);
		return rtn;
	}
	
	public List<RObservation> getRObservations() {
		List<RObservation> rtn = new ArrayList<>();
		for(Observation obs : observations)
			rtn.add(obs.getExchangeModel());
		
		return rtn;
	}
}
