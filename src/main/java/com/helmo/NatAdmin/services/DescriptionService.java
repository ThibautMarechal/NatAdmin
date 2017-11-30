package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Description;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.util.List;

public class DescriptionService implements ICrudService<Description>
{
    @Override
    public long create(Description toCreate)
    {
        //TODO
        return 1;
    }

    @Override
    public void delete(Description toDelete)
    {
        //TODO
    }

    @Override
    public void delete(long idToDelete)
    {
        //TODO
    }

    @Override
    public List<Description> getAll()
    {
        //TODO
        return null;
    }

    @Override
    public Description getById(long id)
    {
        //TODO
        return null;
    }

    @Override
    public void update(Description toUpdate)
    {
        //TODO
    }
}
