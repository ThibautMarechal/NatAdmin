package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserService implements ICrudService<User> {
	public UserService() {
	}
	
	@Override
	public List<User> getAll() {
		//TODO REST CALL
		List<User> users = new ArrayList<User>();
		for (int i = 1; i <= 10; ++i) {
			users.add(getById(i));
		}
		final String uri = "http://192.168.128.13:8081/GRIMAR%2D1.0/users";
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		System.out.print(result);
		
		return users;
	}
	
	@Override
	public User getById(long id) {
		//TODO REST CALL
		User u = new User();
		u.setFullName("fullname #" + id);
		u.setEmail("email #" + id);
		u.setId(id);
		return u;
	}
	
	@Override
	public void update(User toUpdate) {
		//TODO REST CALL
	}
	
	@Override
	public void create(User toUpdate) {
		//TODO REST CALL
	}
	
	@Override
	public void delete(User toUpdate) {
		//TODO REST CALL
	}
	
	@Override
	public void delete(long idToDelete) {
		//TODO REST CALL
	}
}
