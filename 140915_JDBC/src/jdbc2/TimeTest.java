package jdbc2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	
	TimeDAO dao;
	// �׽�Ʈ �ϱ����� �ʱ�ȭ �ϴ� ��. 
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
		// Null�� �ƴ϶�� ���� Ȯ���ϴ�. 
		assertNotNull(dao.getTime());
		
	}

}