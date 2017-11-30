package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SessionService implements ICrudService<Session> {
	
	private final RestTemplate restTemplate;
	private final Environment env;
	
	
	public SessionService(RestTemplate template, Environment env) {
		restTemplate = template;
		this.env = env;
	}
	
	@Override
	public long create(Session toCreate) {
		//TODO
		return 1;
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
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		return Arrays.asList(restTemplate.exchange(
			  env.getProperty("rest.url") + "/sessions",
			  HttpMethod.GET, null, Session[].class
		).getBody());
	}
	
	@Override
	public Session getById(long id) {
//		Session s = new Session();
////		s.setId(id);
//		s.setDateEnd(new Timestamp(new Date().getTime()));
//		s.setDateStart(new Timestamp(new Date().getTime()));
//		s.setLatitude("Latitude #" + id);
//		s.setLongitude("Longitude #" + id);
//		s.setName("Name #" + id);
////        s.setRUser();
//		List<Observation> obs = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			MediaType mt = new MediaType();
//			mt.setName("Type #" + i);
//			Observation o = new Observation();
////			o.setId(i);
//			o.setOnlinePath("Path #" + i);
//			o.setBird(new BirdService().getById(i));
//			o.setDateTime(new Timestamp(new Date().getTime()));
//			o.setLatitude("Latitude #" + i);
//			o.setLongitude("Longitude #" + i);
//			o.setMediaType(mt);
//			o.setValidation(true);
//			obs.add(o);
//		}
//		s.setObservations(obs);
//		return s;
		restTemplate.getInterceptors().add(
			  new BasicAuthorizationInterceptor("admin@nat.be", "adminadmin")
		);
		return restTemplate.exchange(
			  env.getProperty("rest.url") + "/sessions/" + id,
			  HttpMethod.GET, null, Session.class
		).getBody();
	}
	
	@Override
	public void update(Session toUpdate) {
	
	}
}
