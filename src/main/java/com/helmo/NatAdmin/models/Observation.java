package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Observation extends IdentifiedModel {
	private Timestamp dateTime;
	private String latitude;
	private String longitude;
	private int nbrObs;
	private boolean validation;
	private Bird bird;
	private MediaType mediaType;
	private String onlinePath;
	
}
