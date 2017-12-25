package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.ObservationCaller;
import com.helmo.NatAdmin.models.Observation;
import com.helmo.NatAdmin.reception.RObservation;
import com.helmo.NatAdmin.services.crudServices.IDeleteService;
import com.helmo.NatAdmin.services.crudServices.IReadService;
import com.helmo.NatAdmin.services.crudServices.IUpdateService;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationService
	  implements IUpdateService<Observation>, IReadService<Observation>, IDeleteService<Observation> {
	
	private final String CONTROLLER_NAME = "observations";
	
	private final ObservationCaller caller;
	
	
	public ObservationService(ObservationCaller caller) {
		this.caller = caller;
	}
	
	@Override
	public List<Observation> getAll() {
		List<Observation> rtn = new ArrayList<>();
		for (RObservation obs : caller.getAll(RObservation[].class, CONTROLLER_NAME))
			rtn.add(obs.getModel());
		return rtn;
	}
	
	@Override
	public Observation getById(long id) {
		return caller.getById(RObservation.class, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public void update(Observation toUpdate) {
		caller.update(
			  RObservation[].class, CONTROLLER_NAME,
			  new RObservation[]{new RObservation(toUpdate)});
	}
	
	@Override
	public void delete(Observation toDelete) {
		throw new NotImplementedException();
	}
	
	@Override
	public void delete(long idToDelete) {
		caller.deleteById(
			  RObservation.class, CONTROLLER_NAME, idToDelete);
	}
	
	public void validate(long id) {
		caller.validate(id);
	}
	
	public void refused(long id) {
		caller.refused(id);
	}
	
}
