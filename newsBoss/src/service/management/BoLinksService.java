package service.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.management.BoLinks;

import model.system.BoPerson;
import model.system.PageList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.management.BoLinksDao;
import util.hibernate.HibernateSessionFactory;

import exception.BoException;
import factory.DaoFactory;

public class BoLinksService {
	/**
	 * @author WangZ
	 * 
	 */
	private BoLinksDao boLinksDao;

	public BoLinksService()throws BoException
	{
		try
		{
			boLinksDao = (BoLinksDao)DaoFactory.instance().getDao("boLinksDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("��ʼ��ҵ���߼���������쳣...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	/**
	 * @author WZ
	 * �����µ�����
	 */
    public int addBoLinks(BoLinks n) throws BoException{
    
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boLinksDao.addBoLinks(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    /**
     *@author WZ
     * �������� ���ɹ��򷵻�1��ʧ�ܷ���0
     * @throws BoException
     */
    public int updateBoLinks(BoLinks n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boLinksDao.updateBoLinks(n,session);
		} catch (HibernateException e) {			
			result = 0;			
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
    public int  deleteBoLinks(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boLinksDao.hasBoLinks(id,session)){
			boLinksDao.deleteBoLinks(id,session);
			}
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("ɾ������ʧ�ܣ�");
		} 
		return result;
	}
    
    public BoLinks getBoLinks(String id) throws BoException {
		BoLinks m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boLinksDao.hasBoLinks(id,session)){
			m = boLinksDao.getBoLinks(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		}
		return m;
	}
    
    public boolean hasBoLinks(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boLinksDao.hasBoLinks(id, session);
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has��ѯʧ�ܣ�");
		} 
    	return result;

    }
    
	public Map getBoLinksMap(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boLinksDao.getBoLinksNum( session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boLinksDao.getBoLinksList(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ҳ��ѯʧ�ܣ�");
		}
		return map;
	}
	public List getAllBoLinks()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boLinksDao.getAllBoLinks(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("ȫ����ѯʧ�ܣ�");
		} 
		return result;
	}
    
    
    

	public static void main(String[] args) throws Exception{
		
	}
	

}
