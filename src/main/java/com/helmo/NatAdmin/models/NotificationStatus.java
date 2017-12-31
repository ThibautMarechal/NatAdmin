package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationStatus {
	
	private String name;
	
	public NotificationStatus() {
	}
	
	public NotificationStatus(String name) {
		this.name = name;
	}
}
