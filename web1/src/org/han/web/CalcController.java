/**
 * 경로가 *.bit로 들어와서 /calc이면 동작하도록 만드는 것. 
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
