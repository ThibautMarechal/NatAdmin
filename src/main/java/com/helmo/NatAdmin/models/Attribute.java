package com.helmo.NatAdmin.models;

import com.helmo.NatAdmin.reception.MongoIdentifiedModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Attribute extends MongoIdentifiedModel {
	
	private String name;
	private List<Object> values;
}
