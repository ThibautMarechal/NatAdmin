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
	private List<Object> values;
	
	public RAttribute() {
	}
	
	public RAttribute(Attribute attribute) {
		this.setId(attribute.getId());
		this.name = attribute.getName();
		this.values = attribute.getValues();
	}
	
	@Override
	public Attribute getModel() {
		Attribute rtn = new Attribute();
		rtn.setId(this.getId());
		rtn.setName(this.name);
		rtn.setValues(this.values);
		return rtn;
	}
}
