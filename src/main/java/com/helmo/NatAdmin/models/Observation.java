package com.helmo.NatAdmin.models;

import com.helmo.NatAdmin.reception.RMediaType;
import com.helmo.NatAdmin.reception.RObservation;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class Observation extends IdentifiedModel
	  implements ExchangeObject<RObservation> {
	private Date date;
	private String latitude;
	private String longitude;
	private int numberOfBird;
	private boolean isValid;
	private Bird bird;
	private String mediaType;
	private String mediaPath;
	
	@Override
	public RObservation getExchangeModel() {
		RObservation rtn = new RObservation();
		rtn.setDateTime(new Timestamp(this.date.getTime()));
		rtn.setLatitude(this.latitude);
		rtn.setLongitude(this.longitude);
		rtn.setNbrObs(this.numberOfBird);
		rtn.setValidation(this.isValid);
		rtn.setRBird(this.bird.getExchangeModel());
		rtn.setOnlinePath(this.mediaPath);
		RMediaType rmt = new RMediaType();
		rmt.setName(this.mediaType);
		rtn.setRMediaType(rmt);
		
		return rtn;
	}
}
