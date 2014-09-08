package org.thinker.fs.Logic;

import java.util.List;

import org.thinker.fs.Data.FoodStoreVO;
import org.thinker.fs.Data.Location;

public interface FoodStoreService {

	public void regist(FoodStoreVO vo)throws Exception;
	
	public FoodStoreVO findByName(String name)throws Exception;
	
	public List<FoodStoreVO> findNearStores(Location currentPos)throws Exception;
	
}
