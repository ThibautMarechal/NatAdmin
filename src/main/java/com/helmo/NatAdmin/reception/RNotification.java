package com.helmo.NatAdmin.reception;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class RNotification extends IdentifiedModel {

	private String caption;
	
	private String description;
	
	private Timestamp date;
	
	private boolean status;
	
	private RObservation RObservation;
	
	public RNotification() {}
}
