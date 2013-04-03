package service.facility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.facility.BoFacilityType;
import model.system.PageList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernate.HibernateSessionFactory;
import dao.facility.BoFacilityTypeDao;
import exception.BoException;
import factory.DaoFactory;

public class BoFacilityTypeService {
	private BoFacilityTypeDao boFacilityTypeDao;

	public BoFacilityTypeService()throws BoException
	{
		try
		{
			boFacilityTypeDao = (BoFacilityTypeDao)DaoFactory.instance().getDao("boFacilityTypeDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("初始化业务逻辑组件出现异常...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoFacilityType(BoFacilityType n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boFacilityTypeDao.addBoFacilityType(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
    
    
    public int updateBoFacilityType(BoFacilityType n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boFacilityTypeDao.updateBoFacilityType(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
	public int  deleteBoFacilityType(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boFacilityTypeDao.hasBoFacilityType(id,session)){
			boFacilityTypeDao.deleteBoFacilityType(id,session);
			}
			
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("删除对象失败！");
		} 
		return result;
	}
	
	public BoFacilityType getBoFacilityType(String id) throws BoException {
		BoFacilityType m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boFacilityTypeDao.hasBoFacilityType(id,session)){
			m = boFacilityTypeDao.getBoFacilityType(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		}
		return m;
	}
	
    public boolean hasBoFacilityType(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boFacilityTypeDao.hasBoFacilityType(id, session);
        	
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has查询失败！");
		} 
    	return result;
    }
    
	public Map getBoFacilityTypeMap(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boFacilityTypeDao.getBoFacilityTypeNum(pageList, session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boFacilityTypeDao.getBoFacilityTypeList(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("分页查询失败！");
		} 
		return map;
	}
	
	
	
	public List getAllBoFacilityType()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boFacilityTypeDao.getAllBoFacilityType(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	
	
	
	public boolean canDelete(String tid)  throws BoException {
		boolean result = false;		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boFacilityTypeDao.canDelete(tid,session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		}
		return result;
	}
	
	public boolean hasNid(String tid)  throws BoException {
		boolean result = false;		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boFacilityTypeDao.hasNid(tid,session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	
	public BoFacilityType getByNid(String tid)  throws BoException {
		BoFacilityType result = null;		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boFacilityTypeDao.getByNid(tid,session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}



	public static void main(String[] args) throws Exception{
		
	}
	

}
