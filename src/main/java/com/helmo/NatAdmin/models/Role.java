package com.helmo.NatAdmin.models;

import com.helmo.NatAdmin.reception.RRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role extends IdentifiedModel
	  implements ExchangeObject<RRole> {
	private String name;
	
	private String description;
	
	public Role() {}
	
	public Role(String name, String desc) {
		this.name = name;
		this.description = desc;
	}
	
	@Override
	public RRole getExchangeModel() {
		RRole rtn = new RRole();
		rtn.setId(this.getId());
		rtn.setName(this.name);
		rtn.setDescription(this.description);
		return rtn;
	}
}
