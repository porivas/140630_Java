package org.zerock.sample3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradeService {

	private final List<GradeVO> list;
	
	public GradeService(){
		this.list = new LinkedList<GradeVO>();
	}
	
	public void addGradeOld(GradeVO newgrade)throws Exception{
		
		Iterator<GradeVO> it = list.iterator();
		
		while(it.hasNext()){
			
			GradeVO vo = it.next();
			
			if(vo.getSubject().equals(newgrade.getSubject())){
				throw new Exception("exist...");
			}
		}
		
		list.add(newgrade);
	}
	
	
	public void addGrade(GradeVO newgrade)throws Exception{
		
		long count = 
				list.stream().filter(
						(vo) -> vo.getSubject().equals(newgrade.getSubject())).count();
		
		if(count > 0){
			throw new Exception("Exist " + newgrade.getSubject());
		}
		
		list.add(newgrade);
	}
	
	public List<GradeVO> find(Predicate<GradeVO> cri){
		
		return list.stream().filter(cri).collect(Collectors.toList());
	}
	
	public List<String> changeData(Function<GradeVO, String> fn){
		
		
		return list.stream().map(fn).collect(Collectors.toList());
		
	}
	
	public List<String> addAll( Function<GradeVO, Stream<String>> mapper){
		
		
		return list.stream().flatMap(mapper).collect(Collectors.toList());
		
	}
	
	public Integer getTotal( ){
		
		Stream<Integer> temp = list.stream().map(vo -> vo.getGrade());
		
		int total =  temp.reduce(0, (sum,value) -> sum + value);
		
		return total;
	}
	
	
	public void findLazy(Predicate<GradeVO> cri){
		//호출 되지 않는다. 
		list.stream().filter(cri).count();
		
	}
	
	
	
}





