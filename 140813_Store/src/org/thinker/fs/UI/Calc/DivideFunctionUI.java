package org.thinker.fs.UI.Calc;

import org.thinker.fs.UI.AbstractUI;

public class DivideFunctionUI extends DefaultCalcUI {

	@Override
	public void doJob() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("������ �մϴ�.");
		defaultCalcUI();
		System.out.println(val1/val2);
	}

}
