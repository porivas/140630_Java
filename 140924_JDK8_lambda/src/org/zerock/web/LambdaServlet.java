package org.zerock.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Lambda expression 
 * use for servlet action 
 * 
 * @author Zerock
 *
 */
@FunctionalInterface
public interface LambdaServlet {
	
	String WEB_INF ="/WEB-INF/views/";
	
	public ResponseResult execute(HttpServletRequest req, HttpServletResponse res)throws Exception;
	
	/**
	 * to determine redirect or forward
	 * use ResponseResult 
	 * 
	 * @param req HttpServletRequest
	 * @param res HttpServletResponse
	 * @throws Exception
	 */
	public default void process(HttpServletRequest req, HttpServletResponse res)throws Exception{
		
		ResponseResult result = execute(req, res);
		
		if(result.getForward() == false){
			res.sendRedirect(result.getNextPage());
			return;
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(WEB_INF+result.getNextPage());
		dispatcher.forward(req, res);
	}
}
