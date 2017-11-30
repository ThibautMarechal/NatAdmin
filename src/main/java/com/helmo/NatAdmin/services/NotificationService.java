package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.models.Observation;
import com.helmo.NatAdmin.services.crudServices.IReadService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationService implements IReadService<Notification> {
    public List<Notification> getAll() {
        //TODO REST CALL
        List<Notification> notifs = new ArrayList<Notification>();
        for (int i =1; i <= 10; ++i){
            notifs.add(getById(i));
        }
        return notifs;
    }

    @Override
    public Notification getById(long id) {
        //TODO REST CALL
        Notification n = new Notification();
        n.setCaption("Caption #" + id);
        n.setDescription("Description #"+ id);
        n.setDate(Date.from(Instant.now()));
        n.setStatus(false);
        Observation o = new Observation();
//        o.setDateTime(Date.from(Instant.now()));
        o.setDateTime(new Timestamp(new Date().getTime()));
        o.setBird(new BirdService().getById(42));
        o.setOnlinePath("mon super chemin");
        n.setObservation(o);
        return n;
    }

    public void acceptNotification(long id){
        //TODO REST CALL
    }

    public void refuseNotification(long id){
        //TODO REST CALL
    }
}
