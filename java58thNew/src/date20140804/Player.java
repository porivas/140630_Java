package date20140804;




public class Player {

   // attribute
   int hp = 100;
   String name;
   Weapon playerWeapon;
  
   public Player(String name, Weapon weapon) {
      super();
      this.name = name;
      this.playerWeapon = weapon;
   }
   
   

   // function
   public int attack() {
      
      //캡슐화의 일종
      return this.playerWeapon.getAttackDamage();
      
   }

   public int fatalAttack() {
      int sum = 0;

      for (int i = 0; i < 3; i++){
   
         sum += this.attack();
      
      }
      
      this.hp -= 10;
      return sum;

   }
   public int fatalAttack1() {
	   	  int shuffleNum = (int)(Math.random()*10);
	      int sum= 0;
//   		  System.out.println("shuffleNum: "+shuffleNum+" Monster.num: "+Monster.num);
	   	  if (shuffleNum<Monster.num){
	   		  System.out.println("몬스터가 분노합니다!");
              System.out.println(this.name +" 필살기를 사용합니다.");
		      for (int i = 0; i < 3; i++){
		         sum += this.attack();
		      }
		      this.hp -= 10;
	   	  }
	   	  else{
	   		  System.out.println(this.name +" 반격을 합니다.");
	   	  }
	   	return sum;
	   }
   

   public void damage(int amount) {
      this.hp = this.hp - amount;

   }
}