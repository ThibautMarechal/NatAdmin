package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Notification;
import com.helmo.NatAdmin.services.crudServices.IReadService;

import java.util.List;

public class NotificationService implements IReadService<Notification> {
    public List<Notification> getAll() {
        return null;
    }

    @Override
    public Notification getById(long id) {
        // pertinant ?
        return null;
    }
}
