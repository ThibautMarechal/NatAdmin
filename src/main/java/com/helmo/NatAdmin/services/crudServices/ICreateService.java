package com.helmo.NatAdmin.services.crudServices;

import com.helmo.NatAdmin.models.User;

public interface ICreateService<T> {
	long create(T toCreate, User cred);
}
