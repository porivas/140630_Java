package date20140807;


import java.util.Scanner;


public class BoardStage {
	TileManager tileManager1 = new TileManager();
	int systemPlayerNum = 0;
	int turnCnt=0;
	Scanner scanner;
	private int diceNum;   
	private Player player;
	int trigger = 0;
	//�ֻ����� ������ ���
	public BoardStage() {  //������
		super();
		this.diceNum = 0;
		scanner = new Scanner(System.in);
	}
	public int getDicenum() {                                //�ֻ��� ���� ����e
		System.out.println("");
		return (int)(1+ Math.random()*6);
	}

	public Player makePlayer(Player player){                //�÷��̾� ����� ���
		player.setMyLocation(0);
		System.out.println("���ݳ���ġ��? "+ player.getMyLocation()); //Player.myLocation�� �־��ش�.

		player.setMyMoney(1000);  //�ʱⰪ
		System.out.println("���ݰ����ִ� ����?"+ player.getMyLocation()); //Player.myMoney�� �־��ش�.

		System.out.println("�̸��� �Է��ϼ���");
		scanner.nextLine();
		/*      player playerNum = 0;
      System.out.println("����� ���̵��?"+playerNum);

      Player player = new Player(myLocation, myMoney, myName);
		 */
		return player;

	}

	public void setPlayer(Player player){ //�÷��̾� �θ� ������ִ� ���
		makePlayer(player);
		player.setPlayerNum(systemPlayerNum);
		systemPlayerNum++;
	}
	


	public void startGame(){ //�÷��̾� 2�� �������.
		System.out.println("=================================");
		System.out.println("=========Game Start!!============");
		System.out.println("=================================");
		Player player1 = new Player("�÷��̾�1");
		Player player2 = new Player("�÷��̾�2");
		System.out.println("==========Player����==============");
		System.out.println(player1);
		System.out.println(player2);
		while (true) {
			failOrAlive(player1);
			failOrAlive(player2);
			if (turnCnt % 2 == 0){
				System.out.println("=================================");
				System.out.println(player1.myName+"�� �����Դϴ�.");
				tileManager1.goToNextTile(player1);
				turnCnt++;
			}
			else
			{
				System.out.println("=================================");
				System.out.println(player2.myName+"�� �����Դϴ�.");
				tileManager1.goToNextTile(player2);
				turnCnt++;
			}
		}

	}
	//�Ļ��ϴ� ���
	public void failOrAlive(Player player){

		if(player.getMyMoney() <= 0){  //���� ������
			System.out.println("�Ļ��ϼ̽��ϴ�.");
			String enter = scanner.nextLine();
			System.exit(0);
		}

	}
}