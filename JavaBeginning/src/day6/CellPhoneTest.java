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
		return "�𵨸�:"+name+" ������:"+company+" ����:"+power+" ī�޶�:"+camera;
		
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
		System.out.println("�𵨸�:"+cp.getName()+"����ȸ��:"+cp.getCompany()+"��������:"+cp.getPower());
		cp.power();
		System.out.println("�𵨸�:"+cp.getName()+"����ȸ��:"+cp.getCompany()+"��������:"+cp.getPower());
		CellPhone cp1 = new CellPhone("������s","�Ｚ","ȭ��Ʈ");
		CellPhone cp2 = new CellPhone("12-111","����Ѷ�","����",false,true);
		System.out.println(cp1);
		System.out.println(cp2);
	}

}