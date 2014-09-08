package date20140807;
import java.util.Scanner;
import java.lang.Math;

public class City extends Tile {

	Scanner scanner = new Scanner(System.in);
	Player player;
	private int cityPrice;		// Tile ����Ʈ���� ���ð����� �߰��׸����� �߻�(���)
	public int ownerNum;		// �÷����� ID��ȣ�� �޾� ���������� Ȯ��
	public int cityStatus = 0;
	private int selectBuy;

	// ���� ������ ����
	//	public City(int cityPrice, int ownerNum) {
	//		super();
	//		this.cityPrice = cityPrice;
	//		this.ownerNum = ownerNum;
	//	}

	//  �ֻ��� ������ 1~6������ ������� ����ϴ� �Լ�
	int diceNumber;
	public int diceNum(){
		diceNumber = ((int)Math.random()*6)+1;
		return diceNumber;
	}

	// City�� �����ϸ� �����ϰ� ����1�̳� ����2�� ����
	// �����ϴ� ��� ���� �Լ��� �ٸ��� �����ϹǷ� �÷��̾ �Լ� input������ ����
	public void diceGame(Player player){
		int selectNum = ((int)Math.random()*2);
		if (selectNum == 0){
			highNumGame(player);
		}
		else if(selectNum ==1){
			approximateGame(player);
		}
	}

	// �迭 ���� �� �迭������ ��ҵ��� ���ڿ��� ���
	@Override
	public String toString() {
		return "City [scanner=" + scanner + ", cityPrice=" + cityPrice
				+ ", ownerNum=" + ownerNum + "]";
	}

	//		�ش� City�� �������θ� Ȯ���ϰ� ����/�ܰ�Ȯ��/����� �ΰ����� ����

	@Override
	public void checkCity(int cityStatus, Player player) {
		super.checkCity(cityStatus, player);
		// Tile�� ���������� ������������ ��� (cityStatus���� 0)
		if(cityStatus == 0 && player.getMyMoney() >= this.cityPrice ){
			System.out.println("! �� ������ ���� ���������� �����Դϴ�. !");
			playDiceGame(player);
			System.out.println("�� ������ ����: "+this.cityPrice);
			System.out.println("������ �ܰ� : " + player.myMoney);
			System.out.println("==========������========");
			System.out.println("|| 1. �ش������� �����մϴ�. ||");
			System.out.println("|| 2. �ش������� ����մϴ�. ||");
			int select = Integer.parseInt(scanner.nextLine()); //      tileCount = Integer.parseInt(scanner.nextLine());
			if (select == 1){
				System.out.println("�ش� ���� �����մϴ�.");
				this.setOwnerNum(player.getPlayerNum());
				player.myMoney = player.myMoney - cityPrice;
				this.cityStatus = 1;
				System.out.println("���� ���� �Ŀ� ���� �ܰ� : " + player.myMoney);
			}
			else{
				System.out.println("�ش������� �������� �ʰ� ����ϵ��� �մϴ�.");
			}
		}
		else if(cityStatus == 0){
			System.out.println("�ش������� �ݾ׺��� ���� ���� �ݾ��� ���� ���ø� ����մϴ�.");
		}
		// Tile�� �����̸鼭 ���������� ��� (cityStatus���� 1)
		if(cityStatus == 1){
			System.out.println("�� ������ ���� �������� �����Դϴ�.");
			if(player.getPlayerNum() == this.ownerNum){
				System.out.println("����� �ڽ��� ���Դϴ�. �׳� �������ڽ��ϴ� ~��");
			}
			else
			{
				System.out.println("����� �ٸ������ ���Դϴ�. ����Ḧ �����Ͻʽÿ�.");
				player.myMoney = player.myMoney - (int)(this.cityPrice)/10;
				System.out.println("����� "+(int)(this.cityPrice)/10+"�� ����");
				System.out.println("���� �ܰ� : " + player.myMoney);
				if (player.getMyMoney() >= (this.cityPrice)*2){
					System.out.println("���ø� �μ��Ͻðڽ��ϱ�? (1.Yes , 2.No)");
					System.out.println(">> �ʿ��� �ݾ� : " + ((this.cityPrice)*2));
					int selectBuy = Integer.parseInt(scanner.nextLine());
					if(selectBuy == 1 ){
						System.out.println("������ ���ø� �μ��߽��ϴ�.");
						player.myMoney = player.myMoney - (this.cityPrice)*2;
						// ���� ���ø� �μ��� ��� ���� ������ �ι� ����
						System.out.println("���� �ܰ� : " + player.myMoney);
					}
					else if (selectBuy == 2){
						
						System.out.println("���ø� �μ����� �ʽ��ϴ�.");
					}
				}
				else if (player.getMyMoney() <= (this.cityPrice)/10){
					System.out.println("��Ÿ�����ϴ�.");					
				}
				else
				{
					System.out.println("���ø� �μ��� ��ŭ �ݾ��� �����ϰ� ���� �ʽ��ϴ�.");
				}
			}
		}
		if(cityStatus == 9){
			System.out.println("����� ��ĭ�Դϴ�. 9 ");


		}
	}
	//	�ش� City�� �������θ� Ȯ���ϰ� ����/�ܰ�Ȯ��/����� �ΰ����� �����ϴ� �Լ� ����




