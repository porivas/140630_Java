package org.thinker.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thinker.dao.TimeDAO;
import org.thinker.service.TimeService;

/**
 * Servlet implementation class TimeController
 */
@WebServlet("/Time")
public class TimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 쓰레드에서 instance variable 사용하기. 
    private TimeService service;
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// 서블릿이 생성 될 때 한 번만 올라감. 
		service= (TimeService)config.getServletContext().getAttribute("timeService");
//		TimeService service= (TimeService)config.getServletContext().getAttribute("timeService");
//		TimeDAO dao = (TimeDAO)config.getServletContext().getAttribute("timeDAO");
//		service.setDao(dao);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setAttribute("time", service.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("time.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
