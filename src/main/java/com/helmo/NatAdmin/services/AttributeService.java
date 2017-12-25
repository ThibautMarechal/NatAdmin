package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.CallREST;
import com.helmo.NatAdmin.models.Attribute;
import com.helmo.NatAdmin.reception.RAttribute;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeService implements ICrudService<Attribute> {
	
	private final String CONTROLLER_NAME = "attributes";
	
	private final CallREST caller;
	
	public AttributeService(@Qualifier("callREST") CallREST caller) {
		this.caller = caller;
	}
	
	@Override
	public long create(Attribute toCreate) {
		return caller.create(RAttribute[].class, CONTROLLER_NAME, new RAttribute[]{new RAttribute(toCreate)})[0].getId();
	}
	
	@Override
	public void delete(Attribute toDelete) {
		caller.delete(RAttribute[].class, CONTROLLER_NAME, new RAttribute[]{new RAttribute(toDelete)});
	}
	
	@Override
	public void delete(long idToDelete) {
		caller.deleteById(RAttribute.class, CONTROLLER_NAME, idToDelete);
	}
	
	@Override
	public List<Attribute> getAll() {
		List<RAttribute> rAttributes = caller.getAll(RAttribute[].class, CONTROLLER_NAME);
		
		List<Attribute> rtn = new ArrayList<>();
		rAttributes.forEach(
			  a -> rtn.add(a.getModel())
		);
		return rtn;
	}
	
	@Override
	public Attribute getById(long id) {
		return caller.getById(RAttribute.class, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public void update(Attribute toUpdate) {
		caller.update(RAttribute[].class, CONTROLLER_NAME, new RAttribute[]{new RAttribute(toUpdate)});
	}
}
