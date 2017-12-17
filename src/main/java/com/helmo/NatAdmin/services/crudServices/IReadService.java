package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.IdentifiedModel;
import com.helmo.NatAdmin.models.User;

import java.util.List;

public interface IReadService<T extends IdentifiedModel> {
    List<T> getAll(User cred);
    T getById(long id, User cred);
}
