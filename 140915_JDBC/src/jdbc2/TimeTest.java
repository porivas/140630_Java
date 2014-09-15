package jdbc2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	
	TimeDAO dao;
	// 테스트 하기전에 초기화 하는 것. 
	@Before
	public void setUp() throws Exception {
		dao = new TimeDAOImpl();
		System.out.println("setup....");
		
	}

	@Test
	public void test() {
		int v = 10;
		assertEquals(v,10);
	}
	
	@Test
	public void test2() throws Exception{
		dao.getTime();
		// Null이 아니라는 것이 확실하다. 
		assertNotNull(dao.getTime());
		
	}

}
