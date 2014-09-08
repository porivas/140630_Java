package org.thinker.fs;

import java.util.List;

public interface FoodStoreService {

	public void regist(FoodStoreVO vo)throws Exception;
	
	public FoodStoreVO findByName(String name)throws Exception;
	
	public List<FoodStoreVO> findNearStores(Location currentPos)throws Exception;
	
}
