package org.thinker.fs;

public interface Task {

	public void setService(FoodStoreService service);
	
	public void doJob()throws Exception;
}
