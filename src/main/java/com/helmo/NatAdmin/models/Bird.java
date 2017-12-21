package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Bird extends IdentifiedModel {
	private String name;
	private String description;
	private Map<String, List<String>> attributes;
	private List<String> pictures;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Map<String, List<String>> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Map<String, List<String>> attributes) {
		this.attributes = attributes;
	}
	
	public List<String> getPictures() {
		return pictures;
	}
	
	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}
}
