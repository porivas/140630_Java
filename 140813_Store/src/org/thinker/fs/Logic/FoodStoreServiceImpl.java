package org.thinker.fs.Logic;

import java.util.List;

import org.thinker.fs.DAO.IFoodStoreDAO;
import org.thinker.fs.Data.FoodStoreVO;
import org.thinker.fs.Data.Location;

public class FoodStoreServiceImpl implements FoodStoreService {

	private IFoodStoreDAO dao;
	
	@Override
	public void regist(FoodStoreVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.instance.saveData(null);
	}

	@Override
	public FoodStoreVO findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodStoreVO> findNearStores(Location currentPos)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
