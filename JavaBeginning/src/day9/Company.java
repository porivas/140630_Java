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
		System.out.println(name+"은/는 열심히 일합니다.");
	}
}

class Manager extends Employee{
	String dept;
	Manager(String name, String idnum, String dept){
		super(name, idnum);
		this.dept = dept;
	}
	public void work(){
		System.out.println(name+"은/는 자신의 부서직원들과 "+dept+"에서 열심히 일합니다.");
	}
	public void manage(){
		System.out.println("근무자를 관리합니다. ");
	}
}

public class Company {
	private Manager jmchoi, yckim;
	private Employee park, lee;
	protected Employee employees[];
	
	public Company(){
		jmchoi = new Manager("최종명","F99847","재무부");
		yckim = new Manager("김영철", "F99832","개발부");
		park = new Employee("박씨", "T99792");
		lee = new Employee("이씨", "T94732");
		
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
		System.out.println("수익이 발생했습니다.");
	}

}
