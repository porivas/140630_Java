package day7;

class Gun{
	private int bullet;

	public Gun(int bullet)
	{
		this.bullet = bullet;
	}
	public void shut(){
		System.out.println("BBANG!");
		bullet--;
	}
}

public class Police {
	private int handcuffs;
	private Gun pistol;

	public Police(int bullet, int handcuffs){
		this.handcuffs = handcuffs;
		if (bullet>0)
			pistol = new Gun(bullet);
	}
	public void putHandcuff(){
		System.out.println("SNAP!");
		handcuffs--;		
	}
	public void shut(){
		if(pistol == null)
			System.out.println("Hut Bbang!");
		else
			pistol.shut();

	}
	public static void main(String[] args)
	{
		Police p1 = new Police(5,3);
		p1.shut();
		p1.putHandcuff();

		Police p2 = new Police(0,3);
		p2.shut();
		p2.putHandcuff();
	}


}
