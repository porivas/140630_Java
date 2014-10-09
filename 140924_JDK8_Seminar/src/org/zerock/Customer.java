package org.zerock;
import java.util.List;


public class Customer {
	
	private final List<Order> orderList;
	

	public Customer(List<Order> orderList) {
		super();
		this.orderList = orderList;
	}


	public List<Order> getOrderList() {
		return orderList;
	}

}

