package org.han.foodstore.dao;

import org.han.vo.StoreVO;

public interface GenericDAO<E, R> {
	
	public void create (E vo)throws Exception;
	
	public E read(R sno)throws Exception;

	public void update(E vo)throws Exception;

	public void delete(R sno)throws Exception;
	

}
