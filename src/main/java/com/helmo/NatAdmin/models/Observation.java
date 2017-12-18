package com.helmo.NatAdmin.models;


import java.util.Date;

@Getter
@Setter
public class Observation extends IdentifiedModel {
	private Date date;
	private String latitude;
	private String longitude;
	private int numberOfBird;
	private boolean isValid;
	private Bird bird;
	private String mediaType;
	private String mediaPath;
	
}
