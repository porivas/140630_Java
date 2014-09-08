package date20140808_Salary_Interface;

public abstract class IrregularEmployee extends Employee {

	public IrregularEmployee() {
		super();
		typeOfHiring = "비정규직";
	}

	@Override
	public abstract int calcMonthlySalary();
	
}
