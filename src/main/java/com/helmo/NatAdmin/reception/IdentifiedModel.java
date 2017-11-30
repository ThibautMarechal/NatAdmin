package com.helmo.NatAdmin.reception;

import lombok.Getter;

public abstract class IdentifiedModel {
	
	@Getter
	private long id;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof IdentifiedModel)) return false;
		IdentifiedModel that = (IdentifiedModel) o;
		
		return id == that.id;
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}
}
