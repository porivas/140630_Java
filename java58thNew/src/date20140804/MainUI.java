package date20140804;

import java.util.Scanner;

public class MainUI {
	// ��ӻ���ϴ� ���� 
	private Scanner sc;
	private int turn;
	private int mobNum;
	private int cashTotal;
	private String realName;
	private String phoneNum;
	private String name;
	private String weaponName;
	private Weapon userWeapon;
	private Weapon initMonWP;
	private Player player1;
	private Monster[] arr;

	// ��ӻ���ϴ� ������ �ʱ�ȭ (������)
	public MainUI(){
		sc = new Scanner(System.in);
		turn = 0;
		mobNum = 10;
		cashTotal = 0;
		// �������� num�� ������ �� ���� & 1~num ������ ����, ������ ���Ŀ� ���
		Monster.num = mobNum;
	}

	// �������
	public void registerUser() throws Exception, Exception, Exception{
		System.out.println("[ȸ������]");
		System.out.println("�Ǹ��� �Է��ϼ���");
		realName = sc.nextLine();
		System.out.println("�޴��� ��ȣ�� �Է��ϼ���");
		phoneNum = sc.nextLine();
		System.out.println("�г����� �Է��ϼ���");
		name = sc.nextLine();
		System.out.println("ù ����� '�ܰ�' �Դϴ�.");
		weaponName = "date20140804." + "Sword";
		userWeapon = 
				(Weapon)Class.forName(weaponName).newInstance();
	}

	// ��������
	public void makeEveryUser(){

		initMonWP = new MonsterWeapon();

		player1 = new Player(name, userWeapon);
		//      Player player2 = new Player("����", new Sword());
		arr = new Monster[Monster.num];
	}

	// ���ⱸ�� & ��ȯ
	public void swapWeapon() throws Exception, Exception, Exception{
		System.out.println("[ĳ������]\n1. ����(1~19) 3,000�� 2. â(5~21) 3,500�� \n3. ��(0 or �ѹ�) 19,900�� 4. ������ �����ϴ�.\n");
		int selection2 = sc.nextInt();
		switch(selection2){
		case 1:
			System.out.println("���⸦ ��ü�մϴ�.");
			weaponName = "date20140804.Axe";
			userWeapon = (Weapon)Class.forName(weaponName).newInstance();
			player1.playerWeapon = userWeapon;
			cashTotal += 3000;
			break;
		case 2:
			System.out.println("���⸦ ��ü�մϴ�.");
			weaponName = "date20140804.Spear";
			userWeapon = (Weapon)Class.forName(weaponName).newInstance();
			player1.playerWeapon = userWeapon;
			cashTotal += 3500;
			break;
		case 3:
			System.out.println("���⸦ ��ü�մϴ�.");
			weaponName = "date20140804.Gun";
			userWeapon = (Weapon)Class.forName(weaponName).newInstance();
			player1.playerWeapon = userWeapon;
			cashTotal += 19900;
			break;
		case 4:
			System.out.println("���⸦ �������� �ʽ��ϴ�.");
			break;
		}	
	}

