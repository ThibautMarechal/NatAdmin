package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.User;

public interface IUpdateService<T> {
    void update(T toUpdate, User cred);
}
