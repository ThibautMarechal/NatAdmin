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
	private final Class<RAttribute> CLASS = RAttribute.class;
	private final Class<RAttribute[]> CLASS_TAB = RAttribute[].class;
	
	private final CallREST caller;
	
	public AttributeService(@Qualifier("callREST") CallREST caller) {
		this.caller = caller;
	}
	
	@Override
	public long create(Attribute toCreate) {
		return caller.create(CLASS_TAB, CONTROLLER_NAME, new RAttribute[]{new RAttribute(toCreate)})[0].getId();
	}
	
	@Override
	public void delete(Attribute toDelete) {
		caller.delete(CLASS_TAB, CONTROLLER_NAME, new RAttribute[]{new RAttribute(toDelete)});
	}
	
	@Override
	public void delete(long idToDelete) {
		caller.deleteById(CLASS, CONTROLLER_NAME, idToDelete);
	}
	
	@Override
	public List<Attribute> getAll() {
		List<Attribute> rtn = new ArrayList<>();
		caller.getAll(CLASS_TAB, CONTROLLER_NAME).forEach(
			  a -> rtn.add(a.getModel())
		);
		return rtn;
	}
	
	@Override
	public Attribute getById(long id) {
		return caller.getById(CLASS, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public List<Attribute> getRange(long one, long two) {
		List<Attribute> rtn = new ArrayList<>();
		caller.getRange(CLASS_TAB, CONTROLLER_NAME, one, two)
			  .forEach(
					u -> rtn.add(u.getModel())
			  );
		return rtn;
	}
	
	@Override
	public void update(Attribute toUpdate) {
		caller.update(CLASS_TAB, CONTROLLER_NAME, new RAttribute[]{new RAttribute(toUpdate)});
	}
}
