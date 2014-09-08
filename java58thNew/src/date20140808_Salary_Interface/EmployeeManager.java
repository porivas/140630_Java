package date20140808_Salary_Interface;

public class EmployeeManager {
	
	Employee[] employee = new Employee[3];
	
	public EmployeeManager(){
		employee[0] = new RegularEmployee();
		employee[1] = new MonthlyEmployee();
		employee[2] = new DailyEmployee();
	}
	

	
}
