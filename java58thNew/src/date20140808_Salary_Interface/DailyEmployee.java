package date20140808_Salary_Interface;

public class DailyEmployee extends IrregularEmployee {
	int workDays;
	int dailyPay;
	
	public DailyEmployee() {
		super();
		this.workDays = 23;
		this.dailyPay = 50000;
	}
	@Override
	public int calcMonthlySalary() {
		// TODO Auto-generated method stub
		super.monthlySalary = dailyPay*workDays;
		return super.monthlySalary;
	}



}
