package org.professor.web;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequestByProfessor extends HttpServletRequestWrapper {

	private final HttpServletRequest req;
	
	public MyRequestByProfessor(HttpServletRequest request) throws UnsupportedEncodingException {
		super(request);
		this.req = request;
		req.setCharacterEncoding("UTF-8");
	}

	public double getDoubleParameter(String param){
		
		return Double.parseDouble(req.getParameter(param));
		
	}
	
	public int getIntParameter(String param){
		
		return Integer.parseInt(req.getParameter(param));
		
	}
	
	public Object makeObject(Class clz)throws Exception{
		
		Object obj = clz.newInstance();
		
		BeanInfo info = Introspector.getBeanInfo(clz);
		
		PropertyDescriptor[] pros = info.getPropertyDescriptors();
		
		for (PropertyDescriptor pro : pros) {
			Method setMethod = pro.getWriteMethod();
			if(setMethod == null){
				continue;
			}
			
			setMethod.invoke(obj, this.getParameter(pro.getName()));
		}
		
		return obj;
	}
}


















