/**
 * ��ΰ� *.bit�� ���ͼ� /calc�̸� �����ϵ��� ����� ��. 
 */

package org.han.web;

import javax.servlet.http.HttpServletResponse;

@Controller(path="/calc")
public class CalcController  implements Executor{
	public CalcController(){
		System.out.println("CalcController");
	}

	@Override
	public void execute(MyRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyRequest : "+ req);
	}
}
