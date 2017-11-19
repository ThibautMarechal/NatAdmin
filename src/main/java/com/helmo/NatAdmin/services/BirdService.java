package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.util.ArrayList;
import java.util.List;

public class BirdService implements ICrudService<Bird> {
    @Override
    public void create(Bird toCreate) {
        //TODO
    }

    @Override
    public void delete(Bird toDelete) {
        //TODO
    }

    @Override
    public void delete(long idToDelete) {
        //TODO
    }

    @Override
    public List<Bird> getAll() {
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
        b.setAverageHeigth((int) id);
        return b;
    }

    @Override
    public void update(Bird toUpdate) {
        //TODO
    }
}
