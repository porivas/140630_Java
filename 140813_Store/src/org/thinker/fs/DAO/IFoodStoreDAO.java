package org.thinker.fs.DAO;

import java.util.List;

import org.thinker.fs.Data.FoodStoreVO;

public interface IFoodStoreDAO {
	//�������̽��� �����ϴ� ��� ��ü, ������ ����� ����
	//�����ΰ� �����θ� instance�� ����
	IFoodStoreDAO instance = new FoodStoreDAOImpl();
	
	// FoodStoreDAO��� �������̽��� �����ϸ� 
	// loadData() �� ����� ���´�. List<FoodStoreVO> Ÿ���� ���𰡸� �������ش�.
	public List<FoodStoreVO> loadData()throws Exception;
	// saveData() �� ����� ���´�. List<FoodStoreVO> Ÿ���� list�� �Ķ���ͷ� �޴´�. 
	public void saveData(List<FoodStoreVO> list)throws Exception;
	
}