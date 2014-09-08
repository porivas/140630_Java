package date20140807;
import java.util.Scanner;
import java.lang.Math;

public class City extends Tile {

	Scanner scanner = new Scanner(System.in);
	Player player;
	private int cityPrice;		// Tile 리스트에서 도시가격이 추가항목으로 발생(상속)
	public int ownerNum;		// 플레리어 ID번호로 받아 점유지임을 확인
	public int cityStatus = 0;
	private int selectBuy;

	// 도시 가격을 공유
	//	public City(int cityPrice, int ownerNum) {
	//		super();
	//		this.cityPrice = cityPrice;
	//		this.ownerNum = ownerNum;
	//	}

	//  주사위 굴려서 1~6까지의 결과값을 출력하는 함수
	int diceNumber;
	public int diceNum(){
		diceNumber = ((int)Math.random()*6)+1;
		return diceNumber;
	}

	// City에 도달하면 랜덤하게 게임1이나 게임2를 실행
	// 실행하는 대상에 따라 함수가 다르게 적용하므로 플레이어를 함수 input값으로 받음
	public void diceGame(Player player){
		int selectNum = ((int)Math.random()*2);
		if (selectNum == 0){
			highNumGame(player);
		}
		else if(selectNum ==1){
			approximateGame(player);
		}
	}

	// 배열 선언 후 배열내부의 요소들을 문자열로 출력
	@Override
	public String toString() {
		return "City [scanner=" + scanner + ", cityPrice=" + cityPrice
				+ ", ownerNum=" + ownerNum + "]";
	}

	//		해당 City의 소유여부를 확인하고 구매/잔고확인/통행료 부과등을 실행

	@Override
	public void checkCity(int cityStatus, Player player) {
		super.checkCity(cityStatus, player);
		// Tile이 도시이지만 비점유지역일 경우 (cityStatus값이 0)
		if(cityStatus == 0 && player.getMyMoney() >= this.cityPrice ){
			System.out.println("! 이 지역은 현재 비점유중인 지역입니다. !");
			playDiceGame(player);
			System.out.println("이 지역의 가격: "+this.cityPrice);
			System.out.println("현재의 잔고 : " + player.myMoney);
			System.out.println("==========선택지========");
			System.out.println("|| 1. 해당지역을 구매합니다. ||");
			System.out.println("|| 2. 해당지역을 통과합니다. ||");
			int select = Integer.parseInt(scanner.nextLine()); //      tileCount = Integer.parseInt(scanner.nextLine());
			if (select == 1){
				System.out.println("해당 지역 구매합니다.");
				this.setOwnerNum(player.getPlayerNum());
				player.myMoney = player.myMoney - cityPrice;
				this.cityStatus = 1;
				System.out.println("지역 구매 후에 남은 잔고 : " + player.myMoney);
			}
			else{
				System.out.println("해당지역을 구매하지 않고 통과하도록 합니다.");
			}
		}
		else if(cityStatus == 0){
			System.out.println("해당지역의 금액보다 현재 보유 금액이 적어 도시를 통과합니다.");
		}
		// Tile이 도시이면서 점유지역일 경우 (cityStatus값이 1)
		if(cityStatus == 1){
			System.out.println("이 지역은 현재 점유중인 지역입니다.");
			if(player.getPlayerNum() == this.ownerNum){
				System.out.println("여기는 자신의 땅입니다. 그냥 지나가겠습니다 ~♪");
			}
			else
			{
				System.out.println("여기는 다른사람의 땅입니다. 통행료를 지급하십시오.");
				player.myMoney = player.myMoney - (int)(this.cityPrice)/10;
				System.out.println("통행료 "+(int)(this.cityPrice)/10+"원 지급");
				System.out.println("남은 잔고 : " + player.myMoney);
				if (player.getMyMoney() >= (this.cityPrice)*2){
					System.out.println("도시를 인수하시겠습니까? (1.Yes , 2.No)");
					System.out.println(">> 필요한 금액 : " + ((this.cityPrice)*2));
					int selectBuy = Integer.parseInt(scanner.nextLine());
					if(selectBuy == 1 ){
						System.out.println("상대방의 도시를 인수했습니다.");
						player.myMoney = player.myMoney - (this.cityPrice)*2;
						// 상대방 도시를 인수할 경우 원래 가격의 두배 지급
						System.out.println("남은 잔고 : " + player.myMoney);
					}
					else if (selectBuy == 2){
						
						System.out.println("도시를 인수하지 않습니다.");
					}
				}
				else if (player.getMyMoney() <= (this.cityPrice)/10){
					System.out.println("안타깝습니다.");					
				}
				else
				{
					System.out.println("도시를 인수할 만큼 금액을 보유하고 있지 않습니다.");
				}
			}
		}
		if(cityStatus == 9){
			System.out.println("여기는 빈칸입니다. 9 ");


		}
	}
	//	해당 City의 소유여부를 확인하고 구매/잔고확인/통행료 부과등을 실행하는 함수 종료




