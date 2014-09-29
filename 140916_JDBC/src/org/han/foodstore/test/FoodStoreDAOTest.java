package org.han.foodstore.test;

import static org.junit.Assert.fail;

import java.sql.ResultSet;

import org.han.foodstore.dao.FoodStoreDAO;
import org.han.foodstore.dao.FoodStoreDAOImpl;
import org.han.foodstore.util.SqlAgent;
import org.han.vo.StoreVO;
import org.junit.Before;
import org.junit.Test;

public class FoodStoreDAOTest {
	
	FoodStoreDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new FoodStoreDAOImpl();
	}

	@Test
	public void testInsert() {
		try{
			StoreVO vo = new StoreVO();
				vo.setSname("동경우동");
				vo.setAddr("서울 중구....");
				vo.setKeyword("우동");
				vo.setSdesc("줄 서서 기다려야 함");
				
				dao.create(vo);
				
		}catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testSelect() {
		StoreVO vo = new StoreVO();
		
		try {
			System.out.println(dao.read(4).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		
		try {
			dao.delete(3);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testUpdate() {
		try{
			StoreVO vo = new StoreVO();
				vo.setSname("김밥천국");
				vo.setAddr("서울 중구 인현동...");
				vo.setKeyword("김밥");
				vo.setTel("02-1000-1000");
				vo.setSdesc("김밥 한 줄 1500원");
				vo.setSno(3);
				dao.update(vo);
					
		}catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	@Test
	public void movetest() {
//		select dept.deptno, dept.dname, empno from scott.dept, scott.emp where dept.deptno = emp.deptno
//		String query = "select empno, ename from scott.emp order by empno desc";
		String query = "select dept.deptno, dept.dname, empno from scott.dept, scott.emp where dept.deptno = emp.deptno";
		
		try {
			new SqlAgent(){

				@Override
				protected void doJob() throws Exception {
					// TODO Auto-generated method stub
					pstmt = con.prepareStatement(query,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					//JDBC 드라이버가 지원하지 않으면 에러가 난다. 
					//커넥션을 다시 살펴볼 것. 
					rs = pstmt.executeQuery();
					
					
					rs.absolute(1);
					System.out.println(rs.getString(1));
					
					rs.updateString("dname", "홍길동");
					
					rs.updateRow();
					
//					while(rs.next()){
//						System.out.println(rs.getString(1));
//					}
					
				}
				
			}.doExecute();
		} catch (Exception e) {
			// TODO: handle exception
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
