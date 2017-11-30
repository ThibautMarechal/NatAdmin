package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Session extends IdentifiedModel {
	private User user;
	private String name;
	private Timestamp dateStart;
	private Timestamp dateEnd;
	private String latitude;
	private String longitude;
	private List<Observation> observations;
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
//		this.location = String.format("%s - %s", longitude, latitude);
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
//		this.location = String.format("%s - %s", longitude, latitude);
	}
}
