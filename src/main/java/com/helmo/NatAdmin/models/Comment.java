package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment extends IdentifiedModel {
	
	private String commentary;
	
	private Date date;
	
	private User user;
	
	private Observation observation;
}
