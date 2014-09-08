package org.thinker.fs.DAO;

import java.util.List;

import org.thinker.fs.Data.FoodStoreVO;

public interface IFoodStoreDAO {
	//인터페이스에 선언하는 모든 객체, 변수는 상수로 변함
	//스스로가 스스로를 instance로 생성
	IFoodStoreDAO instance = new FoodStoreDAOImpl();
	
	// FoodStoreDAO라는 인터페이스를 구현하면 
	// loadData() 란 기능을 갖는다. List<FoodStoreVO> 타입의 무언가를 리턴해준다.
	public List<FoodStoreVO> loadData()throws Exception;
	// saveData() 란 기능을 갖는다. List<FoodStoreVO> 타입의 list를 파라미터로 받는다. 
	public void saveData(List<FoodStoreVO> list)throws Exception;
	
}