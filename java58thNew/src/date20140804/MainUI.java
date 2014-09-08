package date20140804;

import java.util.Scanner;

public class MainUI {
	// 계속사용하는 변수 
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

	// 계속사용하는 변수의 초기화 (생성자)
	public MainUI(){
		sc = new Scanner(System.in);
		turn = 0;
		mobNum = 10;
		cashTotal = 0;
		// 전역변수 num은 몬스터의 총 숫자 & 1~num 까지의 레벨, 데미지 공식에 사용
		Monster.num = mobNum;
	}

	// 유저등록
	public void registerUser() throws Exception, Exception, Exception{
		System.out.println("[회원가입]");
		System.out.println("실명을 입력하세요");
		realName = sc.nextLine();
		System.out.println("휴대폰 번호를 입력하세요");
		phoneNum = sc.nextLine();
		System.out.println("닉네임을 입력하세요");
		name = sc.nextLine();
		System.out.println("첫 무기는 '단검' 입니다.");
		weaponName = "date20140804." + "Sword";
		userWeapon = 
				(Weapon)Class.forName(weaponName).newInstance();
	}

	// 유저생성
	public void makeEveryUser(){

		initMonWP = new MonsterWeapon();

		player1 = new Player(name, userWeapon);
		//      Player player2 = new Player("몬스터", new Sword());
		arr = new Monster[Monster.num];
	}

	// 무기구매 & 교환
	public void swapWeapon() throws Exception, Exception, Exception{
		System.out.println("[캐쉬상점]\n1. 도끼(1~19) 3,000원 2. 창(5~21) 3,500원 \n3. 총(0 or 한방) 19,900원 4. 상점을 나갑니다.\n");
		int selection2 = sc.nextInt();
		switch(selection2){
		case 1:
			System.out.println("무기를 교체합니다.");
			weaponName = "date20140804.Axe";
			userWeapon = (Weapon)Class.forName(weaponName).newInstance();
			player1.playerWeapon = userWeapon;
			cashTotal += 3000;
			break;
		case 2:
			System.out.println("무기를 교체합니다.");
			weaponName = "date20140804.Spear";
			userWeapon = (Weapon)Class.forName(weaponName).newInstance();
			player1.playerWeapon = userWeapon;
			cashTotal += 3500;
			break;
		case 3:
			System.out.println("무기를 교체합니다.");
			weaponName = "date20140804.Gun";
			userWeapon = (Weapon)Class.forName(weaponName).newInstance();
			player1.playerWeapon = userWeapon;
			cashTotal += 19900;
			break;
		case 4:
			System.out.println("무기를 구매하지 않습니다.");
			break;
		}	
	}

	// 전투시작 
	public void battleStart() throws Exception, Exception, Exception{

		label:     
			for (int i = 0; i < arr.length; i++) {
				Monster.num = i+1;
				arr[i] = new Monster("몬스터", initMonWP);
				System.out.println("적이 등장했습니다!!");
				System.out.println("적이름: " + arr[i].name+" hp: "+arr[i].hp);
				while (true) {
					Monster player2 = arr[i];
					Player attackPlayer, damaPlayer = null;

					if (turn % 2 == 0) {
						attackPlayer = player1;
						damaPlayer = player2;
						System.out.println(attackPlayer.name + "님 Enter를 누르면 공격을 시작힙니다");
						if (attackPlayer.hp <= 20 && attackPlayer.hp > 10) {
							System.out.println("필살기 사용을 원하시면 y를 입력하세요.");
							String choice = sc.nextLine();
							if (choice.equals("y")) {
								System.out.println("필살기 갑니다");
								damaPlayer.damage(attackPlayer.fatalAttack());
							} else {
								System.out.println("일반공격...");
								int attackAmount = attackPlayer.attack();
								damaPlayer.damage(attackAmount);
							}
						} else {
							sc.nextLine();
							System.out.println(attackPlayer.name +" 일반공격을 합니다.");
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
							System.out.println(attackPlayer.name +" 반격을 합니다.");
							int attackAmount = attackPlayer.attack();
							damaPlayer.damage(attackAmount);
						}
						System.out.println(attackPlayer.name + " : " + attackPlayer.hp);
						System.out.println(" " + damaPlayer.name + " : " + damaPlayer.hp);

					}

					if (player1.hp <= 0) {
						System.out.println(player1.name + "님 죽었습니다. 캐쉬를 결제하세요.");
						System.out.println("1.500원 20hp 2. 1000원 50hp 3. 1500원 100hp 4.게임종료");
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
							System.out.println("게임을 종료했습니다.");
							System.out.println("총 결제금액: "+cashTotal+"원 입니다.");
							System.out.println("다음달 "+realName+"님 "+phoneNum+"번호 요금으로 청구될 예정입니다.");
							break label;
						}
					}

					if (damaPlayer.hp <= 0) {
						System.out.println(attackPlayer.name + "님 승리");
						System.out.println(damaPlayer.name + "님 패배");
						player1.hp += (Monster.num*10)/2; // HP의 반값을 회복
						System.out.println("죽인 상대의 HP의 반값을 회복: "+(Monster.num*10)/2+"만큼 회복했습니다.");
						if (player1.hp >= 100){
							player1.hp = 100;
							System.out.println("HP는 100까지만 회복할 수 있습니다.");
						}
						break;
					}
					turn++;

				}
			}
	}
	
	//타이틀 부여 시스템: 캐쉬 결제 금액에 따라서 부여
	public void titleMake(int cashTotal){
		if(cashTotal>= 10000){
			if (cashTotal>= 50000){
				name = "호구킹 "+name;
			}
			else if (cashTotal>= 30000){
				name = "지름신이 되어버린 "+name;
			}
			else if (cashTotal>= 20000){
				name = "지름신을 영접한 "+name;
			}
			else{
				name = "지름신을 만날뻔한 "+name;
			}
			System.out.println("최종결제금액 "+cashTotal+"원을 달성하여 칭호를 획득하셨습니다!");
			System.out.println("이제부터 당신의 이름은 "+name+"입니다.");
		}
	}

	//게임 클리어시 메세지 출력
	public void endingOfGame(){
		System.out.println(name+"님 승리했습니다. 기뻐하세요!");
		System.out.println("총 결제금액: "+cashTotal+"원 입니다.");
		titleMake(cashTotal);
		System.out.println("다음달 "+realName+"님 "+phoneNum+"번호 요금으로 청구될 예정입니다.");
		System.out.println("적 퇴치 숫자는 "+mobNum+"마리 입니다.");
	}
	
	//게임 진행 로직
	public void startGame() throws Exception{
		registerUser();
		makeEveryUser();
		battleStart();
		endingOfGame();
	}


}


