package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Description;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.util.ArrayList;
import java.util.List;

public class AttributeService implements ICrudService<Description> {
	@Override
	public long create(Description toCreate, User cred) {
		//TODO
		return 1;
	}
	
	@Override
	public void delete(Description toDelete, User cred) {
		//TODO
	}
	
	@Override
	public void delete(long idToDelete, User cred) {
		//TODO
	}
	
	@Override
	public List<Description> getAll(User cred) {
//        List<Description> attributes = new ArrayList<>();
//        for (int i = 0; i < 10; i++)
//        {
//            attributes.add(getById(i));
//        }
//        return attributes;
		return null;
	}
	
	@Override
	public Description getById(long id, User cred) {
//        Description description = new Description();
//        description.setKey("colors #"+id);
//        List<String> colors = new ArrayList<>();
//        colors.add("blue #"+id);
//        colors.add("red #"+id);
//        colors.add("green #"+id);
//        colors.add("yellow #"+id);
//        colors.add("orange #"+id);
//        colors.add("purple #"+id);
//        colors.add("white #"+id);
//        colors.add("black #"+id);
//        description.setValues(colors);
//        return description;
		
		return null;
	}
	
	@Override
	public void update(Description toUpdate, User cred) {
		//TODO
	}
}
