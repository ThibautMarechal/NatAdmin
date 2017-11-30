package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter @Setter
@JsonIgnoreProperties("user")
public class Session extends IdentifiedModel{
	
	private String name;
	
	private Timestamp dateStart;
	private Timestamp dateEnd;
	
	
	private String latitude;
	private String longitude;
	
	private List<Observation> observations;

	private User user;
	
	public Session() {}
	
}
