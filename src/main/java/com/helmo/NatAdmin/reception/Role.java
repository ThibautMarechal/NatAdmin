package com.helmo.NatAdmin.reception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Role extends IdentifiedModel{
	
	private String name;
	
	private String description;
	
	public Role() {}
	
	public Role(String name, String desc) {
		this.name = name;
		this.description = desc;
	}
}
