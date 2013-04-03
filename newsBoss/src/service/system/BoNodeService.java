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
			throw new BoException("初始化业务逻辑组件出现异常...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoNode(BoNode n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boNodeDao.addBoNode(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
    
    
    public int updateBoNode(BoNode n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boNodeDao.updateBoNode(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
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
			throw new BoException("删除对象失败！");
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
			throw new BoException("获取对象失败！");
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
			throw new BoException("获取对象失败！");
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
			throw new BoException("获取所有根目录失败！");
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
			throw new BoException("获取子节点失败！");
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
			throw new BoException("获取子节点失败！");
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
			throw new BoException("获取子节点失败！");
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
			throw new BoException("canup失败！");
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
			throw new BoException("candown失败！");
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
			throw new BoException("获取父节点失败！");
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
        	boNodeDao.moveUp(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("up失败！");
    		}
    }
    
    public void moveDown(String id) throws BoException{
    	try {
        	session = HibernateSessionFactory.getSession();
        	boNodeDao.moveDown(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("down失败！");
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
			throw new BoException("hasChildBoNode查询失败！");
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
			throw new BoException("has查询失败！");
		} 
    }
}
