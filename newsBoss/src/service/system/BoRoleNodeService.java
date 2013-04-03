package service.system;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernate.HibernateSessionFactory;

import dao.system.BoRoleNodeDao;
import exception.BoException;
import factory.DaoFactory;

import model.system.BoRoleNode;


public class BoRoleNodeService {
	
	private BoRoleNodeDao boRoleNodeDao;

	public BoRoleNodeService()throws BoException
	{
		try
		{
			boRoleNodeDao = (BoRoleNodeDao)DaoFactory.instance().getDao("boRoleNodeDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("��ʼ��ҵ���߼���������쳣...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoRoleNode(BoRoleNode n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boRoleNodeDao.addBoRoleNode(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
    
    
    public int updateBoRoleNode(BoRoleNode n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boRoleNodeDao.updateBoRoleNode(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
	public int  deleteBoRoleNode(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boRoleNodeDao.hasBoRoleNode(id,session)){
			boRoleNodeDao.deleteBoRoleNode(id,session);
			}
		} catch (HibernateException e) {

				result=0;
			
			e.printStackTrace();
			throw new BoException("ɾ������ʧ�ܣ�");
		} 
		return result;
	}
	
	public BoRoleNode getBoRoleNode(String id) throws BoException {
		BoRoleNode m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boRoleNodeDao.hasBoRoleNode(id,session)){
			m = boRoleNodeDao.getBoRoleNode(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		} 
		return m;
	}
    

    
    public List getList() throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boRoleNodeDao.getList(session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ڵ�ʧ�ܣ�");
		} 
    }
    
    
    public List getListByRoleId(String roleId) throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boRoleNodeDao.getListByRoleId(roleId,session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ڵ�ʧ�ܣ�");
		} 
    }
    
    
    public List getRootListByRoleId(String roleId) throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boRoleNodeDao.getRootListByRoleId(roleId,session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ڵ�ʧ�ܣ�");
		} 
    }
    
    
    
    public List getChildListByRoleId(String roleId) throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boRoleNodeDao.getChildListByRoleId(roleId,session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ڵ�ʧ�ܣ�");
		} 
    }
 
    	
    public boolean hasBoRoleNode(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boRoleNodeDao.hasBoRoleNode(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has��ѯʧ�ܣ�");
		} 
    }
    
    public boolean hasBoRoleNode(String roleId,String nodeId) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boRoleNodeDao.hasBoRoleNode( roleId, nodeId, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has��ѯʧ�ܣ�");
		}
    }

    
}
