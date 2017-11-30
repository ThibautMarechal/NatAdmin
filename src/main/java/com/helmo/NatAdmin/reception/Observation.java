package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.sql.Timestamp;

@Getter @Setter
public class Observation extends IdentifiedModel {
	
	private String latitude;
	
	private String longitude;
	
	private Timestamp dateTime;
	
	private int nbrObs;
	
	private boolean validation;
	
	private String onlinePath;
	
	private String analyseResult;
	
	private long birdId;
	
	private MediaType mediaType;
	
	@JsonIgnore
	private Session session;
	
	private Path localPath;
	
	private Bird bird;
	
	public Observation() {}
}
