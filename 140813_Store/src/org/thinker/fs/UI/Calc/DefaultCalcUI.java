package org.thinker.fs.UI.Calc;

import org.thinker.fs.UI.AbstractUI;

public abstract class DefaultCalcUI extends AbstractUI {

	double val1;
	double val2;
	String val3;

	public DefaultCalcUI() {
		super();
	}

	public void defaultCalcUI() {
		System.out.println("����� �����մϴ�.");
		System.out.print("ù ��° �� �Է����ּ���: ");
		val1 = scanner.nextDouble();
		System.out.println(val1+" �Է��ϼ̽��ϴ�.");
		System.out.print("�� ��° �� �Է����ּ���: ");
		val2 = scanner.nextDouble();
		System.out.println(val2+" �Է��ϼ̽��ϴ�.");
		System.out.println("=== ����� ===");
	}

}