package org.thinker.fs;

import java.util.Scanner;

public class FoodStoreUI {
	
	private FoodStoreService service;
	private Scanner scanner;
	
	public FoodStoreUI(FoodStoreService service) {
		super();
		this.service = service;
		this.scanner = new Scanner(System.in);
	}
	
	public void execute(){
		
		Task task = null;
		
		try {
			task.doJob();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		execute();
	}
}
































