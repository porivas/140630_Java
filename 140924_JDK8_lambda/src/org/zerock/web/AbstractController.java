package org.zerock.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * HttpServlet을 상속하고, 실제적인 동작을 가지는 추상 클래스 
 * 
 * @author Zerock
 *
 */
public abstract class AbstractController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected Map<String, LambdaServlet> servletMap;
	protected static Logger logger = LoggerFactory.getLogger("controller");
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.servletMap = new HashMap<String, LambdaServlet>();
		try {
			readyMap();
		} catch (Exception e) {
			logger.error(Arrays.toString(e.getStackTrace()));
			//use only for debug
			e.printStackTrace();
		}
	}
	/**
	 * 사용자가 원하는 작업을 Map으로 등록해서 사용한다. 
	 * @throws Exception
	 */
	protected abstract void readyMap()throws Exception;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		
		try{
			// /sample/doA
			LambdaServlet lambdaServlet = servletMap.get(getPath(req));
			
			logger.info(lambdaServlet.toString());
			
			lambdaServlet.process(req, res);
			
		}catch(Exception e){
			//use only for debug
			e.printStackTrace();
		}
	}
	
	protected String getPath(HttpServletRequest req){
		
		String path = req.getRequestURI(); //req.getServletPath();
		
		path = path.substring(req.getContextPath().length());
		
		logger.debug("origin---------------------");
		logger.debug(path);
		logger.debug("origin---------------------");
		
		WebServlet anno = this.getClass().getAnnotation(WebServlet.class);
		
		String annoPath  = anno.value()[0];
		
		logger.debug(annoPath);
		
		if(anno != null){
			
			path = path.substring(annoPath.lastIndexOf("/"));
		}
		
		logger.debug(path);
		
		if(path.lastIndexOf(".") > 0){
			return path.substring(0, path.lastIndexOf("."));
		}
		
		logger.info(path);
		
		return path;
		
	}
	
}
















