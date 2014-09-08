package date20140731;

import java.util.*;

public class PyramidRoomCheck {
	public static void main(String[] args) {

		/*	1. room 배열 생성 i 를 설정해서 방 1개짜리 2개짜리 3개짜리
		2. 배열에 값을 대입 i를 입력받아서 1번방에 1, 2번방에 2, 100번까지, 남은 숫자는 주차장으로
		3. 두 번째 배열 floor 생성. 층의갯수만큼 생성. 생성시 몇 층을 만들지 자동으로 알고 싶다. i를 활용하고, 몇 층인지는 floorNum으로 저장. 
		4. floor[floorNum]에는 room을 floorNum개 넣음. 
		5. 유저로부터 input을 받아서 몇 층, 몇 호에 사는지 반환
		피보나치 수열? */
		//		총 saveFloorNum (14)층. 총방수 totalRoomNum 주차장 갯수 parkingLot
		Scanner scanner = new Scanner(System.in);
		System.out.print("피라미드 방을 몇개 만드실 건가요? : ");
		int roomNum = scanner.nextInt();
		int totalRoomNum = 0;
		int saveFloorNum = 0;
		int roomValue = 1;
		for (int floorNum = 1; totalRoomNum <= roomNum; floorNum++ ){
			totalRoomNum += floorNum;
			saveFloorNum = floorNum;		}
		int parkingLot = totalRoomNum - roomNum;
		int[][] floor =  new int[saveFloorNum][];
		System.out.println("피라미드 조감도");		
		for (int i=0; i<saveFloorNum; i++){
			floor[i] = new int[i+1];
			for (int j=0; j<i+1; j++){
				floor[i][j] = roomValue;
				System.out.print(floor[i][j]);
				System.out.print(", ");
				roomValue++; 
			}
			System.out.println();
		}
		for (int i=0; i<parkingLot;i++){
			floor[saveFloorNum-1][saveFloorNum-parkingLot+i] = 0;
		}
		
		System.out.print("방번호를 입력하여 위치를 조회하세요: ");
		int scanNum = scanner.nextInt();
		int finalFloor = 0;
		int finalRoom = 0;
		int reverseFloor = 0;
		for (int i=0; i<saveFloorNum; i++){
			for (int j=0; j<i+1; j++){
				if (floor[i][j] == scanNum){
					finalFloor = saveFloorNum-(i);
					finalRoom = j+1;
				}
			}
		}
		if (finalFloor==0 && finalRoom ==0 ){
			System.out.print("당신은 주차장에 있습니다.");
		}
		else{
		System.out.print("당신은 "); System.out.print(finalFloor); System.out.print("층 입니다."); 
		System.out.print(finalRoom); System.out.print("칸 입니다.");
		}

		//		ArrayList-LinkedList-HashMap 사용법 
		//		출처: http://kscho.tistory.com/entry/%EC%A4%91%EC%9A%94%EA%B8%B0%EC%88%A0%EC%9A%94%EC%95%BD-ArrayList-LinkedList-HashMap-%EC%84%B1%EB%8A%A5-%EB%B0%8F-%EC%82%AC%EC%9A%A9%EB%B2%95

		//		리스트를 생성해서 리스트에 값을 추가하는 기능
		//		출처: http://stackoverflow.com/questions/16096273/linking-arrays-in-java
		//		List<Short> indexes = new ArrayList<Short>();
		//        indexes.add(Years[i]);

		//		층갯수만큼 배열생성		
		//		배열생성 1칸짜리 2칸짜리~~~~~ 층갯수만큼

		//		 ?? 리모컨을 배열에 저장하는 방법 질문할 것
	}

}
