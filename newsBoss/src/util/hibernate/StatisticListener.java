package util.hibernate;

import javax.servlet.*;
import javax.servlet.http.*;

import model.management.BoParameter;

import service.management.BoParameterService;
import factory.ServiceFactory;

import java.io.*;
import java.util.*;

public class StatisticListener extends HttpServlet implements
		ServletContextListener, ServletContextAttributeListener,
		HttpSessionListener, HttpSessionAttributeListener {
	
	private static int activeSessions = 0;

	public void contextInitialized(ServletContextEvent sce) {
		try {
			BoParameterService boParameterService = (BoParameterService)ServiceFactory.instance().getService("boParameterService");
			BoParameter p = boParameterService.getBoParameter("0");
			activeSessions = p.getGuestnumber();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			BoParameterService boParameterService = (BoParameterService)ServiceFactory.instance().getService("boParameterService");
			BoParameter p = boParameterService.getBoParameter("0");
			p.setGuestnumber(activeSessions);
			boParameterService.updateBoParameter(p);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void attributeAdded(ServletContextAttributeEvent scab) {

	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {

	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {

	}

	public void sessionCreated(HttpSessionEvent se) {
		
		activeSessions++;//每创建一个新的session就 加1 
		try {
			BoParameterService boParameterService = (BoParameterService)ServiceFactory.instance().getService("boParameterService");
			BoParameter p = boParameterService.getBoParameter("0");
			p.setGuestnumber(activeSessions);
			boParameterService.updateBoParameter(p);
			//System.out.println("activeSessions======="+activeSessions);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

	public void attributeAdded(HttpSessionBindingEvent se) {

	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

	public static int getActiveSessions() {
		return activeSessions;
	}

}
