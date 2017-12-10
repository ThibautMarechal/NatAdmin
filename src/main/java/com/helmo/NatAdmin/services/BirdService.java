package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class BirdService implements ICrudService<Bird> {
    @Override
    public long create(Bird toCreate) {
        //TODO REST CALL
        return 1;
    }

    @Override
    public void delete(Bird toDelete) {
        //TODO REST CALL
    }

    @Override
    public void delete(long idToDelete) {
        //TODO REST CALL
    }

    @Override
    public List<Bird> getAll() {
        //TODO REST CALL
        List<Bird> birds = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            birds.add(getById(i));
        }
        return birds;
    }

    @Override
    public Bird getById(long id) {
        Bird b = new Bird();
        b.setId(id);
        b.setName("Bird #"+id);
        b.setDescription("Bird Description #"+id);
        Map<String, List<String>> attributes = new Hashtable<>();
        List<String> colors = new ArrayList<>();
        colors.add("blue #"+id);
        colors.add("red #"+id);
        colors.add("orange #"+id);
        colors.add("yellow #"+id);
        attributes.put("colors #"+id, colors);
        ++id;
        List<String> colors2 = new ArrayList<>();
        colors2.add("blue #"+id);
        colors2.add("red #"+id);
        colors2.add("orange #"+id);
        colors2.add("yellow #"+id);
        attributes.put("colors #"+id, colors2);
        b.setAttributes(attributes);
        return b;
    }

    @Override
    public void update(Bird toUpdate) {
        //TODO REST CALL
    }
}
