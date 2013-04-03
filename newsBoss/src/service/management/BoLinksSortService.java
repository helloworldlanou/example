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
			throw new BoException("初始化业务逻辑组件出现异常...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	/**
	 * @author WZ
	 * 增加新的链接类别
	 */
    public int addBoLinksSort(BoLinksSort n) throws BoException{
    
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boLinksSortDao.addBoLinksSort(n,session);
		} catch (HibernateException e) {			
			result = 0;			
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    /**
     *@author WZ
     * 更新链接类别 ，成功则返回1，失败返回0
     * @throws BoException
     */
    public int updateBoLinksSort(BoLinksSort n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boLinksSortDao.updateBoLinksSort(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
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
			throw new BoException("删除对象失败！");
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
			throw new BoException("获取对象失败！");
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
			throw new BoException("has查询失败！");
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
			throw new BoException("分页查询失败！");
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
			throw new BoException("全部查询失败！");
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
     * 获取排序序列的最大值
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
     * 此类别上移
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
     * 此类别下移
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
