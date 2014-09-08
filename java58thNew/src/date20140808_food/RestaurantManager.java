package date20140808_food;

import java.util.Arrays;

public class RestaurantManager {

	Restaurant[] foodArr= new Restaurant [10];



	public void createStore(){

		foodArr [0] = new Restaurant(37.564188, 126.993011, "��Į����", "Į����", "�ѽ�");	
		foodArr [1] = new Restaurant(37.564503, 126.992636, "���ɺ���", "�Ұ��, ī��, ����丶��", "�ѽ�" );	
		foodArr [2] = new Restaurant(37.565134, 126.992187, "���𰡸�Į����", "Į����", "�ѽ�");	
		foodArr [3] = new Restaurant(37.564593, 126.991756, "����Ŀ��", "Ŀ��, �꽺, ����Ŀ��", "����" );	
		foodArr [4] = new Restaurant(37.563786, 126.991223, "������", "¥���, «��, ������, ������, ������", "�߽�" );	
		foodArr [5] = new Restaurant(37.564879, 126.989664 , "�谡��", "���, ��ġ������, �쵿, ���", "�н�" );	
		foodArr [6] = new Restaurant(37.564260, 126.993358, "����«��", "«��, «�͹�, ������", "�߽�" );	
		foodArr [7] = new Restaurant(37.565788,126.992966, "���뱹����", "����, ����, ���񱹹�, ��������", "�ѽ�" );	
		foodArr [8] = new Restaurant(37.565330,126.993100 , "��������", "������, ��ġ����, ��⸸��, ���񸸵�, ��븸��, ��������", "�ѽ�" );	
		foodArr [9] = new Restaurant(37.563490,126.992004, "�������Ѹ���", "�߰���, �����, �ߵ�����, �ݰ���, ���, �߱��� ", "�ѽ�" );	
	}

	//�޴��Է¹����� �޴��� �ش��ϴ� ������ ã���ֱ�
	public int[] matchStoreMenu(String name){
		int cnt = 0;
		int[] menuIdx = new int[foodArr.length];

		for (int i = 0; i < foodArr.length; i++) {
			String s = foodArr[i].getMenu();

			if (s.matches(".*"+ name +".*")){  
//				System.out.println(foodArr[i].getName() +"\t" + foodArr[i].getMenu() );
				menuIdx[cnt] = i ;
				cnt ++;	  		
			}			
		}
		return menuIdx;
	}

	//����� ������ ã��(���� �����Ѱ� 1��)
	public int displayNearestStore(double mylng, double mylat, String menuName){
		int[] menuIdx = matchStoreMenu(menuName);
		double[] distance = new  double[menuIdx.length]; 
		for (int i = 0; i < menuIdx.length; i++) {
			foodArr[menuIdx[i]].setNearDistance(foodArr[menuIdx[i]].calcDistance(mylng, mylat));
			distance[i] = foodArr[menuIdx[i]].calcDistance(mylng, mylat);
		}
		Arrays.sort(distance);

		for (int i = 0; i < foodArr.length; i++) {
			if(distance[0] == foodArr[i].getNearDistance()){
				return i;
			}
		}
		return 99999;

	}
	//��ġ���� �ָ� �Ÿ��� ���尡��� ������� ����
	public Restaurant[]  storeSort(double mylng, double mylat){
		Restaurant[] sortedArray =  new Restaurant[foodArr.length];
		double[] distance = new  double[foodArr.length]; 
		for (int i = 0; i < foodArr.length; i++) {
			foodArr[i].setNearDistance(foodArr[i].calcDistance(mylng, mylat));
			distance[i] = foodArr[i].calcDistance(mylng, mylat);
		}
		Arrays.sort(distance);
		for (int j = 0; j < distance.length; j++) {
			for (int i = 0; i < foodArr.length; i++) {
				if(distance[j] == foodArr[i].getNearDistance()){
					sortedArray[j] =  foodArr[i];
				}
			}
		}
		return sortedArray;
	}
}

