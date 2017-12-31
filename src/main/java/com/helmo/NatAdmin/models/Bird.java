package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Bird extends IdentifiedModel {
	private String name;
	private String description;
	private Map<String, List<String>> attributes;
	private List<String> pictures = new ArrayList<>();
	private List<String> publicLinks = new ArrayList<>();
	
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
	
	public List<String> getPublicLinks() {
		return publicLinks;
	}
	
	public void setPublicLinks(List<String> publicLinks) {
		this.publicLinks = publicLinks;
	}

	public void addPictures(String s)
	{
		if(this.pictures == null){
			this.pictures = new ArrayList<>();
		}
		this.pictures.add(s);
	}

	public void addPublicLinks(String s)
	{
		if(this.publicLinks == null){
			this.publicLinks = new ArrayList<>();
		}
		this.publicLinks.add(s);
	}

	public int picturesSize()
	{
		return pictures == null ? 0 : pictures.size();
	}
}
