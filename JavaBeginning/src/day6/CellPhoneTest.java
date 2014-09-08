package day6;

class CellPhone {
	private String name;
	private String company;
	private String color;
	private boolean power = false;
	private boolean camera = false;
	public CellPhone(){}
	public CellPhone(String name, String company, String color){
		this(name, company, color, false, false);
	}
	public CellPhone(String name, String company, String color,boolean power, boolean camera){
		this.name = name;
		this.company = company;
		this.color = color;
		this.power = power;
		this.camera = camera;
	}

	public void setName(String n){
		name = n;
	}
	public void setCompany(String c){
		company = c;
	}
	public void setColor(String c){
		color = c;
	}
	public void setPower(boolean p){
		power = p;
	}
	public void setCamera(boolean c){
		camera = c;
	}
	public String getName(){
		return name;
	}
	public String getCompany(){
		return company;
	}
	public String getColor(){
		return color;
	}
	public boolean getPower(){
		return power;
	}
	public boolean getCamera(){
		return camera;
	}
	public void power(){
		if (power == false){
			power = true;
		}
		else
			power = false;
	}
	public String toString(){
		return "모델명:"+name+" 제조사:"+company+" 전원:"+power+" 카메라:"+camera;
		
	}
}

public class CellPhoneTest{
	public static void main (String[] args){
		CellPhone cp = new CellPhone();
		cp.setName("im-m460k");
		cp.setCompany("SKY");
		cp.setColor("pink");
		cp.setPower(false);
		cp.setCamera(true);
		System.out.println("모델명:"+cp.getName()+"제조회사:"+cp.getCompany()+"전원상태:"+cp.getPower());
		cp.power();
		System.out.println("모델명:"+cp.getName()+"제조회사:"+cp.getCompany()+"전원상태:"+cp.getPower());
		CellPhone cp1 = new CellPhone("갤럭시s","삼성","화이트");
		CellPhone cp2 = new CellPhone("12-111","모토롤라","검정",false,true);
		System.out.println(cp1);
		System.out.println(cp2);
	}

}