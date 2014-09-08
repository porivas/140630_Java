package org.thinker.fs.UI;

import java.util.Map;
import java.util.Scanner;

import org.thinker.fs.DAO.IFoodStoreDAO;
import org.thinker.fs.DAO.MakeInstance;
import org.thinker.fs.Logic.FoodStoreService;

public class FoodStoreUI {
	
	// UI에서 3가지 객체 선언.
	private FoodStoreService service;
	private Scanner scanner;
	private Map<String, Task> taskMap;
	
	// 생성자의 parameter는 FoodStoreService 객체 
	public FoodStoreUI(FoodStoreService service)throws Exception {
		super();
	// 선언된 객체 초기화
		this.service = service;
		this.scanner = new Scanner(System.in);
	// 파일에서 작업내용을 한줄씩 불러옴
		this.taskMap = MakeInstance.loadTask("C:\\zzz\\store.txt", service);
//		this.taskMap = IFoodStoreDAO.instance;
	}
	
	// 메소드
	public void execute(){
		
		
		System.out.println("TaskName ");
		String taskName = scanner.nextLine();
		//입력받은 문자 한 줄을 parameter로 task 객체 선언과 동시에 초기화
		Task task = taskMap.get(taskName);
		/*
    		V get(Object key); 키 값을 받아서 해당 Object를 가져온다.
		 */
		try {
			task.doJob();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 어디에서 오류가 났는지를 출력. 
//			e.printStackTrace(); // 이 표현을 지우고 아래의 코드중 하나를 사용할 수도 있음
//			return;			// 1번. 이걸 쓰면 어디에서 어떤 오류가 났는지 알 수가 없음. 
			System.out.println("잘못입력하셨습니다. 다시 입력하세요"); // 2번
		}	
		execute();	//	재귀반복문 호출
	}
}
































