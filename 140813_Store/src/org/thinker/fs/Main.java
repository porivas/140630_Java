package org.thinker.fs;

import org.thinker.fs.UI.FoodStoreUI;


// UI만들고 내부 메소드 execute 실행
public class Main {
	
	public static void main(String[] args)throws Exception {
		
//		for(int i = 0; i <100; i++){
//			
//			SingleEx obj = SingleEx.getInstance();
//			System.out.println(obj);
//			obj = null;
//		}
		FoodStoreUI ui = new FoodStoreUI(null);
		
		ui.execute();
		
		
		
	}

}