	// �������� 
	public void battleStart() throws Exception, Exception, Exception{

		label:     
			for (int i = 0; i < arr.length; i++) {
				Monster.num = i+1;
				arr[i] = new Monster("����", initMonWP);
				System.out.println("���� �����߽��ϴ�!!");
				System.out.println("���̸�: " + arr[i].name+" hp: "+arr[i].hp);
				while (true) {
					Monster player2 = arr[i];
					Player attackPlayer, damaPlayer = null;

					if (turn % 2 == 0) {
						attackPlayer = player1;
						damaPlayer = player2;
						System.out.println(attackPlayer.name + "�� Enter�� ������ ������ �������ϴ�");
						if (attackPlayer.hp <= 20 && attackPlayer.hp > 10) {
							System.out.println("�ʻ�� ����� ���Ͻø� y�� �Է��ϼ���.");
							String choice = sc.nextLine();
							if (choice.equals("y")) {
								System.out.println("�ʻ�� ���ϴ�");
								damaPlayer.damage(attackPlayer.fatalAttack());
							} else {
								System.out.println("�Ϲݰ���...");
								int attackAmount = attackPlayer.attack();
								damaPlayer.damage(attackAmount);
							}
						} else {
							sc.nextLine();
							System.out.println(attackPlayer.name +" �Ϲݰ����� �մϴ�.");
							int attackAmount = attackPlayer.attack();
							damaPlayer.damage(attackAmount);
						}
						System.out.println(attackPlayer.name + " : " + attackPlayer.hp);
						System.out.println(" " + damaPlayer.name + " : " + damaPlayer.hp);
					} else {
						attackPlayer = player2;
						damaPlayer = player1;
						if (attackPlayer.hp <= 25 && attackPlayer.hp >= 10) {
							damaPlayer.damage(attackPlayer.fatalAttack1());
						} else {
							System.out.println(attackPlayer.name +" �ݰ��� �մϴ�.");
							int attackAmount = attackPlayer.attack();
							damaPlayer.damage(attackAmount);
						}
						System.out.println(attackPlayer.name + " : " + attackPlayer.hp);
						System.out.println(" " + damaPlayer.name + " : " + damaPlayer.hp);

					}

					if (player1.hp <= 0) {
						System.out.println(player1.name + "�� �׾����ϴ�. ĳ���� �����ϼ���.");
						System.out.println("1.500�� 20hp 2. 1000�� 50hp 3. 1500�� 100hp 4.��������");
						int selection = sc.nextInt();
						switch(selection){
						case 1:
							player1.hp = 20;
							cashTotal += 500;
							swapWeapon();
							continue;
						case 2:
							player1.hp = 50;
							cashTotal += 1000;
							swapWeapon();
							continue;
						case 3:
							player1.hp = 100;
							cashTotal += 1500;
							swapWeapon();
							continue;
						case 4:
							System.out.println("������ �����߽��ϴ�.");
							System.out.println("�� �����ݾ�: "+cashTotal+"�� �Դϴ�.");
							System.out.println("������ "+realName+"�� "+phoneNum+"��ȣ ������� û���� �����Դϴ�.");
							break label;
						}
					}

					if (damaPlayer.hp <= 0) {
						System.out.println(attackPlayer.name + "�� �¸�");
						System.out.println(damaPlayer.name + "�� �й�");
						player1.hp += (Monster.num*10)/2; // HP�� �ݰ��� ȸ��
						System.out.println("���� ����� HP�� �ݰ��� ȸ��: "+(Monster.num*10)/2+"��ŭ ȸ���߽��ϴ�.");
						if (player1.hp >= 100){
							player1.hp = 100;
							System.out.println("HP�� 100������ ȸ���� �� �ֽ��ϴ�.");
						}
						break;
					}
					turn++;

				}
			}
	}
	
	//Ÿ��Ʋ �ο� �ý���: ĳ�� ���� �ݾ׿� ���� �ο�
	public void titleMake(int cashTotal){
		if(cashTotal>= 10000){
			if (cashTotal>= 50000){
				name = "ȣ��ŷ "+name;
			}
			else if (cashTotal>= 30000){
				name = "�������� �Ǿ���� "+name;
			}
			else if (cashTotal>= 20000){
				name = "�������� ������ "+name;
			}
			else{
				name = "�������� �������� "+name;
			}
			System.out.println("���������ݾ� "+cashTotal+"���� �޼��Ͽ� Īȣ�� ȹ���ϼ̽��ϴ�!");
			System.out.println("�������� ����� �̸��� "+name+"�Դϴ�.");
		}
	}

	//���� Ŭ����� �޼��� ���
	public void endingOfGame(){
		System.out.println(name+"�� �¸��߽��ϴ�. �⻵�ϼ���!");
		System.out.println("�� �����ݾ�: "+cashTotal+"�� �Դϴ�.");
		titleMake(cashTotal);
		System.out.println("������ "+realName+"�� "+phoneNum+"��ȣ ������� û���� �����Դϴ�.");
		System.out.println("�� ��ġ ���ڴ� "+mobNum+"���� �Դϴ�.");
	}
	
	//���� ���� ����
	public void startGame() throws Exception{
		registerUser();
		makeEveryUser();
		battleStart();
		endingOfGame();
	}


}


