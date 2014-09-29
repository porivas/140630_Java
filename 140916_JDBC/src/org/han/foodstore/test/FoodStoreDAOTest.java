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
				vo.setSname("����쵿");
				vo.setAddr("���� �߱�....");
				vo.setKeyword("�쵿");
				vo.setSdesc("�� ���� ��ٷ��� ��");
				
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
				vo.setSname("���õ��");
				vo.setAddr("���� �߱� ������...");
				vo.setKeyword("���");
				vo.setTel("02-1000-1000");
				vo.setSdesc("��� �� �� 1500��");
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
					//JDBC ����̹��� �������� ������ ������ ����. 
					//Ŀ�ؼ��� �ٽ� ���캼 ��. 
					rs = pstmt.executeQuery();
					
					
					rs.absolute(1);
					System.out.println(rs.getString(1));
					
					rs.updateString("dname", "ȫ�浿");
					
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
