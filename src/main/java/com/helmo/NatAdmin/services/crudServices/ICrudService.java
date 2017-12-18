package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.IdentifiedModel;

public interface ICrudService<T extends IdentifiedModel> extends ICreateService<T>, IReadService<T>, IUpdateService<T>, IDeleteService<T>
{}
