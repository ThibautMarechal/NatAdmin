package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.IdentifiedModel;

import java.util.List;

public interface IReadService<T extends IdentifiedModel> {
    List<T> getAll();
    T getById(long id);
}
