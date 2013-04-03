package service.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.system.BoPerson;
import model.system.PageList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernate.HibernateSessionFactory;
import dao.system.BoPersonDao;
import exception.BoException;
import factory.DaoFactory;

public class BoPersonService {
	private BoPersonDao boPersonDao;

	public BoPersonService()throws BoException
	{
		try
		{
			boPersonDao = (BoPersonDao)DaoFactory.instance().getDao("boPersonDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("初始化业务逻辑组件出现异常...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoPerson(BoPerson n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boPersonDao.addBoPerson(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
    
    
    public int updateBoPerson(BoPerson n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boPersonDao.updateBoPerson(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
	public int  deleteBoPerson(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boPersonDao.hasBoPerson(id,session)){
			boPersonDao.deleteBoPerson(id,session);
			}
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("删除对象失败！");
		} 
		return result;
	}
	
	public BoPerson getBoPerson(String id) throws BoException {
		BoPerson m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boPersonDao.hasBoPerson(id,session)){
			m = boPersonDao.getBoPerson(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return m;
	}
	
    public boolean hasBoPerson(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boPersonDao.hasBoPerson(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has查询失败！");
		}
    }
    
	public Map getBoPersonMap(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boPersonDao.getBoPersonNum(pageList, session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boPersonDao.getBoPersonList(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("分页查询失败！");
		} 
		return map;
	}
	
	public Integer getMaxDispIndex() throws BoException{
    	try {
    	Integer i ;
    	String HQL = "select MAX (n.dispIndex) from BoPerson as n ";
    	session = HibernateSessionFactory.getSession();
    	i = boPersonDao.getMaxDispIndex(session);
    	return i;
    	} catch (HibernateException e) {   		
			e.printStackTrace();
			throw new BoException("获取最大排序值失败！");
		} 
    }
	
	
	
	public List getBoPersonByParentId(String id)  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boPersonDao.getBoPersonByParentId(id,session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	
	public List getBoPersonByRoleId(String id)  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boPersonDao.getBoPersonByRoleId(id,session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	
	public List getAllBoPerson()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boPersonDao.getAllBoPerson(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	
	public List login(String user,String pwd)  throws BoException {
		List result ;		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boPersonDao.checkPwd(session,user,pwd);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	public static void main(String[] args) throws Exception{
		
	}
	

}
