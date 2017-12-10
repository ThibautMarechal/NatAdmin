package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Description;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.util.ArrayList;
import java.util.List;

public class AttributeService implements ICrudService<Description>
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
        List<Description> attributes = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            attributes.add(getById(i));
        }
        return attributes;
    }

    @Override
    public Description getById(long id)
    {
        Description description = new Description();
        description.setKey("colors #"+id);
        List<String> colors = new ArrayList<>();
        colors.add("blue #"+id);
        colors.add("red #"+id);
        colors.add("green #"+id);
        colors.add("yellow #"+id);
        colors.add("orange #"+id);
        colors.add("purple #"+id);
        colors.add("white #"+id);
        colors.add("black #"+id);
        description.setValues(colors);
        return description;
    }

    @Override
    public void update(Description toUpdate)
    {
        //TODO
    }
}
