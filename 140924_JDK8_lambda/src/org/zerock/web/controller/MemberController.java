package org.zerock.web.controller;

import javax.servlet.annotation.WebServlet;

import org.zerock.dao.MemberDAO;
import org.zerock.sevice.GenericService;
import org.zerock.vo.MemberVO;
import org.zerock.web.AbstractController;
import org.zerock.web.ResponseResult;





/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member/*")
public class MemberController extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void readyMap() throws Exception {
		// TODO Auto-generated method stub
		servletMap.put("/regist", (req, res) -> {
			
			System.out.println("regist.... called");
			 
		return new ResponseResult("member/regist.jsp");});
		
		
		servletMap.put("/registPost", (req, res) -> {
			
			System.out.println("registPost.... called");
			
			MemberVO vo = new MemberVO(req.getParameter("id"),req.getParameter("pw"),req.getParameter("name"),req.getParameter("email"));

			GenericService.regist(vo, (v) -> {
					MemberDAO.create(vo);
			});			
			
			 
		return new ResponseResult("member/result.jsp");});
		
		
	}

}
