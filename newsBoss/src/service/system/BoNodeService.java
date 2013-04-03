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

import dao.system.BoNodeDao;
import exception.BoException;
import factory.DaoFactory;

import model.system.BoNode;


public class BoNodeService {
	
	private BoNodeDao boNodeDao;

	public BoNodeService()throws BoException
	{
		try
		{
			boNodeDao = (BoNodeDao)DaoFactory.instance().getDao("boNodeDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("��ʼ��ҵ���߼���������쳣...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoNode(BoNode n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boNodeDao.addBoNode(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
    
    
    public int updateBoNode(BoNode n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boNodeDao.updateBoNode(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
	public int  deleteBoNode(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boNodeDao.hasBoNode(id,session)){
			boNodeDao.deleteBoNode(id,session);
			}
		
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("ɾ������ʧ�ܣ�");
		} 
		return result;
	}
	
	public BoNode getBoNode(String id) throws BoException {
		BoNode m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boNodeDao.hasBoNode(id,session)){
			m = boNodeDao.getBoNode(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		} 
		return m;
	}
    
    public boolean hasChildNode(BoNode n) throws BoException {
    	boolean b ;
    	try {   	
    	session = HibernateSessionFactory.getSession();
    	b = boNodeDao.hasChildBoNode(n, session);
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		} 
		return b;
    }

    
    public List getNodeFatherRoot() throws BoException {
    	try {
    	List list ;
    	session = HibernateSessionFactory.getSession();	
    	list = boNodeDao.getNodeFatherRoot(session);
		return list ;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ���и�Ŀ¼ʧ�ܣ�");
		}
    }
    //Menu
    public List getNodeChildByPid(String id) throws BoException{
    	try {
    		List list = null;
    	session = HibernateSessionFactory.getSession();
		list = boNodeDao.getNodeChildByPid(id,session,new ArrayList());
    	return list;
    	} catch (HibernateException e) {    	
			e.printStackTrace();
			throw new BoException("��ȡ�ӽڵ�ʧ�ܣ�");
		}
    }
    //Manage
    public List getNodeManage() throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boNodeDao.getNodeManage(session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ӽڵ�ʧ�ܣ�");
		} 
    }
    
    public List getChild(String id) throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boNodeDao.getChild(id,session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ӽڵ�ʧ�ܣ�");
		}
    }
    
    public boolean canUp(String id) throws BoException{
    	try {
    	boolean b = false;
    	session = HibernateSessionFactory.getSession();
		b = boNodeDao.canUp(id, session);
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
    	b =  boNodeDao.canDown(id, session);
		return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("candownʧ�ܣ�");
		}
    }
    
    public BoNode getNodeParent(String id) throws BoException{
    	try {
    		BoNode b= null;
        	session = HibernateSessionFactory.getSession();
        	b = boNodeDao.getNodeParent(id, session);
        	return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ���ڵ�ʧ�ܣ�");
		} 
    }
    
    public Integer getMaxDispIndex() throws BoException{
    	try {
    	Integer i ;
    	String HQL = "select MAX (n.dispIndex) from BoNode as n ";
    	session = HibernateSessionFactory.getSession();
    	i = boNodeDao.getMaxDispIndex(session);
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
        	boNodeDao.moveUp(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("upʧ�ܣ�");
    		}
    }
    
    public void moveDown(String id) throws BoException{
    	try {
        	session = HibernateSessionFactory.getSession();
        	boNodeDao.moveDown(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("downʧ�ܣ�");
    		} 
    }
    
    public boolean hasChildBoNode(BoNode n) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boNodeDao.hasChildBoNode(n, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("hasChildBoNode��ѯʧ�ܣ�");
		} 
    }
    
    public boolean hasBoNode(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boNodeDao.hasBoNode(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has��ѯʧ�ܣ�");
		} 
    }
}
