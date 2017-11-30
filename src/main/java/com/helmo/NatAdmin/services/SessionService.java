package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Observation;
import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionService implements ICrudService<Session>
{
    @Override
    public long create(Session toCreate)
    {
        //TODO
        return 1;
    }

    @Override
    public void delete(Session toDelete)
    {
        //TODO
    }

    @Override
    public void delete(long idToDelete)
    {
        //TODO
    }

    @Override
    public List<Session> getAll()
    {
        List<Session> sessions = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            sessions.add(getById(i));
        }
        return sessions;
    }

    @Override
    public Session getById(long id)
    {
        Session s = new Session();
        s.setId(id);
        s.setEnd(Date.from(Instant.now()));
        s.setStart(Date.from(Instant.now()));
        s.setLatitude("Latitude #" +id);
        s.setLongitude("Longitude #" +id);
        s.setName("Name #" + id);
        s.setUser(new UserService().getById(id));
        List<Observation> obs = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            Observation o = new Observation();
            o.setId(i);
            o.setMediaPath("Path #" + i);
            o.setBird(new BirdService().getById(i));
            o.setDate(Date.from(Instant.now()));
            o.setLatitude("Latitude #"+i);
            o.setLongitude("Longitude #"+i);
            o.setMediaType("Type #"+i);
            o.setValid(true);
            obs.add(o);
        }
        s.setObservations(obs);
        return s;
    }

    @Override
    public void update(Session toUpdate)
    {

    }
}
