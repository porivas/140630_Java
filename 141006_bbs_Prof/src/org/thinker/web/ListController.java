package org.thinker.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thinker.web.util.Criteria;
import org.thinker.web.util.SimpleCriteria;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Criteria cri = new SimpleCriteria(
				request.getParameter("page"),
				request.getParameterValues("types"),
				request.getParameter("keyword"));
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		
	}

}
