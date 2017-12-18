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
	private Map<String, List<Object>> data;
	
	public RBird() {
	}
	
	public RBird(Bird bird) {
		this.setId(bird.getId());
		this.name = bird.getName();
		this.description = bird.getDescription();
	}
	
	public List<Object> get(String key) {
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
		return rtn;
	}
}
