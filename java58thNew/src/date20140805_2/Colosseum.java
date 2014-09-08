package date20140805_2;
import java.util.Scanner;

public class Colosseum {
	
	private Scanner scanner;
	private MonsterManager manager;
	
	public Colosseum(){
		scanner = new Scanner(System.in);
		manager = new MonsterManager();
	}
	
	
	public Player makePlayer(){
		System.out.println("�÷��̾��� �̸��� �Է��ϼ���");
		String name = scanner.nextLine();
		
		Weapon weapon = new Weapon("sword",6,4);
		
		Player player = new Player(name, weapon);
		
		return player;
		
	}
	
	public void startGame(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~Bit Colosseum~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Start Your Game!!!! Uhaaaaa");
		Player player = this.makePlayer();
		battle(player);
		
	}
	
	public void battle(Player player){
		
		System.out.println("Fight! Monster!");
		
		Monster monster = manager.getNextMonster();
		
		System.out.println(monster);
		
		if(monster == null){
			System.out.println("��������");
			return;
		}
		
		while (true){
			System.out.println("�����ϼ���");
			scanner.nextLine();
			int attackAmount = player.attack();
			
			int monsterHP = monster.damage(attackAmount);
			
			if(monsterHP <= 0){
				System.out.println("�������� ��Ƴ��� ������!!!");
				break;
			}
		}//end while
		
		battle(player);
		
	}

}





