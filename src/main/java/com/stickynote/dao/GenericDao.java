package com.stickynote.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> {
	public List<T> getAll();
	
	public T getByid(ID id);
	
	public void insert(T objetc);
	
	public void update(T objetc);
	
	public void delete(ID id);
}
