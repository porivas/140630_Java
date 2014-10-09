package org.zerock.web.controller;

import javax.servlet.annotation.WebServlet;

import org.zerock.web.AbstractController;
import org.zerock.web.ResponseResult;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/sample/*")
public class SampleController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@Override
	protected void readyMap() throws Exception {
		
		servletMap.put("/", (req, res) -> new ResponseResult("hello.jsp"));
		
		//-------------------------------------------------------------
		
		servletMap.put("/doA", (req, res) -> {
			
			System.out.println("doA.... called");
			 
		return new ResponseResult("sample/hello.jsp");});
		
		//-------------------------------------------------------------
		
		servletMap.put("/doB", (req, res) -> {
			
			System.out.println("doB.... called");
			
		return new ResponseResult("sample/doB.jsp");});
		
		//-------------------------------------------------------------
		
		servletMap.put("/doC", (req, res) -> {
			
			System.out.println("doC.... called");
			
		return new ResponseResult("sample/doC.jsp");});		
		
	}
	

}
