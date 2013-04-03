package service.news;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.news.BoNews;
import model.system.PageList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.hibernate.HibernateSessionFactory;
import dao.news.BoNewsDao;
import exception.BoException;
import factory.DaoFactory;

public class BoNewsService {
	/**
	 * @author WangZ
	 * 
	 */
	private BoNewsDao boNewsDao;

	public BoNewsService()throws BoException
	{
		try
		{
			boNewsDao = (BoNewsDao)DaoFactory.instance().getDao("boNewsDao");		
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
	 * 增加新的链接
	 */
    public int addBoNews(BoNews n) throws BoException{
    
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boNewsDao.addBoNews(n,session);
			session.flush();
		} catch (HibernateException e) {			
			result = 0;			
			e.printStackTrace();
			throw new BoException("添加对象失败！");
		}	
		return result;
    }
    /**
     *@author WZ
     * 更新链接 ，成功则返回1，失败返回0
     * @throws BoException
     */
    public int updateBoNews(BoNews n) throws BoException{
		int result=1;//正确
		try {
			session = HibernateSessionFactory.getSession();
			boNewsDao.updateBoNews(n,session);
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("保存对象失败！");
		}
		return result;
    }
    
    public int  deleteBoNews(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boNewsDao.hasBoNews(id,session)){
			boNewsDao.deleteBoNews(id,session);
			}
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("删除对象失败！");
		} 
		return result;
	}
    
    public List getBoPicNews ()throws BoException {
    	List result = null;
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getBoPicNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return result;
	}
    
    public List getBoTrainingNews ()throws BoException {
    	List result = null;
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getBoTrainingNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return result;
	}
    
    public List getBoProjectNews ()throws BoException {
    	List result = null;
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getBoProjectNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return result;
	}
    
    public List getBoCenterNews ()throws BoException {
    	List result = null;
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getBoCenterNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return result;
	}
    
    public List getEnBoPicNews ()throws BoException {
    	List result = null;
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getEnBoPicNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return result;
	}
    
    public List getEnBoTrainingNews ()throws BoException {
    	List result = null;
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getEnBoTrainingNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return result;
	}
    
    public List getEnBoProjectNews ()throws BoException {
    	List result = null;
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getEnBoProjectNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return result;
	}
    
    public List getEnBoCenterNews ()throws BoException {
    	List result = null;
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getEnBoCenterNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return result;
	}
    
    public BoNews getBoTopNews ()throws BoException {
		BoNews m = null;
		try {
			session = HibernateSessionFactory.getSession();		
			m = boNewsDao.getTopBoNews(session);				
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		} 
		return m;
	}
    public BoNews getBoNews(String id) throws BoException {
		BoNews m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boNewsDao.hasBoNews(id, session)){
			m = boNewsDao.getBoNews(id, session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("获取对象失败！");
		}
		return m;
	}
    
    public boolean hasBoNews(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boNewsDao.hasBoNews(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has查询失败！");
		} 
    }
    
	public Map getBoNewsMap(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boNewsDao.getBoNewsNum(pageList, session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boNewsDao.getBoNewsList(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("分页查询失败！");
		}
		return map;
	}
	public List getAllBoNews()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getAllBoNews(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		}
		return result;
	}
    
	public List getAllBoSmallNews()  throws BoException {
		List result = new ArrayList();		
		try {
			session = HibernateSessionFactory.getSession();		
			result = boNewsDao.getAllBoSmallNews(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		}
		return result;
	}
	public BoNews getTopBoNews()  throws BoException {       //得到英文新闻头条
		BoNews n = null;		
		try {
			session = HibernateSessionFactory.getSession();		
			n = boNewsDao.getTopBoNews(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return n;
	}
	
	
	public BoNews getTopBoNewsEn()  throws BoException {        //得到英文新闻头条
		BoNews n = null;		
		try {
			session = HibernateSessionFactory.getSession();		
			n = boNewsDao.getTopBoNewsEn(session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("全部查询失败！");
		} 
		return n;
	}
	

	public Map getBoNewsMapByType(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boNewsDao.getBoNewsNum(pageList, session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boNewsDao.getBoNewsList(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("分页查询失败！");
		}
		return map;
	}

	public boolean isSpecialnull(String id){
		try{
			session = HibernateSessionFactory.getSession();
			int count=boNewsDao.getBoNewstNumBySpecial(id, session);
			if (count>0) return false;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return true;
		
	}
	
	public boolean isSpecialnullSmall(String id){
		try{
			session = HibernateSessionFactory.getSession();
			int count=boNewsDao.isSpecialnullSmall(id, session);
			if (count>0) return false;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return true;
		
	}
	
	public boolean isBigTypenull(String id){
		try{
			session = HibernateSessionFactory.getSession();
			int count=boNewsDao.getBoNewsNumByBig(id, session);
			if (count>0) return false;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return true;
		
	}
	public boolean isSmallTypenull(String id){
		try{
			session = HibernateSessionFactory.getSession();
			int count=boNewsDao.getBoNewsNumBySmall(id, session);
			if (count>0) return false;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return true;
		
	}
	
	public Map getBoNewsMapForSecondaryPage(PageList pageList,String en)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boNewsDao.getBoNewsNumForSecondaryPage(pageList, en,session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boNewsDao.getBoNewsListForSecondaryPage(pageList, en,session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("分页查询失败！");
		}
		return map;
	}
	
	public Map getBoNewsMapBySpecial(PageList pageList)  throws BoException {
		List list = new ArrayList();
		Map  map = new HashMap();
		try {
			session = HibernateSessionFactory.getSession();
			int count=boNewsDao.getBoNewsNumBySpecial(pageList, session);
			if(pageList.getFetch()==-1) pageList.setFetch(count);
			pageList.setParameters(count);					
			list = boNewsDao.getBoNewsListBySpecial(pageList, session);
			map.put("pageList", pageList);
			map.put("list", list);	
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("分页查询失败！");
		}
		return map;
	}

	public BoNews getBoNewsBySmallType(String id,String en) throws BoException
	{
		BoNews n = new BoNews();
		try {
		session = HibernateSessionFactory.getSession();
		n = boNewsDao.getBoNewsBySmallType(id,en, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("查找失败！");
		}
		return n;
	}
	
	public BoNews getBoNewsByBigType(String id,String en) throws BoException
	{
		BoNews n = new BoNews();
		try {
		session = HibernateSessionFactory.getSession();
		n = boNewsDao.getBoNewsByBigType(id,en, session);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("查找失败！");
		}
		return n;
	}
	
	public List getTop10ByBigType(String id,String en) throws BoException
	{
		List n = new ArrayList();
		try {
		session = HibernateSessionFactory.getSession();
		n = boNewsDao.getTop10ByBigType(id, session,en);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("查找失败！");
		}
		return n;
	}
	
	public List getTop10BySmallType(String id,String en) throws BoException
	{
		List n = new ArrayList();
		try {
		session = HibernateSessionFactory.getSession();
		n = boNewsDao.getTop10BySmallType(id, session,en);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("查找失败！");
		}
		return n;
	}
    public int getinfonewsnum(String id) throws BoException{
        
		int result=0;
		try {
			session = HibernateSessionFactory.getSession();
			result=boNewsDao.getinfonewsnum(id, session);
		} catch (HibernateException e) {			
			result = 0;			
			e.printStackTrace();
		}	
		return result;
    }
    
    
  //新添加为
	public List getCnSpecialBoNews(String id,String en) {
		List result = null;
		try {
			session = HibernateSessionFactory.getSession();
			result=boNewsDao.getCnSpecialBoNews(id, en , session);
		} catch (HibernateException e) {			
			e.printStackTrace();
		}	
		return result;
		
	}
	
	
	
	
}
