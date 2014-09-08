package org.thinker.fs.UI;

import java.util.Map;
import java.util.Scanner;

import org.thinker.fs.DAO.IFoodStoreDAO;
import org.thinker.fs.DAO.MakeInstance;
import org.thinker.fs.Logic.FoodStoreService;

public class FoodStoreUI {
	
	// UI���� 3���� ��ü ����.
	private FoodStoreService service;
	private Scanner scanner;
	private Map<String, Task> taskMap;
	
	// �������� parameter�� FoodStoreService ��ü 
	public FoodStoreUI(FoodStoreService service)throws Exception {
		super();
	// ����� ��ü �ʱ�ȭ
		this.service = service;
		this.scanner = new Scanner(System.in);
	// ���Ͽ��� �۾������� ���پ� �ҷ���
		this.taskMap = MakeInstance.loadTask("C:\\zzz\\store.txt", service);
//		this.taskMap = IFoodStoreDAO.instance;
	}
	
	// �޼ҵ�
	public void execute(){
		
		
		System.out.println("TaskName ");
		String taskName = scanner.nextLine();
		//�Է¹��� ���� �� ���� parameter�� task ��ü ����� ���ÿ� �ʱ�ȭ
		Task task = taskMap.get(taskName);
		/*
    		V get(Object key); Ű ���� �޾Ƽ� �ش� Object�� �����´�.
		 */
		try {
			task.doJob();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// ��𿡼� ������ �������� ���. 
//			e.printStackTrace(); // �� ǥ���� ����� �Ʒ��� �ڵ��� �ϳ��� ����� ���� ����
//			return;			// 1��. �̰� ���� ��𿡼� � ������ ������ �� ���� ����. 
			System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���"); // 2��
		}	
		execute();	//	��͹ݺ��� ȣ��
	}
}
































