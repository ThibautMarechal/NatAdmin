package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Attribute;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.util.ArrayList;
import java.util.List;

public class AttributeService implements ICrudService<Attribute>
{
    @Override
    public long create(Attribute toCreate)
    {
        //TODO
        return 1;
    }

    @Override
    public void delete(Attribute toDelete)
    {
        //TODO
    }

    @Override
    public void delete(long idToDelete)
    {
        //TODO
    }

    @Override
    public List<Attribute> getAll()
    {
        List<Attribute> attributes = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            attributes.add(getById(i));
        }
        return attributes;
    }

    @Override
    public Attribute getById(long id)
    {
        Attribute description = new Attribute();
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
        description.setValue(colors);
        return description;
    }

    @Override
    public void update(Attribute toUpdate)
    {
        //TODO
    }
}
