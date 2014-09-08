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
		System.out.println("계산을 시작합니다.");
		System.out.print("첫 번째 값 입력해주세요: ");
		val1 = scanner.nextDouble();
		System.out.println(val1+" 입력하셨습니다.");
		System.out.print("두 번째 값 입력해주세요: ");
		val2 = scanner.nextDouble();
		System.out.println(val2+" 입력하셨습니다.");
		System.out.println("=== 계산결과 ===");
	}

}