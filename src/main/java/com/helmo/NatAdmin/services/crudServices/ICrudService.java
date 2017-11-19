package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Identifiable;

import java.util.List;

public interface ICrudService<T extends Identifiable> extends ICreateService<T>, IReadService<T>, IUpdateService<T>, IDeleteService<T>
{

}
