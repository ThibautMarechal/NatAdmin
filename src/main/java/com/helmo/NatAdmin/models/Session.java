package com.helmo.NatAdmin.models;

import com.helmo.NatAdmin.reception.RObservation;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Session extends IdentifiedModel {
	private User user;
	private String name;
	private Date start;
	private Date end;
	private String latitude;
	private String longitude;
	private List<Observation> observations;
	private String location;
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
		this.location = String.format("%s - %s", longitude, latitude);
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
		this.location = String.format("%s - %s", longitude, latitude);
	}
}
