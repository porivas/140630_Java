package org.thinker.fs;

import java.util.Scanner;

public abstract class AbstractUI implements Task{

	protected FoodStoreService service;
	protected Scanner scanner;
	
	public AbstractUI() {
		super();
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void setService(FoodStoreService service) {
		// TODO Auto-generated method stub
		this.service = service;
	}

}