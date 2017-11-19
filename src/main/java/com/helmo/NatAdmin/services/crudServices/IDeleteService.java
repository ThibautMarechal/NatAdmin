package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Identifiable;

public interface IDeleteService<T extends Identifiable> {
    void delete(T toDelete);
    void delete(long idToDelete);
}
