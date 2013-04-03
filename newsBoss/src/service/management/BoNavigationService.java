package service.management;

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

import dao.management.BoNavigationDao;
import exception.BoException;
import factory.DaoFactory;

import model.management.BoNavigation;


public class BoNavigationService {
	
	private BoNavigationDao boNavigationDao;

	public BoNavigationService()throws BoException
	{
		try
		{
			boNavigationDao = (BoNavigationDao)DaoFactory.instance().getDao("boNavigationDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("初始化业务逻辑组件出现异常...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoNavigation(BoNavigation n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boNavigationDao.addBoNavigation(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
    
    
    public int updateBoNavigation(BoNavigation n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boNavigationDao.updateBoNavigation(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
	public int  deleteBoNavigation(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boNavigationDao.hasBoNavigation(id,session)){
			boNavigationDao.deleteBoNavigation(id,session);
			}
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("删除对象失败！");
		} 
		return result;
	}
	
	public BoNavigation getBoNavigation(String id) throws BoException {
		BoNavigation m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boNavigationDao.hasBoNavigation(id,session)){
			m = boNavigationDao.getBoNavigation(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return m;
	}
    
	public BoNavigation getCheckedBoNavigation() throws BoException {
		BoNavigation m = null;
		try {
			session = HibernateSessionFactory.getSession();
			m = boNavigationDao.getCheckedBoNavigation(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return m;
	}
	
	
	
    public boolean hasChildNode(BoNavigation n) throws BoException {
    	boolean b ;
    	try {   	
    	session = HibernateSessionFactory.getSession();
    	b = boNavigationDao.hasChildBoNavigation(n, session);
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
			list = boNavigationDao.getNodeManage(session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取节点失败！");
		} 
    }
    
    public List getNodeManageSmall() throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boNavigationDao.getNodeManageSmall(session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取节点失败！");
		} 
    }
    public List getinfoSmall(String id) throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boNavigationDao.getinfoSmall(id, session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取节点失败！");
		} 
    }
    
	public int getBoNavigationSmallnum (String id){    //获取大类中存在info型新闻的小类条数
		
		int num=0;
		try{
			session = HibernateSessionFactory.getSession();
			int count=boNavigationDao.getBoNavigationSmallnum(id, session);
			num=count;
			//if (count>0) return false;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return num;
		
	}
	public int getBoNavigationnotinfnum (String id){    //获取大类中不是info型新闻的小类条数
		
		int num=0;
		try{
			session = HibernateSessionFactory.getSession();
			int count=boNavigationDao.getBoNavigationSmallnotinfonum(id, session);
			num=count;
			//if (count>0) return false;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return num;
		
	}
    public List getBoNavigationRootList() throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boNavigationDao.getBoNavigationRootList(session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取节点失败！");
		} 
    }
    
    public List getBoNavigationListByParentId(String pid) throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boNavigationDao.getBoNavigationListByParentId(pid, session);
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
		b = boNavigationDao.canUp(id, session);
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
    	b =  boNavigationDao.canDown(id, session);
		return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("candown失败！");
		}
    }
    
    public BoNavigation getNodeParent(String id) throws BoException{
    	try {
    		BoNavigation b= null;
        	session = HibernateSessionFactory.getSession();
        	b = boNavigationDao.getNodeParent(id, session);
        	return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取父节点失败！");
		} 
    }
    
    public Integer getMaxDispIndex() throws BoException{
    	try {
    	Integer i ;
    	String HQL = "select MAX (n.dispIndex) from BoNavigation as n ";
    	session = HibernateSessionFactory.getSession();
    	i = boNavigationDao.getMaxDispIndex(session);
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
        	boNavigationDao.moveUp(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("up失败！");
    		}
    }
    
    public void moveDown(String id) throws BoException{
    	try {
        	session = HibernateSessionFactory.getSession();
        	boNavigationDao.moveDown(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("down失败！");
    		} 
    }
    
    public boolean hasChildBoNavigation(BoNavigation n) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boNavigationDao.hasChildBoNavigation(n, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("hasChildBoNavigation查询失败！");
		} 
    }
    
    
    public boolean canDeleteBoNavigation(String id) throws BoException{
        	boolean result = false;    
        	try {
            	session = HibernateSessionFactory.getSession();
            	result = boNavigationDao.canDeleteBoNavigation(id, session);
            	return result;
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("canDelete查询失败！");
    		} 
        }
    	
    public boolean hasBoNavigation(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boNavigationDao.hasBoNavigation(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has查询失败！");
		} 
		
    }
	    public List getCustomNavigatorList() throws BoException{
	    	List result = new ArrayList();    
	    	try {
	        	session = HibernateSessionFactory.getSession();
	        	result = boNavigationDao.getCustomNavigatorList( session);
	        	return result;
	    	} catch (HibernateException e) {
				e.printStackTrace();
				throw new BoException("has查询失败！");
			}
		
	    }
	    
	    public List getSecondNodeList() throws BoException{
	    	List result = new ArrayList();    
	    	try {
	        	session = HibernateSessionFactory.getSession();
	        	result = boNavigationDao.getSecondNodeList( session);
	        	return result;
	    	} catch (HibernateException e) {
				e.printStackTrace();
				throw new BoException("取二级菜单失败！");
			}
	    
	    }
	    public List getBoNavigationListCenterShow() throws BoException{
	    	List result = new ArrayList();    
	    	try {
	        	session = HibernateSessionFactory.getSession();
	        	result = boNavigationDao.getBoNavigationListCenterShow( session);
	        	return result;
	    	} catch (HibernateException e) {
				e.printStackTrace();
				throw new BoException("取首页中间显示失败！");
			}
	    
	    }
	    
}
