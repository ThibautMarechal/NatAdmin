package com.helmo.NatAdmin.reception;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdentifiedModel {
	
	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
