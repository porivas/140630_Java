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
      System.out.println("총 타일의 갯수를 입력해주세요 : ");
      tileCount = Integer.parseInt(scanner.nextLine());
      System.out.println("도시 타일의 갯수를 입력해주세요(총 타일의 갯수보다 무조건 작아야 합니다.) : ");
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
         //System.out.println("첫 번째 루프를 돌고 있습니다.");
         if(tileArray[cityIndex] == null) {
            //System.out.println("첫 번째 조건문 실행");
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
         //System.out.println("두 번째 루프를 돌고 있습니다.");
         if(tileArray[tileIndex] == null) {
            //System.out.println("두 번째 조건문 실행");
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
		System.out.println(player.getMyName()+"님은 처음으로부터 "+(player.myLocation)+"번째에 위치한"+tileArray[player.getMyLocation()].getName()+"에 위치하고 있습니다.");
		System.out.println("Enter를 누르면 주사위를 굴립니다.");
		scanner.nextLine();
		diceNum1 = (int)(1+Math.random()*6);
		System.out.println("주사위를 굴렸습니다. 주사위 값은 "+diceNum1+"입니다.");
		int myLocation = player.getMyLocation()+diceNum1 ;
		if(myLocation >= tileCount){
			myLocation -= tileCount;
			player.setMyLocation(myLocation);
			player.myMoney += 100;
			System.out.println("!! 한바퀴를 돌아 월급 100원을 받았습니다. !! 총 "+player.myMoney+"원이 되었습니다.");
		}
		player.setMyLocation(myLocation);
		displayMap();
		System.out.println(tileArray[myLocation].getName()+": 타일로 이동합니다.");
		tileArray[player.myLocation].checkCity(tileArray[player.myLocation].getCityStatus(), player);
	}


	@Override
	public String toString() {
		return "TileManager [tileArray=" + Arrays.toString(tileArray)
				+ ", scanner=" + scanner + ", tileCount=" + tileCount
				+ ", cityCount=" + cityCount + "]";
	}

}
