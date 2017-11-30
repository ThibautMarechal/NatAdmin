package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.MediaType;
import com.helmo.NatAdmin.models.Observation;
import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionService implements ICrudService<Session> {
	@Override
	public void create(Session toCreate) {
		//TODO
	}
	
	@Override
	public void delete(Session toDelete) {
		//TODO
	}
	
	@Override
	public void delete(long idToDelete) {
		//TODO
	}
	
	@Override
	public List<Session> getAll() {
		List<Session> sessions = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			sessions.add(getById(i));
		}
		return sessions;
	}
	
	@Override
	public Session getById(long id) {
		Session s = new Session();
//		s.setId(id);
		s.setDateEnd(new Timestamp(new Date().getTime()));
		s.setDateStart(new Timestamp(new Date().getTime()));
		s.setLatitude("Latitude #" + id);
		s.setLongitude("Longitude #" + id);
		s.setName("Name #" + id);
//        s.setUser();
		List<Observation> obs = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			MediaType mt = new MediaType();
			mt.setName("Type #" + i);
			Observation o = new Observation();
//			o.setId(i);
			o.setOnlinePath("Path #" + i);
			o.setBird(new BirdService().getById(i));
			o.setDateTime(new Timestamp(new Date().getTime()));
			o.setLatitude("Latitude #" + i);
			o.setLongitude("Longitude #" + i);
			o.setMediaType(mt);
			o.setValidation(true);
			obs.add(o);
		}
		s.setObservations(obs);
		return s;
	}
	
	@Override
	public void update(Session toUpdate) {
	
	}
}
