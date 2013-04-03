package util.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;

import util.constants.ConstantsUtil;
import factory.DaoFactory;
import factory.ServiceFactory;


public class FactoryLoaderListener implements ServletContextListener
{ 
	DaoFactory df = null;
	ServiceFactory sf = null;
	SessionFactory ssf = null;

	
    public void contextInitialized(ServletContextEvent sce)
    {
		ConstantsUtil.realPath = sce.getServletContext().getRealPath("/WEB-INF/config");
		
		try
		{
			ssf = HibernateSessionFactory.getSessionFactory();
			//System.out.println("Hibernate的SessionFactory已经被初始化... " + ssf);	
		}
		catch (Exception e)
		{
			//System.out.println("初始化SessionFactory工厂时出现异常" + e);
		}
		
		
		try
		{
			df = DaoFactory.instance();
			//System.out.println("DAO工厂已经被初始化... " + df);

		}
		catch (Exception e)
		{
			//System.out.println("初始化DAO工厂时出现异常" + e);
		}
		
		
		try
		{
			sf = ServiceFactory.instance();
			//System.out.println("Service工厂已经被初始化... " + sf);
		}
		catch (Exception e)
		{
			//System.out.println("初始化Service工厂时出现异常" + e);
		}
    } 
    
    public void contextDestroyed(ServletContextEvent sce)
    {
    	ssf = null;
		df = null;
		sf = null;

    } 
} 