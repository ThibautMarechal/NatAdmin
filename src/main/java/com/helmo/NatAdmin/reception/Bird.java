package com.helmo.NatAdmin.reception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Bird extends MongoIdentifiedModel {
	
	public static final String NAME = "name"; //Used with Datastore
	public static final String DESCRIPTION = "description";
	public static final String DATA = "data";
	public static final String PICTURE = "picture";
	public static final String MULTIPLE = "multiple";
	
	private String name;
	private String description;
	
	private List<String> picture;
	private Map<String, String> data;
	private Map<String, List<String>> multiple;
	
	public Bird() {
	}
	
	@Override
	public String toString() {
		return String.format(
			  "BIRD [id=%s, name=%s ]\n\t[Data : %d]\n\t[Picture : %d]\n\t[Multiple : %d]",
			  getId(), name, data.size(), picture.size(), multiple.size()
		);
	}
}
