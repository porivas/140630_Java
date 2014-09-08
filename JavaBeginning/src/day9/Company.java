package day9;

class Employee{
	protected String name;
	protected String idnum;
	protected String title;
	protected int salary;

	public Employee(String name, String idnum){
		this.name = name;
		this.idnum = idnum;
	}
	public void setSalary(int salary){
		this.salary = salary;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void work(){
		System.out.println(name+"��/�� ������ ���մϴ�.");
	}
}

class Manager extends Employee{
	String dept;
	Manager(String name, String idnum, String dept){
		super(name, idnum);
		this.dept = dept;
	}
	public void work(){
		System.out.println(name+"��/�� �ڽ��� �μ�������� "+dept+"���� ������ ���մϴ�.");
	}
	public void manage(){
		System.out.println("�ٹ��ڸ� �����մϴ�. ");
	}
}

public class Company {
	private Manager jmchoi, yckim;
	private Employee park, lee;
	protected Employee employees[];
	
	public Company(){
		jmchoi = new Manager("������","F99847","�繫��");
		yckim = new Manager("�迵ö", "F99832","���ߺ�");
		park = new Employee("�ھ�", "T99792");
		lee = new Employee("�̾�", "T94732");
		
		employees = new Employee[4];
		employees[0] = jmchoi;
		employees[1] = yckim;
		employees[2] = park;
		employees[3] = lee;
	}
	public void makeMoney(){
		int n = employees.length;
		for (int i =0; i<n; i++){
			employees[i].work();
			if (employees[i] instanceof Manager){
				((Manager)employees[i]).manage();
			}
		}
	}
	
	public static void main(String args[]){
		Company mycom = new Company();
		mycom.makeMoney();
		System.out.println("������ �߻��߽��ϴ�.");
	}

}
