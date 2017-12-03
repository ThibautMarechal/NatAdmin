package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.helmo.NatAdmin.models.Observation;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.sql.Timestamp;

@Getter
@Setter
public class RObservation extends IdentifiedModel
		implements ReceptionObject<Observation> {
	
	private String latitude;
	
	private String longitude;
	
	private Timestamp dateTime;
	
	private int nbrObs;
	
	private boolean validation;
	
	private String onlinePath;
	
	private String analyseResult;
	
	private long birdId;
	
	@JsonProperty("mediaType")
	private RMediaType rMediaType;
	
	@JsonIgnore
	private RSession rSession;
	
	private Path localPath;
	
	@JsonProperty("bird")
	private RBird rBird;
	
	public RObservation() {
	}
	
	@Override
	public Observation getModel() {
		Observation rtn = new Observation();
		rtn.setLatitude(this.latitude);
		rtn.setLongitude(this.longitude);
		rtn.setDate(this.dateTime);
		rtn.setNumberOfBird(this.nbrObs);
		rtn.setValid(this.validation);
		rtn.setMediaPath(this.onlinePath);
		rtn.setBird(rBird.getModel());
		rtn.setMediaType(this.rMediaType.getName());
		return rtn;
	}
}
