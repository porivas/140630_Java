package date20140804;

public class MonsterWeapon extends Weapon {

	@Override
	public int getAttackDamage() {
		// TODO Auto-generated method stub
		return (int)(Math.random()*(5*Monster.num));
	}

}
