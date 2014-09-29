/**
 * 인터페이스 구현 
 */

package org.han.web;

import javax.servlet.http.HttpServletResponse;

// jdk8 버전부터는 메소드를 인터페이스에 구현할 수 있다. 
public interface Executor {
	public void execute(MyRequest req, HttpServletResponse res) throws Exception;
	
}
