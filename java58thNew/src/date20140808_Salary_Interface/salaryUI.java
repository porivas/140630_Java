package date20140808_Salary_Interface;

public class salaryUI {
	
	EmployeeManager mgr1;	
	
	public salaryUI(){
		mgr1 = new EmployeeManager();
		for (int i = 0; i < mgr1.employee.length; i++) {
			System.out.println(mgr1.employee[i].typeOfHiring);
			System.out.println("ПљБо");
			System.out.println(mgr1.employee[i].calcMonthlySalary());
		}
	}
	
	
	
	
}
