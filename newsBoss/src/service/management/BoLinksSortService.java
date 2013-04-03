package service.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.management.BoLinks;
import model.management.BoLinksSort;

import model.system.BoPerson;
import model.system.PageList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.management.BoLinksDao;
import dao.management.BoLinksSortDao;
import util.hibernate.HibernateSessionFactory;

import exception.BoException;
import factory.DaoFactory;
import factory.ServiceFactory;

public class BoLinksSortService {
	/**
	 * @author WangZ
	 * 
	 */
	private BoLinksSortDao boLinksSortDao;

	public BoLinksSortService()throws BoException
	{
		try
		{
			boLinksSortDao = (BoLinksSortDao)DaoFactory.instance().getDao("boLinksSortDao");		
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
	 * �����µ��������
	 */
    public int addBoLinksSort(BoLinksSort n) throws BoException{
    
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boLinksSortDao.addBoLinksSort(n,session);
		} catch (HibernateException e) {			
			result = 0;			
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    /**
     *@author WZ
     * ����������� ���ɹ��򷵻�1��ʧ�ܷ���0
     * @throws BoException
     */
    public int updateBoLinksSort(BoLinksSort n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boLinksSortDao.updateBoLinksSort(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
    public int  deleteBoLinksSort(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boLinksSortDao.hasBoLinksSort(id,session)){
			boLinksSortDao.deleteBoLinksSort(id,session);
			}
			
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("ɾ������ʧ�ܣ�");
		} 
		return result;
	}
    
    public BoLinksSort getBoLinksSort(String id) throws BoException {
		BoLinksSort m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boLinksSortDao.hasBoLinksSort(id,session)){
			m = boLinksSortDao.getBoLinksSort(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		} 
		return m;
	}
    
    public boolean hasBoLinksSort(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boLinksSortDao.hasBoLinksSort(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has��ѯʧ�ܣ�");
		} 
    }
    
	public Map getBoLinksSortMap(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boLinksSortDao.getBoLinksSortNum( session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boLinksSortDao.getBoLinksSortList(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ҳ��ѯʧ�ܣ�");
		} 
		return map;
	}
	public List getAllBoLinksSort()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boLinksSortDao.getAllBoLinksSort(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("ȫ����ѯʧ�ܣ�");
		} 
		return result;
	}
	
    public Boolean isnull(){
    	try {
			session = HibernateSessionFactory.getSession();		

			int count =boLinksSortDao.getBoLinksSortNum(session);
			if(count>0)return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}   	
		return true;    	
    }
    
    public Boolean isthisnull(String sortid){
    	try {
			session = HibernateSessionFactory.getSession();		

			int count =boLinksSortDao.getthisBoLinksNum(sortid, session);
			if(count>0)return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} 	
		return true;    	
    }
    /**
     * @author WZ
     * ��ȡ�������е����ֵ
     */
    public int getMaxSerial(){
    	int count=-1;
    	try {
			session = HibernateSessionFactory.getSession();		

			 count =boLinksSortDao.getMaxSerial(session);
			return count;
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} 	
	return count;
    	
    }
    /**
     * ���������
     * @param id
     */
    public void moveUp(String id){
    	
    	try {
			session = HibernateSessionFactory.getSession();		
			 boLinksSortDao.moveUp(id, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} 	  	
    }
    /**
     * ���������
     * @param id
     */
    public void moveDown(String id){
    	
    	try {
			session = HibernateSessionFactory.getSession();		
			 boLinksSortDao.moveDown(id, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}   	  	
    }
    
    

	public static void main(String[] args) throws Exception{
	
		
	}
	

}
