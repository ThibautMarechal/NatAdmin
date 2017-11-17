package com.helmo.NatAdmin.services;

import java.util.List;

public interface AbstractService<T>
{
    List<T> getAll();
    T getById(long id);
    void update(T toUpdate);
    void create(T toUpdate);
    void delete(T toUpdate);
}
