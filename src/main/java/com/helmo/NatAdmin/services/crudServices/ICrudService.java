package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.IdentifiedModel;
import com.helmo.NatAdmin.models.User;

public interface ICrudService<T extends IdentifiedModel> extends ICreateService<T>, IReadService<T>, IUpdateService<T>, IDeleteService<T> {
}
