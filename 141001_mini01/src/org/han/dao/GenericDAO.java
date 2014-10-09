package org.han.dao;

import java.util.List;

import org.han.vo.MP3VO;

public interface GenericDAO<E, R, K> {
	
	public void create (E vo)throws Exception;
	
	public List<MP3VO> read(R maxNum, K minNum)throws Exception;

	public void update(E vo)throws Exception;

	public void delete(R mno)throws Exception;
	

}
