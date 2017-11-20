package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.services.crudServices.IReadService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationService implements IReadService<Notification> {
    public List<Notification> getAll() {
        List<Notification> notifs = new ArrayList<Notification>();
        for (int i =1; i <= 10; ++i){
            notifs.add(getById(i));
        }
        return notifs;
    }

    @Override
    public Notification getById(long id) {
        Notification n = new Notification();
        n.setId(id);
        n.setCaption("Caption #" + id);
        n.setDescription("Description #"+ id);
        n.setDate(Date.from(Instant.now()));
        n.setStatus(false);
        return n;
    }
}
