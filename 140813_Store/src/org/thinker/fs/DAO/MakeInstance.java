package org.thinker.fs.DAO;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.thinker.fs.Logic.FoodStoreService;
import org.thinker.fs.UI.Task;

public class MakeInstance {
	
	// static 전역메소드 why?? 빠르게 접근하기 위해 
	// Map<String, Task>타입의 무언가를 리턴
	// String타입의 fileName, FoodStoreService타입의 service를 파라미터로
	public static Map<String, Task>  loadTask  (String fileName, FoodStoreService service) throws Exception {
		
		// HashMap하나 만들어서 Map 타입의 taskMap에 저장
		Map<String, Task> taskMap = new HashMap<String, Task>();
		
		// properties InputStream이랑 같지만 잘라내는 기능이 내장되어 있음
		// properties는 보통 설정파일의 확장자. 설정파일을 위해 만들어진건가?
		Properties prop = new Properties(); // 파일을 자동으로 잘라주기 위해 생성
		prop.load(new FileInputStream(fileName));
		// Iterator는 자바의 반복자. (반복자는 외부반복자와 내부반복자로 나뉘는데, 자바는 외부반복자만 존재)
		// 개체의 요소들을 출력할 때, 기존의 인덱스 값을 이용한 호출이 불편하다고 생각해서 생긴 편리한 방식이다.
		Iterator names = prop.keySet().iterator();
		// 이 한줄이 이해가 안가
		while(names.hasNext()){			// 다음 값이 있을때만 실행
			String key = (String)names.next();		// 다음값불러옴
			String value = (String)prop.get(key);	// 키 값 로드
			System.out.println(key +":" + value);	
			
			Task obj = (Task)Class.forName(value).newInstance();
			// 파일에서 클래스 경로를 불러와서 객체생성
			obj.setService(service);
			
			taskMap.put(key, obj);
		}
		
		return taskMap;
	}

}
