package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Attribute;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.crudServices.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService implements ICrudService<Attribute> {
	@Override
	public long create(Attribute toCreate, User cred) {
		//TODO
		return 1;
	}
	
	@Override
	public void delete(Attribute toDelete, User cred) {
		//TODO
	}
	
	@Override
	public void delete(long idToDelete, User cred) {
		//TODO
	}
	
	@Override
	public List<Attribute> getAll(User cred) {
//        List<Description> attributes = new ArrayList<>();
//        for (int i = 0; i < 10; i++)
//        {
//            attributes.add(getById(i));
//        }
//        return attributes;
		return null;
	}
	
	@Override
	public Attribute getById(long id, User cred) {
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
	public void update(Attribute toUpdate, User cred) {
		//TODO
	}
}
