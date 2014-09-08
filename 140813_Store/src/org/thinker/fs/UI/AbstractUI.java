package org.thinker.fs.UI;

import java.util.Scanner;

import org.thinker.fs.Logic.FoodStoreService;

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