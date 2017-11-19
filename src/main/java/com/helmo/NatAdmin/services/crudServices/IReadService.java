package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.Identifiable;

import java.util.List;

public interface IReadService<T extends Identifiable> {
    List<T> getAll();
    T getById(long id);
}
