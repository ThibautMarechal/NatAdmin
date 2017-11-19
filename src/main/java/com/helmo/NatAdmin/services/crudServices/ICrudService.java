package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.Identifiable;

public interface ICrudService<T extends Identifiable> extends ICreateService<T>, IReadService<T>, IUpdateService<T>, IDeleteService<T>
{

}
