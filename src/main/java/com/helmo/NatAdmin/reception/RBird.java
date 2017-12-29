package com.helmo.NatAdmin.reception;

import com.helmo.NatAdmin.models.Bird;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RBird extends MongoIdentifiedModel
	  implements ReceptionObject<Bird> {
	
	private String name;
	private String description;
	
	private List<String> picture;
	private List<String> publicLinks;
	private Map<String, List<String>> data;
	
	public RBird() {
	}
	
	public RBird(Bird bird) {
		this.setId(bird.getId());
		this.name = bird.getName();
		this.description = bird.getDescription();
		this.picture = bird.getPictures();
		this.publicLinks = bird.getPublicLink();
		this.data = bird.getAttributes();
	}
	
	public List<String> get(String key) {
		return data.get(key);
	}
	
	@Override
	public String toString() {
		return String.format(
			  "BIRD [id=%s, name=%s ]\n\t[Picture : %d]\n\t[Data : %d]",
			  getId(), name, picture.size(), data.size()
		);
	}
	
	@Override
	public Bird getModel() {
		Bird rtn = new Bird();
		rtn.setId(this.getId());
		rtn.setName(this.name);
		rtn.setDescription(this.description);
		rtn.setPublicLink(this.publicLinks);
		rtn.setPictures(this.picture);
		rtn.setAttributes(this.data);
		return rtn;
	}
}
