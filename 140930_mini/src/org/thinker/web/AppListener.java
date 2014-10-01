package org.thinker.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thinker.dao.TimeDAO;
import org.thinker.service.TimeService;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
	private static Logger logger = LoggerFactory.getLogger("AppListener");

    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }
    
    // �� ���ø����̼��� �ö� �� �ڵ����� �������� �κ� -> �̺�Ʈ��� �Ѵ�. 
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
    
    // �� ���ø����̼��� �ö� �� �ڵ����� ȣ��Ǵ� �κ� -> �̺�Ʈ��� �Ѵ�. 
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	// �� ���ø����̼��� �޸𸮿���/���. 
    	ServletContext ctx = event.getServletContext();
    	for (int i = 0; i < 10; i++) {
			logger.info("............." + i);
		}
    	
    	// �� ��ü�� �ó����� ó��, �� ���ø����̼��� ���ý�Ʈ, ��, �޸� �����ȿ��� ������ ���� �� ���� �����ȴ�. 
    	// �� �ϳ��� Singleton Pattern (�̱��� ����), �̱����� �ƴ����� �̱���ó�� ��밡��.
    	ctx.setAttribute("timeDAO", new TimeDAO());
    	
    	TimeService service = new TimeService();
    	service.setDao(new TimeDAO());
    	ctx.setAttribute("timeService", service);
//    	ctx.setAttribute("timeService", new TimeService());

    }
	
}