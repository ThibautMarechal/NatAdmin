package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.IdentifiedModel;

public interface IDeleteService<T extends IdentifiedModel> {
    void delete(T toDelete);
    void delete(long idToDelete);
}
