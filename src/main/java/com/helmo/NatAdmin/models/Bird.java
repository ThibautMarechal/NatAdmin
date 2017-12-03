package com.helmo.NatAdmin.models;

import com.helmo.NatAdmin.reception.RBird;

public class Bird extends IdentifiedModel
	  implements ExchangeObject<RBird> {
	private String name;
	private int averageHeigth;
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getAverageHeigth() {
		return averageHeigth;
	}
	
	public void setAverageHeigth(int averageHeigth) {
		this.averageHeigth = averageHeigth;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public RBird getExchangeModel() {
		RBird rtn = new RBird();
		rtn.setName(this.name);
		rtn.setDescription(this.description);
		
		return rtn;
	}
}
