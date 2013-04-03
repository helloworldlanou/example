package service.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.management.BoLinks;
import model.management.BoLinksSort;
import model.management.BoSpecial;

import model.system.BoPerson;
import model.system.PageList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.management.BoLinksDao;
import dao.management.BoLinksSortDao;
import dao.management.BoSpecialDao;
import util.hibernate.HibernateSessionFactory;

import exception.BoException;
import factory.DaoFactory;
import factory.ServiceFactory;

public class BoSpecialService {
	/**
	 * @author WangZ
	 * 操作专题的service
	 */
	private BoSpecialDao boSpecialDao;

	public BoSpecialService()throws BoException
	{
		try
		{
			boSpecialDao = (BoSpecialDao)DaoFactory.instance().getDao("boSpecialDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("初始化业务逻辑组件出现异常...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	/**
	 * @author WZ
	 * 增加新的专题类别
	 */
    public int addBoSpecial(BoSpecial n) throws BoException{
    
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boSpecialDao.addBoSpecial(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    /**
     *@author WZ
     * 更新专题类别 ，成功则返回1，失败返回0
     * @throws BoException
     */
    public int updateBoSpecial(BoSpecial n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boSpecialDao.updateBoSpecial(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
    public int  deleteBoSpecial(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boSpecialDao.hasBoSpecial(id,session)){
			boSpecialDao.deleteBoSpecial(id,session);
			}
			result = 0;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("删除对象失败！");
		} 
		return result;
	}
    
    public BoSpecial getBoSpecial(String id) throws BoException {
		BoSpecial m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boSpecialDao.hasBoSpecial(id,session)){
			m = boSpecialDao.getBoSpecial(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return m;
	}
    
	public List getSmallBoSpecialByPid(String pid)throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boSpecialDao.getSmallBoSpecialByPid(pid,session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;

	}
    
    
    public boolean hasBoSpecial(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boSpecialDao.hasBoSpecial(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has查询失败！");
		} 
    }
    
	public Map getBoSpecialMap(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boSpecialDao.getBoSpecialNum( session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boSpecialDao.getBoSpecialList(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("分页查询失败！");
		} 
		return map;
	}
	public List getAllBoSpecial()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boSpecialDao.getAllBoSpecial(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	
	public List getSmallBoSpecial()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boSpecialDao.getSmallBoSpecial(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	
	public int getSpecialNumByPid(String pid) {
		int result = 0;
		try {
			session = HibernateSessionFactory.getSession();		

			result =boSpecialDao.getSpecialNumByPid(pid, session);

		} catch (HibernateException e) {
			e.printStackTrace();
			
		} 	
		return result;
		
	}
	
    public Boolean isnull(){
    	try {
			session = HibernateSessionFactory.getSession();		

			int count =boSpecialDao.getBoSpecialNum(session);
			if(count>0)return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} 	
		return true;    	
    }
    

    /**
     * @author WZ
     * 获取排序序列的最大值
     */
    public int getMaxSerial(){
    	int count=-1;
    	try {
			session = HibernateSessionFactory.getSession();		

			 count =boSpecialDao.getMaxSerial(session);
			return count;
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}	
	return count;
    	
    }
    /**
     * 此类别上移
     * @param id
     */
    public void moveUp(String id){
    	
    	try {
			session = HibernateSessionFactory.getSession();		
			tx = session.beginTransaction();		
			 boSpecialDao.moveUp(id, session);
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}	  	
    }
    /**
     * 此类别下移
     * @param id
     */
    public void moveDown(String id){
    	
    	try {
			session = HibernateSessionFactory.getSession();		
			tx = session.beginTransaction();			
			 boSpecialDao.moveDown(id, session);
			 //tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} 	  	
    }
    
    

	public static void main(String[] args) throws Exception{
	
		
	}
	

}