	// 주사위를 굴려서 더 높은 숫자가 나오는 쪽이 이기는 게임
	int start;
	Scanner startGame = new Scanner(System.in);
	int playerNum;
	int comNum;
	int randomSelector;
	
	public void playDiceGame(Player player){
		System.out.println("주사위 게임을 시작합니다.");
		randomSelector = (int)(Math.random()*2) ;
		if (randomSelector == 0){
			highNumGame(player);
		}
		else if(randomSelector == 1){
			approximateGame(player);
		}
	}
	
	public void highNumGame(Player player){
		System.out.println("주사위를 굴려 더 높은숫자가 나오면 이깁니다.");
		System.out.println(">> 주사위를 굴릴려면 Enter를 눌러주세요");
		scanner.nextLine();
		playerNum = ((int)Math.random()*6)+1;	// 플레이어 주사위 값	
		comNum = ((int)Math.random()*6)+1;			// 컴퓨터 주사위 값
		// 두 사람의 주사위 값 비교
		if (playerNum > comNum){
			System.out.println("플레이어가 더 높은숫자가 나와서 승리하였습니다.");
			player.myMoney = player.myMoney + this.cityPrice/10;
			System.out.println("현재 소지 골드 : " + player.myMoney);
		}
		else if (playerNum <= comNum){
			System.out.println("컴퓨터가 더 높은숫자가 나와서 플레이어는 패배하였습니다.");
			player.myMoney = player.myMoney - this.cityPrice/10;
			System.out.println("현재 소지 골드 : " + player.myMoney);			
		}
//		else if (playerNum == comNum){
//			System.out.println("같은 숫자가 나왔습니다. 주사위를 다시 던져주세요.");
//			highNumGame(player);
//		}
	}
	// 주사위를 굴려서 더 높은 숫자가 나오는 쪽이 이기는 게임 종료


	int basicNum;
	int playerResult;
	int comResult;
	
	//		두사람 중에서 기준값보다 더 근사값이 나오는 사람이 이기는 함수	
	public void approximateGame(Player player){
		System.out.println("주사위를 굴려 기준값보다 근사한 숫자가 나오는 사람이 승리합니다.");
		System.out.println(">> 주사위를 굴릴려면 Enter를 눌러주세요");
		scanner.nextLine();
		basicNum = ((int)Math.random()*6)+1;		// 비교기준이 되는 주사위값
		playerNum = ((int)Math.random()*6)+1;		// 플레이어 주사위 값	
		comNum = ((int)Math.random()*6)+1;	
		playerResult = (int)(Math.pow((playerNum-basicNum),2));
		comResult = (int)(Math.pow((comNum-basicNum),2));

		// 두 사람의 주사위 값 비교
		if (playerResult < comResult){
			System.out.println("플레이어가 더 근사한값이 나와서 승리하였습니다.");
			player.myMoney = player.myMoney + this.cityPrice/10;
			System.out.println("현재 소지 골드 : " + player.myMoney);
		}
		else if (playerResult >= comResult){
			System.out.println("컴퓨터가 더 근사한값이 나와서 플레이어는 패배하였습니다.");
			player.myMoney = player.myMoney - this.cityPrice/10;
			System.out.println("현재 소지 골드 : " + player.myMoney);			
		}
//		else if (playerResult == comResult){
//			System.out.println("같은 숫자가 나왔습니다. 주사위를 다시 던져주세요.");
//			approximateGame(player);
//		}
	}


	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(int ownerNum) {
		this.ownerNum = ownerNum;
	}

	public int getCityStatus() {
		return cityStatus;
	}

	public void setCityStatus(int cityStatus) {
		this.cityStatus = cityStatus;
	}

	public int getCityPrice() {
		return cityPrice;
	}

	public void setCityPrice(int cityPrice) {
		this.cityPrice = cityPrice;
	}



}
