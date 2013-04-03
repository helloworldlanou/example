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
			throw new BoException("初始化业务逻辑组件出现异常...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoRole(BoRole n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boRoleDao.addBoRole(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
    
    
    public int updateBoRole(BoRole n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boRoleDao.updateBoRole(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
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
			throw new BoException("删除对象失败！");
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
			throw new BoException("获取对象失败！");
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
			throw new BoException("获取对象失败！");
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
			throw new BoException("获取节点失败！");
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
			throw new BoException("获取节点失败！");
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
			throw new BoException("canup失败！");
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
			throw new BoException("candown失败！");
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
			throw new BoException("获取父节点失败！");
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
			throw new BoException("获取最大排序值失败！");
		} 
    }
    
    
    
    public ArrayList listFile(String path){
        File rootFile = new File(path);
        File[] files = rootFile.listFiles();
        ArrayList<String> fileNames = new ArrayList<String>(); // 存放文件名遍历
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
        ArrayList<String> fileNames = new ArrayList<String>(); // 存放文件名遍历
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
    			throw new BoException("up失败！");
    		} 
    }
    
    public void moveDown(String id) throws BoException{
    	try {
        	session = HibernateSessionFactory.getSession();
        	boRoleDao.moveDown(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("down失败！");
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
			throw new BoException("hasChildBoRole查询失败！");
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
    			throw new BoException("canDelete查询失败！");
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
			throw new BoException("has查询失败！");
		} 
    }
}
