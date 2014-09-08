package date20140804;

public class Gun extends Weapon {

	@Override
	public int getAttackDamage() {
		// TODO Auto-generated method stub
		int shuffle = (int)(Math.random()*2);
		return shuffle*99999;
	}

}
