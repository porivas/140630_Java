package date20140808_Salary_Interface;

public class RegularEmployee extends Employee {
	
	int anualSalary;
	double bonusPercent;
	
	public RegularEmployee() {
		super();
		anualSalary = 50000000;
		bonusPercent = 4.0;
		typeOfHiring = "Á¤±ÔÁ÷"; 
	}
	@Override
	public int calcMonthlySalary() {
		// TODO Auto-generated method stub
		super.monthlySalary = (int)(this.anualSalary/12+this.anualSalary/12*this.bonusPercent/12);
		return super.monthlySalary;
	}
	


	
}
