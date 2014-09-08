package date20140807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TileManager {
   
	
   public ArrayList<Tile> tileList;
   private int diceNum1;
   public Tile[] tileArray;
   private Scanner scanner;
   private int tileCount, cityCount;
   private int trigger2;
   
   public TileManager() {
      scanner = new Scanner(System.in);
      System.out.println("�� Ÿ���� ������ �Է����ּ��� : ");
      tileCount = Integer.parseInt(scanner.nextLine());
      System.out.println("���� Ÿ���� ������ �Է����ּ���(�� Ÿ���� �������� ������ �۾ƾ� �մϴ�.) : ");
      cityCount = Integer.parseInt(scanner.nextLine());
      tileList = shuffleTile(tileCount, cityCount);
      tileArray = tileList.toArray(tileArray);
      for (int i = 0; i < tileArray.length; i++) {
    	  tileArray[i].setLocattionNum(i);
	}
      displayMap();
   }
   
   public void displayMap(){
	   	for (int k = 0; k < tileArray.length; k++) {
			System.out.print("|"+tileArray[k].getName()+", "+tileArray[k].getLocattionNum()+"|");
		}
	      System.out.println();
   }
   
   public ArrayList<Tile> shuffleTile(int tileCount, int cityCount) {
      
      tileArray = new Tile[tileCount];
      
      int cnt1 = 0, cnt2 = 0;
      int tileIndex = 0, cityIndex = 0;
      int cityNum = 0, emptyNum = 0;
      
      
      while(true) {
         cityIndex = (int)(Math.random()*cityCount);
         //System.out.println("ù ��° ������ ���� �ֽ��ϴ�.");
         if(tileArray[cityIndex] == null) {
            //System.out.println("ù ��° ���ǹ� ����");
            cnt1++;
            tileArray[cityIndex] = new City();
            tileArray[cityIndex].setLocattionNum(cityIndex);
            tileArray[cityIndex].setName("City"+ cityNum);
            ((City) tileArray[cityIndex]).setCityPrice(500 + (int)(Math.random()*500));
            cityNum++;
            if(cnt1 == cityCount) break;
         }
      }
      
      while(true) {
         tileIndex = (int)((Math.random()*(tileCount-cityCount))+cityCount);
         //System.out.println("�� ��° ������ ���� �ֽ��ϴ�.");
         if(tileArray[tileIndex] == null) {
            //System.out.println("�� ��° ���ǹ� ����");
            cnt2++;
            tileArray[tileIndex] = new Tile();
            tileArray[tileIndex].setLocattionNum(tileIndex);
            tileArray[tileIndex].setName("Empty"+ emptyNum);
            tileArray[tileIndex].setCityStatus(9);
            emptyNum++;
            if(cnt2 == (tileCount-cityCount)) break;
         }
      }
      tileList = new ArrayList<Tile>(Arrays.asList(tileArray));
      Collections.shuffle(tileList);
      return tileList;
   }
   
	public void goToNextTile(Player player) {
		System.out.println(player.getMyName()+"���� ó�����κ��� "+(player.myLocation)+"��°�� ��ġ��"+tileArray[player.getMyLocation()].getName()+"�� ��ġ�ϰ� �ֽ��ϴ�.");
		System.out.println("Enter�� ������ �ֻ����� �����ϴ�.");
		scanner.nextLine();
		diceNum1 = (int)(1+Math.random()*6);
		System.out.println("�ֻ����� ���Ƚ��ϴ�. �ֻ��� ���� "+diceNum1+"�Դϴ�.");
		int myLocation = player.getMyLocation()+diceNum1 ;
		if(myLocation >= tileCount){
			myLocation -= tileCount;
			player.setMyLocation(myLocation);
			player.myMoney += 100;
			System.out.println("!! �ѹ����� ���� ���� 100���� �޾ҽ��ϴ�. !! �� "+player.myMoney+"���� �Ǿ����ϴ�.");
		}
		player.setMyLocation(myLocation);
		displayMap();
		System.out.println(tileArray[myLocation].getName()+": Ÿ�Ϸ� �̵��մϴ�.");
		tileArray[player.myLocation].checkCity(tileArray[player.myLocation].getCityStatus(), player);
	}


	@Override
	public String toString() {
		return "TileManager [tileArray=" + Arrays.toString(tileArray)
				+ ", scanner=" + scanner + ", tileCount=" + tileCount
				+ ", cityCount=" + cityCount + "]";
	}

}
