package date20140808_food;

import java.util.Arrays;

public class RestaurantManager {

	Restaurant[] foodArr= new Restaurant [10];



	public void createStore(){

		foodArr [0] = new Restaurant(37.564188, 126.993011, "명동칼국수", "칼국수", "한식");	
		foodArr [1] = new Restaurant(37.564503, 126.992636, "점심뷔페", "불고기, 카레, 방울토마토", "한식" );	
		foodArr [2] = new Restaurant(37.565134, 126.992187, "오모가리칼국수", "칼국수", "한식");	
		foodArr [3] = new Restaurant(37.564593, 126.991756, "한평커피", "커피, 쥬스, 베이커리", "까페" );	
		foodArr [4] = new Restaurant(37.563786, 126.991223, "함지성", "짜장면, 짬뽕, 볶음밥, 군만두, 탕수육", "중식" );	
		foodArr [5] = new Restaurant(37.564879, 126.989664 , "김가네", "김밥, 김치볶음밥, 우동, 라면", "분식" );	
		foodArr [6] = new Restaurant(37.564260, 126.993358, "낭만짬뽕", "짬뽕, 짬뽕밥, 군만두", "중식" );	
		foodArr [7] = new Restaurant(37.565788,126.992966, "순대국밥집", "순대, 소주, 우사골국밥, 돼지국밥", "한식" );	
		foodArr [8] = new Restaurant(37.565330,126.993100 , "마포만두", "군만두, 김치만두, 고기만두, 갈비만두, 모듬만두, 개성만두", "한식" );	
		foodArr [9] = new Restaurant(37.563490,126.992004, "본가닭한마리", "닭갈비, 삼계탕, 닭도리탕, 반계탕, 백숙, 닭구이 ", "한식" );	
	}

	//메뉴입력받으면 메뉴에 해당하는 음식점 찾아주기
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

	//가까운 음식점 찾기(가장 근접한거 1개)
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
	//위치정보 주면 거리상 가장가까운 순서대로 정렬
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

