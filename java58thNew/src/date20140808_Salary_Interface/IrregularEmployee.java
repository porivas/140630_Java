package date20140808_Salary_Interface;

public abstract class IrregularEmployee extends Employee {

	public IrregularEmployee() {
		super();
		typeOfHiring = "��������";
	}

	@Override
	public abstract int calcMonthlySalary();
	
}
