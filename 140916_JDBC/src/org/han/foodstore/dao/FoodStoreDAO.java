package org.han.foodstore.dao;

import org.han.vo.StoreVO;

public interface FoodStoreDAO {
	
	public void create (StoreVO vo)throws Exception;
	
	public StoreVO read(Integer sno)throws Exception;

	public void update(StoreVO vo)throws Exception;

	public void delete(Integer sno)throws Exception;
	
	// 인터페이스를 implement 하는 경우, 항상 테스트 코드를 함께 만드는 습관을 들일 것. 

}
