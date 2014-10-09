package org.han.service;

import org.han.dao.MP3BBSDAOImpl;
import org.han.vo.MP3VO;

public class UploadMp3Service {
	
	private MP3BBSDAOImpl dao;
	
	public void setDao(MP3BBSDAOImpl dao) {
		this.dao = dao;
	}

	public void uploadMP3(MP3VO vo)throws Exception{  
//		dao = new MP3BBSDAOImpl();
		this.dao.addMp3(vo);
	}
}
