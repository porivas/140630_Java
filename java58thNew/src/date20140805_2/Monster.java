package date20140805_2;

public class Monster {

	private int hp;
	int firePower;
	String name;

	public int getHp() {
		return hp;
	}

	public Monster setHp(int hp) {
		this.hp = hp;
		return this;
	}

	public int getFirePower() {
		return firePower;
	}

	public Monster setFirePower(int firePower) {
		this.firePower = firePower;
		return this;
	}

	public String getName() {
		return name;
	}

	public Monster setName(String name) {
		this.name = name;
		return this;
	}

	public String toString() {
		return "Monster [hp=" + hp + ", firePower=" + firePower + ", name="
				+ name + "]";
	}

	public int damage(int attackAmount) {
		// TODO Auto-generated method stub
		this.hp = this.hp - attackAmount;
		return this.hp;
	}
	
}
