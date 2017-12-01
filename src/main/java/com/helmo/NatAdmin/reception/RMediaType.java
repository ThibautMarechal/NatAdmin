package com.helmo.NatAdmin.reception;

import com.helmo.NatAdmin.models.MediaType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RMediaType extends IdentifiedModel
		implements ReceptionObject<MediaType> {
	
	private String name;
	
	public RMediaType() {
	}
	
	@Override
	public MediaType getModel() {
		MediaType rtn = new MediaType();
		rtn.setId(this.getId());
		rtn.setName(this.name);
		return rtn;
	}
}
