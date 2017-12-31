package com.helmo.NatAdmin.reception;

import lombok.Getter;
import lombok.Setter;

public abstract class MongoIdentifiedModel {
	
	@Getter
	@Setter
	private long id;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MongoIdentifiedModel)) return false;
		MongoIdentifiedModel that = (MongoIdentifiedModel) o;
		
		return id == that.id;
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}
}
