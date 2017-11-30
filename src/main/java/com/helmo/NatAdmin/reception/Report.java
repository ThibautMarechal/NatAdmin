package com.helmo.NatAdmin.reception;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class Report extends IdentifiedModel {

	private String commentary;
	
	private Timestamp date;
	
	private RUser RUser;
	
	private RObservation RObservation;
	
	public Report() {}
}
