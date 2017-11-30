package com.helmo.NatAdmin.services.crudServices;

public interface ICreateService<T> {
    long create(T toCreate);
}
