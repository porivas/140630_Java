package date20140731;

import java.util.*;

public class PyramidRoomCheck {
	public static void main(String[] args) {

		/*	1. room �迭 ���� i �� �����ؼ� �� 1��¥�� 2��¥�� 3��¥��
		2. �迭�� ���� ���� i�� �Է¹޾Ƽ� 1���濡 1, 2���濡 2, 100������, ���� ���ڴ� ����������
		3. �� ��° �迭 floor ����. ���ǰ�����ŭ ����. ������ �� ���� ������ �ڵ����� �˰� �ʹ�. i�� Ȱ���ϰ�, �� �������� floorNum���� ����. 
		4. floor[floorNum]���� room�� floorNum�� ����. 
		5. �����κ��� input�� �޾Ƽ� �� ��, �� ȣ�� ����� ��ȯ
		�Ǻ���ġ ����? */
		//		�� saveFloorNum (14)��. �ѹ�� totalRoomNum ������ ���� parkingLot
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Ƕ�̵� ���� � ����� �ǰ���? : ");
		int roomNum = scanner.nextInt();
		int totalRoomNum = 0;
		int saveFloorNum = 0;
		int roomValue = 1;
		for (int floorNum = 1; totalRoomNum <= roomNum; floorNum++ ){
			totalRoomNum += floorNum;
			saveFloorNum = floorNum;		}
		int parkingLot = totalRoomNum - roomNum;
		int[][] floor =  new int[saveFloorNum][];
		System.out.println("�Ƕ�̵� ������");		
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
		
		System.out.print("���ȣ�� �Է��Ͽ� ��ġ�� ��ȸ�ϼ���: ");
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
			System.out.print("����� �����忡 �ֽ��ϴ�.");
		}
		else{
		System.out.print("����� "); System.out.print(finalFloor); System.out.print("�� �Դϴ�."); 
		System.out.print(finalRoom); System.out.print("ĭ �Դϴ�.");
		}

		//		ArrayList-LinkedList-HashMap ���� 
		//		��ó: http://kscho.tistory.com/entry/%EC%A4%91%EC%9A%94%EA%B8%B0%EC%88%A0%EC%9A%94%EC%95%BD-ArrayList-LinkedList-HashMap-%EC%84%B1%EB%8A%A5-%EB%B0%8F-%EC%82%AC%EC%9A%A9%EB%B2%95

		//		����Ʈ�� �����ؼ� ����Ʈ�� ���� �߰��ϴ� ���
		//		��ó: http://stackoverflow.com/questions/16096273/linking-arrays-in-java
		//		List<Short> indexes = new ArrayList<Short>();
		//        indexes.add(Years[i]);

		//		��������ŭ �迭����		
		//		�迭���� 1ĭ¥�� 2ĭ¥��~~~~~ ��������ŭ

		//		 ?? �������� �迭�� �����ϴ� ��� ������ ��
	}

}
