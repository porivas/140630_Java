package org.thinker.fs.UI.Calc;

import org.thinker.fs.UI.AbstractUI;

public class MinusFunctionUI extends DefaultCalcUI {

	@Override
	public void doJob() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("»¬¼ÀÇÕ´Ï´Ù.");
		defaultCalcUI();
		System.out.println(val1-val2);
	}

}
