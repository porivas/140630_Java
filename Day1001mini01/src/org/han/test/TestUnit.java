package org.han.test;

import java.util.ArrayList;
import java.util.List;

import org.han.dao.MP3DAOImpl;
import org.han.vo.MP3VO;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUnit {
	private static Logger logger = LoggerFactory.getLogger("controller");
//	MP3DAO1 dao;
	MP3DAOImpl dao;
	MP3VO vo;
	@Before
	public void setUp() throws Exception {
//		dao = new MP3DAO1();
		dao = new MP3DAOImpl();
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//	@Test
//	public void tableDAOTest() throws Exception {
//		System.out.println(dao.getTableList());
//	}
	
//	@Test
//	public void InsertTest() throws Exception {
//		
//		vo = new MP3VO();
//		
//		vo.setTitle("title");
//		vo.setFileName("c:/zzz/aaa.mp3");
//		vo.setDescCont("�� ��ȣ �ִ����� �׸� ���Ҵ��� ���ڴ�");
//		vo.setCate("��");
//		vo.setUserID("han00");
//		vo.setrCount(0);
//		vo.setvCount(0);
//		vo.setArt("����ȣ");
//		vo.setImg("c:/zzz/yoonho.gif");
//		vo.setAlb("bit58th");
//		
//		dao.create(vo);
//		//TITLE,FILENAME,DESCCONT,CATE,USERID,RCOUNT,VCOUNT,ART,IMG,ALB
//		
//	}
	
	   @Test
	   public void SelectTest() throws Exception {
	      //����Ʈ
	      List<MP3VO> mp3List = new ArrayList<MP3VO>();
	      vo = new MP3VO();
	      
	      mp3List = dao.mainList(16, 0);
//	      System.out.println(vo.toString());
	      for (MP3VO mp3vo2 : mp3List) {
	         System.out.println(mp3vo2.toString());
	      }
	      //TITLE,FILENAME,DESCCONT,CATE,USERID,RCOUNT,VCOUNT,ART,IMG,ALB
	   }
	   
	//   @Test
	//   public void updateTest() throws Exception {
//	      
//	      vo = new MP3VO();
//	      
//	      vo.setTitle("�椻");
//	      vo.setMno(132);
	//
//	      
//	      dao.update(vo);
//	      //TITLE,FILENAME,DESCCONT,CATE,USERID,RCOUNT,VCOUNT,ART,IMG,ALB
//	      
	//   }
	   
	//   @Test
	//   public void deleteTest() throws Exception {
//	      
//	      vo = new MP3VO();
//	      
////	      vo.setMno(132);
	//
//	      
//	      dao.delete(132);
//	      //TITLE,FILENAME,DESCCONT,CATE,USERID,RCOUNT,VCOUNT,ART,IMG,ALB
//	      
	//   }
}
