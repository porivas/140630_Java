package date20140808_Salary_Interface;

public class MonthlyEmployee extends IrregularEmployee {
	
	int monthlyPay;
	double incomeTax;
	
	
	
	public MonthlyEmployee() {
		super();
		this.monthlyPay = 3500000;
		this.incomeTax =  0.035;
	}

	@Override
	public int calcMonthlySalary() {
		// TODO Auto-generated method stub
		super.monthlySalary = (int)(this.monthlyPay - this.monthlyPay*this.incomeTax);
		
		return super.monthlySalary;
	}


	

}
