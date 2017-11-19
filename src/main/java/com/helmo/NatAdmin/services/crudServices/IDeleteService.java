package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.Identifiable;

public interface IDeleteService<T extends Identifiable> {
    void delete(T toDelete);
    void delete(long idToDelete);
}