	// �ֻ����� ������ �� ���� ���ڰ� ������ ���� �̱�� ����
	int start;
	Scanner startGame = new Scanner(System.in);
	int playerNum;
	int comNum;
	int randomSelector;
	
	public void playDiceGame(Player player){
		System.out.println("�ֻ��� ������ �����մϴ�.");
		randomSelector = (int)(Math.random()*2) ;
		if (randomSelector == 0){
			highNumGame(player);
		}
		else if(randomSelector == 1){
			approximateGame(player);
		}
	}
	
	public void highNumGame(Player player){
		System.out.println("�ֻ����� ���� �� �������ڰ� ������ �̱�ϴ�.");
		System.out.println(">> �ֻ����� �������� Enter�� �����ּ���");
		scanner.nextLine();
		playerNum = ((int)Math.random()*6)+1;	// �÷��̾� �ֻ��� ��	
		comNum = ((int)Math.random()*6)+1;			// ��ǻ�� �ֻ��� ��
		// �� ����� �ֻ��� �� ��
		if (playerNum > comNum){
			System.out.println("�÷��̾ �� �������ڰ� ���ͼ� �¸��Ͽ����ϴ�.");
			player.myMoney = player.myMoney + this.cityPrice/10;
			System.out.println("���� ���� ��� : " + player.myMoney);
		}
		else if (playerNum <= comNum){
			System.out.println("��ǻ�Ͱ� �� �������ڰ� ���ͼ� �÷��̾�� �й��Ͽ����ϴ�.");
			player.myMoney = player.myMoney - this.cityPrice/10;
			System.out.println("���� ���� ��� : " + player.myMoney);			
		}
//		else if (playerNum == comNum){
//			System.out.println("���� ���ڰ� ���Խ��ϴ�. �ֻ����� �ٽ� �����ּ���.");
//			highNumGame(player);
//		}
	}
	// �ֻ����� ������ �� ���� ���ڰ� ������ ���� �̱�� ���� ����


	int basicNum;
	int playerResult;
	int comResult;
	
	//		�λ�� �߿��� ���ذ����� �� �ٻ簪�� ������ ����� �̱�� �Լ�	
	public void approximateGame(Player player){
		System.out.println("�ֻ����� ���� ���ذ����� �ٻ��� ���ڰ� ������ ����� �¸��մϴ�.");
		System.out.println(">> �ֻ����� �������� Enter�� �����ּ���");
		scanner.nextLine();
		basicNum = ((int)Math.random()*6)+1;		// �񱳱����� �Ǵ� �ֻ�����
		playerNum = ((int)Math.random()*6)+1;		// �÷��̾� �ֻ��� ��	
		comNum = ((int)Math.random()*6)+1;	
		playerResult = (int)(Math.pow((playerNum-basicNum),2));
		comResult = (int)(Math.pow((comNum-basicNum),2));

		// �� ����� �ֻ��� �� ��
		if (playerResult < comResult){
			System.out.println("�÷��̾ �� �ٻ��Ѱ��� ���ͼ� �¸��Ͽ����ϴ�.");
			player.myMoney = player.myMoney + this.cityPrice/10;
			System.out.println("���� ���� ��� : " + player.myMoney);
		}
		else if (playerResult >= comResult){
			System.out.println("��ǻ�Ͱ� �� �ٻ��Ѱ��� ���ͼ� �÷��̾�� �й��Ͽ����ϴ�.");
			player.myMoney = player.myMoney - this.cityPrice/10;
			System.out.println("���� ���� ��� : " + player.myMoney);			
		}
//		else if (playerResult == comResult){
//			System.out.println("���� ���ڰ� ���Խ��ϴ�. �ֻ����� �ٽ� �����ּ���.");
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
