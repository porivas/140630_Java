package org.thinker.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doA")
public class AServlet extends AbstractServlet {

	@Override
	public String findNextPage(HttpServletRequest request,
			HttpServletResponse response) {
		String method = request.getMethod();
		
		String nextPage = "";
		switch (method) {
		case "GET":
			nextPage = "/a.jsp";
			break;

		default:
			nextPage = "/b.jsp";
			break;
		}
		return nextPage;
	}

}













