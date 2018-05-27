package com.litara.test.service;

import com.litara.test.entities.Entity;

public abstract class AbstractService<T extends Entity> {
	public abstract void create(T entity);
	public abstract T findById(int id);
	public abstract void update(T entity);
	public abstract void delete(T entity);
}
