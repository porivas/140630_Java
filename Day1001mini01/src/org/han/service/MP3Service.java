package org.han.service;

import java.util.List;

import org.han.dao.MP3DAOImpl;
import org.han.vo.MP3VO;

public class MP3Service {
	private MP3DAOImpl dao;

	public void setDao(MP3DAOImpl dao) {
		this.dao = dao;
	}
	public List<MP3VO> mainList() throws Exception{
		return dao.mainList(16, 0);
	}
}
