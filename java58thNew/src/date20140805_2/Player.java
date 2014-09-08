package date20140805_2;

public class Player {
	
	private String name;
	private int hp = 100;
	private Weapon weapon;
	
	public Player(String name, Weapon weapon) {
		super();
		this.name = name;
		this.weapon = weapon;
	}
	
	public int attack(){
		return weapon.attackPoint();
	}

	public String toString() {
		return "Player [name=" + name + ", hp=" + hp + ", weapon=" + weapon
				+ "]";
	}
	
	

}
