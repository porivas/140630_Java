package org.thinker.fs.UI;

import org.thinker.fs.Logic.FoodStoreService;

public interface Task {

	public void setService(FoodStoreService service);
	
	public void doJob()throws Exception;
}
