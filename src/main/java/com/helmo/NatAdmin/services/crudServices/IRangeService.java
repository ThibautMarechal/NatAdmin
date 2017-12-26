package com.helmo.NatAdmin.services.crudServices;

import java.util.List;

public interface IRangeService<T> {

	List<T> getRange(long one, long two);
}
