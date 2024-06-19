package org.academia_caju_fitness.service;

import java.util.List;

public interface BaseInterface<T, ID> {
	
	List<T> findAll();
	
	T findById(ID id);
	
	T create(T entity);
	
	void delete(ID id);
	
	T update(ID id, T entity);
	
}
