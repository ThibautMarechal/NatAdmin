package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.IdentifiedModel;
import com.helmo.NatAdmin.models.User;

public interface IDeleteService<T extends IdentifiedModel> {
    void delete(T toDelete, User cred);
    void delete(long idToDelete, User cred);
}
