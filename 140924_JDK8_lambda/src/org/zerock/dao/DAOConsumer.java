package org.zerock.dao;

import java.sql.ResultSet;

/**
 * handle ResultSet
 * 
 * @author Zerock
 *
 * @param <T> return type 
 */
@FunctionalInterface
public interface DAOConsumer<T> {

	public T accept(ResultSet rs)throws Exception;
	
}
