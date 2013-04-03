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

import dao.system.BoRoleDao;
import exception.BoException;
import factory.DaoFactory;

import model.system.BoRole;


public class BoRoleService {
	
	private BoRoleDao boRoleDao;

	public BoRoleService()throws BoException
	{
		try
		{
			boRoleDao = (BoRoleDao)DaoFactory.instance().getDao("boRoleDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("��ʼ��ҵ���߼���������쳣...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoRole(BoRole n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boRoleDao.addBoRole(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
    
    
    public int updateBoRole(BoRole n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boRoleDao.updateBoRole(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		}
		return result;
    }
    
	public int  deleteBoRole(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boRoleDao.hasBoRole(id,session)){
			boRoleDao.deleteBoRole(id,session);
			}
		} catch (HibernateException e) {
			result = 0;

			e.printStackTrace();
			throw new BoException("ɾ������ʧ�ܣ�");
		}
		return result;
	}
	
	public BoRole getBoRole(String id) throws BoException {
		BoRole m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boRoleDao.hasBoRole(id,session)){
			m = boRoleDao.getBoRole(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		} 
		return m;
	}
    
    public boolean hasChildNode(BoRole n) throws BoException {
    	boolean b ;
    	try {   	
    	session = HibernateSessionFactory.getSession();
    	b = boRoleDao.hasChildBoRole(n, session);
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		}
		return b;
    }

    //Manage
    public List getNodeManage() throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boRoleDao.getNodeManage(session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ڵ�ʧ�ܣ�");
		} 
    }
    
    public List getList() throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boRoleDao.getList(session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ڵ�ʧ�ܣ�");
		}
    }
    
    public boolean canUp(String id) throws BoException{
    	try {
    	boolean b = false;
    	session = HibernateSessionFactory.getSession();
		b = boRoleDao.canUp(id, session);
    	return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("canupʧ�ܣ�");
		} 
    }
    
    public boolean canDown(String id) throws BoException{
    	try {
    		boolean b =false;
    	session = HibernateSessionFactory.getSession();
    	b =  boRoleDao.canDown(id, session);
		return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("candownʧ�ܣ�");
		}
    }
    
    public BoRole getNodeParent(String id) throws BoException{
    	try {
    		BoRole b= null;
        	session = HibernateSessionFactory.getSession();
        	b = boRoleDao.getNodeParent(id, session);
        	return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ���ڵ�ʧ�ܣ�");
		} 
    }
    
    public Integer getMaxDispIndex() throws BoException{
    	try {
    	Integer i ;
    	String HQL = "select MAX (n.dispIndex) from BoRole as n ";
    	session = HibernateSessionFactory.getSession();
    	i = boRoleDao.getMaxDispIndex(session);
    	return i;
    	} catch (HibernateException e) {   		
			e.printStackTrace();
			throw new BoException("��ȡ�������ֵʧ�ܣ�");
		} 
    }
    
    
    
    public ArrayList listFile(String path){
        File rootFile = new File(path);
        File[] files = rootFile.listFiles();
        ArrayList<String> fileNames = new ArrayList<String>(); // ����ļ�������
        for (int i=0;i<files.length;i++){
            if(isImage(files[i])){
                fileNames.add("image/icon/dtree/"+files[i].getName());
            }
        }
        return fileNames;
    }
    
    public ArrayList listRootFile(String path){
        File rootFile = new File(path);
        File[] files = rootFile.listFiles();
        ArrayList<String> fileNames = new ArrayList<String>(); // ����ļ�������
        for (int i=0;i<files.length;i++){
            if(isImage(files[i])){
            	if(files[i].getName().indexOf("_s")<=0){
                fileNames.add("image/icon/menu_botton/"+files[i].getName());
            	}
            }
        }
        return fileNames;
    }
    
    public boolean isImage(File f){
        boolean result = false;
        String fileName = f.getName();
        String suffix = fileName.substring(fileName.indexOf(".")+1);
        String gif = "gif";
        String jpg = "jpg";
        if (suffix.equals(gif)||suffix.equals(jpg)){
            result = true;
        }
        return result;
    }
    
    public void moveUp(String id) throws BoException{
    	try {
    		
        	session = HibernateSessionFactory.getSession();
        	boRoleDao.moveUp(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("upʧ�ܣ�");
    		} 
    }
    
    public void moveDown(String id) throws BoException{
    	try {
        	session = HibernateSessionFactory.getSession();
        	boRoleDao.moveDown(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("downʧ�ܣ�");
    		} 
    }
    
    public boolean hasChildBoRole(BoRole n) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boRoleDao.hasChildBoRole(n, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("hasChildBoRole��ѯʧ�ܣ�");
		} 
    }
    
    
    public boolean canDeleteBoRole(String id) throws BoException{
        	boolean result = false;    
        	try {
            	session = HibernateSessionFactory.getSession();
            	result = boRoleDao.canDeleteBoRole(id, session);
            	return result;
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("canDelete��ѯʧ�ܣ�");
    		}
        }
    	
    public boolean hasBoRole(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boRoleDao.hasBoRole(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has��ѯʧ�ܣ�");
		} 
    }
}
