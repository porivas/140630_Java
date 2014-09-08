package org.thinker.fs;

import java.util.Map;
import java.util.Scanner;

public class FoodStoreUI {
	
	private FoodStoreService service;
	private Scanner scanner;
	private Map<String, Task> taskMap;
	
	public FoodStoreUI(FoodStoreService service)throws Exception {
		super();
		this.service = service;
		this.scanner = new Scanner(System.in);
		this.taskMap = MakeInstance.loadTask("C:\\zzz\\store.txt", service);
	}
	
	public void execute(){
		
		System.out.println("TaskName ");
		String taskName = scanner.nextLine();
		Task task = taskMap.get(taskName);
		
		try {
			task.doJob();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		execute();
	}
}
































