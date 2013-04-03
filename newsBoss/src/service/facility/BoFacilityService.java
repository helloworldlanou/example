package service.facility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.facility.BoFacility;
import model.system.PageList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernate.HibernateSessionFactory;
import dao.facility.BoFacilityDao;
import exception.BoException;
import factory.DaoFactory;

public class BoFacilityService {
	private BoFacilityDao boFacilityDao;

	public BoFacilityService()throws BoException
	{
		try
		{
			boFacilityDao = (BoFacilityDao)DaoFactory.instance().getDao("boFacilityDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("初始化业务逻辑组件出现异常...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoFacility(BoFacility n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boFacilityDao.addBoFacility(n,session);
		} catch (HibernateException e) {
			result=0;//正确
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
    
    
    public int updateBoFacility(BoFacility n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boFacilityDao.updateBoFacility(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		} 
		return result;
    }
    
	public int  deleteBoFacility(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boFacilityDao.hasBoFacility(id,session)){
			boFacilityDao.deleteBoFacility(id,session);
			}
			
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("删除对象失败！");
		} 
		return result;
	}
	
	public BoFacility getBoFacility(String id) throws BoException {
		BoFacility m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boFacilityDao.hasBoFacility(id,session)){
			m = boFacilityDao.getBoFacility(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return m;
	}
	
    public boolean hasBoFacility(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boFacilityDao.hasBoFacility(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has查询失败！");
		} 
    }
    
	public Map getBoFacilityMap(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boFacilityDao.getBoFacilityNum(pageList, session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boFacilityDao.getBoFacilityList(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("分页查询失败！");
		} 
		return map;
	}
	
	
	
	public List getAllBoFacility()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boFacilityDao.getAllBoFacility(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return result;
	}
	

	public static void main(String[] args) throws Exception{
		
	}
	

}
