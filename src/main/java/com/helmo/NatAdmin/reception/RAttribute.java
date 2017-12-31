package com.helmo.NatAdmin.reception;

import com.helmo.NatAdmin.models.Attribute;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RAttribute extends MongoIdentifiedModel
	  implements ReceptionObject<Attribute> {
	
	private String name;
	private List<String> values;
	
	public RAttribute() {
	}
	
	public RAttribute(Attribute attribute) {
		this.setId(attribute.getId());
		this.name = attribute.getKey();
		this.values = attribute.getValues();
	}
	
	@Override
	public Attribute getModel() {
		Attribute rtn = new Attribute();
		rtn.setId(this.getId());
		rtn.setKey(this.name);
		rtn.setValues(this.values);
		return rtn;
	}
}
