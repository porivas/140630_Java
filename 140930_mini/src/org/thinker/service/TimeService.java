package org.thinker.service;

import org.thinker.dao.TimeDAO;

public class TimeService {

	private TimeDAO dao;
	
	//setter
	public void setDao(TimeDAO dao) {
		this.dao = dao;
	}

	public String getTime() throws Exception{
		return dao.getTime();
	}
	
	
	
}
