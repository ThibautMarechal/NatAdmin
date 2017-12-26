package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.caller.ObservationCaller;
import com.helmo.NatAdmin.models.Observation;
import com.helmo.NatAdmin.reception.RObservation;
import com.helmo.NatAdmin.services.crudServices.IDeleteService;
import com.helmo.NatAdmin.services.crudServices.IRangeService;
import com.helmo.NatAdmin.services.crudServices.IReadService;
import com.helmo.NatAdmin.services.crudServices.IUpdateService;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationService
	  implements IUpdateService<Observation>, IReadService<Observation>,
	  IDeleteService<Observation>, IRangeService<Observation> {
	
	private final String CONTROLLER_NAME = "observations";
	private final Class<RObservation> CLASS = RObservation.class;
	private final Class<RObservation[]> CLASS_TAB = RObservation[].class;
	
	private final ObservationCaller caller;
	
	
	public ObservationService(ObservationCaller caller) {
		this.caller = caller;
	}
	
	@Override
	public List<Observation> getAll() {
		List<Observation> rtn = new ArrayList<>();
		for (RObservation obs : caller.getAll(CLASS_TAB, CONTROLLER_NAME))
			rtn.add(obs.getModel());
		return rtn;
	}
	
	@Override
	public Observation getById(long id) {
		return caller.getById(CLASS, CONTROLLER_NAME, id).getModel();
	}
	
	@Override
	public List<Observation> getRange(long one, long two) {
		List<Observation> rtn = new ArrayList<>();
		caller.getRange(CLASS_TAB, CONTROLLER_NAME, one, two)
			  .forEach(
					u -> rtn.add(u.getModel())
			  );
		return rtn;
	}
	
	@Override
	public void update(Observation toUpdate) {
		caller.update(
			  CLASS_TAB, CONTROLLER_NAME,
			  new RObservation[]{new RObservation(toUpdate)});
	}
	
	@Override
	public void delete(Observation toDelete) {
		throw new NotImplementedException();
	}
	
	@Override
	public void delete(long idToDelete) {
		caller.deleteById(
			  CLASS, CONTROLLER_NAME, idToDelete);
	}
	
	public void validate(long id) {
		caller.validate(id);
	}
	
	public void refused(long id) {
		caller.refused(id);
	}
	
}
