package org.han.service;

import org.han.dao.MP3BBSDAOImpl;
import org.han.vo.MP3VO;

public class MP3InfoService {
	
	private MP3BBSDAOImpl dao;
	
	public void setDao(MP3BBSDAOImpl dao) {
		this.dao = dao;
	}

	public MP3VO mp3Info(Integer mno)throws Exception{  
		
		MP3VO vo = new MP3VO();
		vo = this.dao.MP3Info(mno);
		
		return vo;
	}
}
