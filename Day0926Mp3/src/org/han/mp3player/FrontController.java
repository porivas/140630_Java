package org.han.mp3player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;

/**
 * Servlet implementation class ListController
 */
@WebServlet("*.han")
//이 경로를 타고 들어온다
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> map;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        map = new HashMap<>();
        map.put("/list.han","/WEB-INF/list.jsp");
        map.put("/listen.han","/WEB-INF/listen.jsp");
        map.put("/playFile.han","/WEB-INF/listen.jsp");
        //들어온 경로와 출력경로를 map으로 입력
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String path = req.getServletPath();
		//들어온 경로 추출
		System.out.println("path = " + path);
		
		if(path.equals("/playFile.han")){
			System.out.println("playFile로 진입");
			String filePath = req.getParameter("filePath");
			if(filePath == null){
				filePath = "c:\\zzz\\mp3\\";
			}
			res.setContentType("audio.mpeg");
			
			String fileName = req.getParameter("file");
			
			FileInputStream fin = new FileInputStream(filePath + fileName);
			System.out.println("재생파일경로 : " + filePath + fileName);
			ServletOutputStream fos = res.getOutputStream();
			
			byte[] buffer = new byte[1024*8];
			while(true){
				int count = fin.read(buffer);
				if(count == -1){
					break;
				}
				fos.write(buffer,0,count);
			}
			fin.close();
		}
		
		String nextPage = map.get(path);
		//출력경로 추출
		
		if(nextPage.equals("/WEB-INF/list.jsp")){
			
			String filePath = req.getParameter("filePath");
			if(filePath == null){
				filePath = "c:\\zzz\\mp3";
			}
			File file = new File(filePath);
			
			String[] mp3List = file.list();
			req.setAttribute("mp3List", mp3List);
		}
		//mp3리스트 페이지일 경우 파일리스트를 추출할 로직을 추가
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(nextPage);
		//RequestDispatcher로 이동경로를 받음
		System.out.println("다음페이지 : " + nextPage);
		dispatcher.forward(req, res);
		//forward로 다음 이동경로로 이동
	}
}