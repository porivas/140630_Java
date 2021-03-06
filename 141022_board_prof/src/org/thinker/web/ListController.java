package org.thinker.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thinker.bbs.BbsVO;
import org.thinker.common.Criteria;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		
		try{
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e){
			page = 1;
		}
		
		int total  = 352;
		
		System.out.println("PAGE: "+page);
		System.out.println("TOTAL: " +total);
		
		List<BbsVO> list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++){
			
			BbsVO vo = new BbsVO();
			vo.setBno(i);
			vo.setTitle("AAAAA");
			list.add(vo);
		}
		
		request.setAttribute("list", list);
		
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setKeyword(request.getParameter("keyword"));
		
		cri.setTypes(request.getParameterValues("types"));
		
		
		System.out.println("---------------");
		System.out.println(cri);
		System.out.println("---------------");
		
		
		cri.setTotal(total);
		
		request.setAttribute("cri", cri);
		
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		
	}


}
