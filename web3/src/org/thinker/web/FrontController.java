package org.thinker.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.bit")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map<String, Executor> map;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        map = new HashMap<>();
        map.put("/a.bit", new AController());
        map.put("/b.bit", new BController());
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getServletPath();
		
		Executor executor = map.get(path);
		
		try {
			String nextPage = executor.execute(request, response);
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}




















