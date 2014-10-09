package org.zerock.sample3.test;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.zerock.sample3.GradeService;
import org.zerock.sample3.GradeVO;

public class GradeServiceTest {

	private GradeService service;
	
	@Before
	public void ready(){
		
		service = new GradeService();
		try {
			service.addGrade(new GradeVO("A",90));
			service.addGrade(new GradeVO("B",80));
			service.addGrade(new GradeVO("C",70));
			service.addGrade(new GradeVO("D",60));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testByCri() {

		List<GradeVO> list = service.find((vo) -> vo.getGrade() >= 80);
		System.out.println(list);
	}
	
	@Test
	public void testByCriLazy() {

		service.findLazy((vo) -> {
			System.out.println(vo);
			return vo.getGrade() >= 80;
		});
	}
	
	@Test
	public void testChange() {
		
		List<String> subjectList = service.changeData((vo) -> vo.getSubject());
		
		System.out.println(subjectList);
	}
	
	@Test
	public void testFlatMap() {
		
		System.out.println(service.addAll((vo) -> (Stream.of(vo.getSubject(),""+vo.getGrade()))));
	}
	
	@Test
	public void testSum() {
		
		System.out.println(service.getTotal());
	}	
}







