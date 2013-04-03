package service.management;

import model.management.BoParameter;
import model.system.BoPerson;

import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import util.hibernate.HibernateSessionFactory;
import dao.management.BoParameterDao;
import org.hibernate.Session;
import util.hibernate.HibernateSessionFactory;
import exception.BoException;
import factory.DaoFactory;

public class BoParameterService {
	
	private BoParameterDao boParameterDao;

	public BoParameterService()throws BoException
	{
		try
		{
			boParameterDao = (BoParameterDao)DaoFactory.instance().getDao("boParameterDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("��ʼ��ҵ���߼���������쳣...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int updateBoParameter(BoParameter n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boParameterDao.updateBoParameter(n,session);
		} catch (HibernateException e) {
				result = 0;	
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
    public BoParameter getBoParameter(String id) throws BoException {
		BoParameter m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boParameterDao.hasBoParameter(id,session)){
			m = boParameterDao.getBoParameter(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		} 
		return m;
	}
    
    public boolean hasBoParameter(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boParameterDao.hasBoParameter(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has��ѯʧ�ܣ�");
		} 
    }
    
}
