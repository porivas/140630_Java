/**
 * �������̽� ���� 
 */

package org.han.web;

import javax.servlet.http.HttpServletResponse;

// jdk8 �������ʹ� �޼ҵ带 �������̽��� ������ �� �ִ�. 
public interface Executor {
	public void execute(MyRequest req, HttpServletResponse res) throws Exception;
	
}
