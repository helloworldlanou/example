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
			//System.out.println("Hibernate��SessionFactory�Ѿ�����ʼ��... " + ssf);	
		}
		catch (Exception e)
		{
			//System.out.println("��ʼ��SessionFactory����ʱ�����쳣" + e);
		}
		
		
		try
		{
			df = DaoFactory.instance();
			//System.out.println("DAO�����Ѿ�����ʼ��... " + df);

		}
		catch (Exception e)
		{
			//System.out.println("��ʼ��DAO����ʱ�����쳣" + e);
		}
		
		
		try
		{
			sf = ServiceFactory.instance();
			//System.out.println("Service�����Ѿ�����ʼ��... " + sf);
		}
		catch (Exception e)
		{
			//System.out.println("��ʼ��Service����ʱ�����쳣" + e);
		}
    } 
    
    public void contextDestroyed(ServletContextEvent sce)
    {
    	ssf = null;
		df = null;
		sf = null;

    } 
} 