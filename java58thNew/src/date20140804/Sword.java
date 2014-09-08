package date20140804;

public class Sword extends Weapon {

	   @Override
	   public int getAttackDamage() {
	      // TODO Auto-generated method stub
	      return 5 + (int)(Math.random()*3);
	   }

	}