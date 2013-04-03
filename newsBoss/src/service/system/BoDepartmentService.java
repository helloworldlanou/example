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

import dao.system.BoDepartmentDao;
import exception.BoException;
import factory.DaoFactory;

import model.system.BoDepartment;


public class BoDepartmentService {
	
	private BoDepartmentDao boDepartmentDao;

	public BoDepartmentService()throws BoException
	{
		try
		{
			boDepartmentDao = (BoDepartmentDao)DaoFactory.instance().getDao("boDepartmentDao");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BoException("��ʼ��ҵ���߼���������쳣...");
		}
	}
	
	Session session = null;
	Transaction tx = null;
	
    public int addBoDepartment(BoDepartment n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boDepartmentDao.addBoDepartment(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
    
    
    public int updateBoDepartment(BoDepartment n) throws BoException{
		int result=1;//��ȷ
		try {
			session = HibernateSessionFactory.getSession();
			boDepartmentDao.updateBoDepartment(n,session);
		} catch (HibernateException e) {
				result = 0;
			e.printStackTrace();
			throw new BoException("�������ʧ�ܣ�");
		} 
		return result;
    }
    
	public int  deleteBoDepartment(String id)  throws BoException{
		int result = 1;
		try {
			session = HibernateSessionFactory.getSession();
			if(boDepartmentDao.hasBoDepartment(id,session)){
			boDepartmentDao.deleteBoDepartment(id,session);
			}
		} catch (HibernateException e) {
			result = 0;
			e.printStackTrace();
			throw new BoException("ɾ������ʧ�ܣ�");
		} 
		return result;
	}
	
	public BoDepartment getBoDepartment(String id) throws BoException {
		BoDepartment m = null;
		try {
			session = HibernateSessionFactory.getSession();
			if(boDepartmentDao.hasBoDepartment(id,session)){
			m = boDepartmentDao.getBoDepartment(id,session);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		} 
		return m;
	}
    
    public boolean hasChildNode(BoDepartment n) throws BoException {
    	boolean b ;
    	try {   	
    	session = HibernateSessionFactory.getSession();
    	b = boDepartmentDao.hasChildBoDepartment(n, session);
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ����ʧ�ܣ�");
		} 
		return b;
    }

    //Manage
    public List getNodeManage() throws BoException{
    	try {
    		List list = null;
        	session = HibernateSessionFactory.getSession();
			list = boDepartmentDao.getNodeManage(session);
        	return list;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ�ڵ�ʧ�ܣ�");
		} 
    }
    
    
    
    public boolean canUp(String id) throws BoException{
    	try {
    	boolean b = false;
    	session = HibernateSessionFactory.getSession();
		b = boDepartmentDao.canUp(id, session);
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
    	b =  boDepartmentDao.canDown(id, session);
		return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("candownʧ�ܣ�");
		} 
    }
    
    public BoDepartment getNodeParent(String id) throws BoException{
    	try {
    		BoDepartment b= null;
        	session = HibernateSessionFactory.getSession();
        	b = boDepartmentDao.getNodeParent(id, session);
        	return b;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("��ȡ���ڵ�ʧ�ܣ�");
		} 
    }
    
    public Integer getMaxDispIndex() throws BoException{
    	try {
    	Integer i ;
    	String HQL = "select MAX (n.dispIndex) from BoDepartment as n ";
    	session = HibernateSessionFactory.getSession();
    	i = boDepartmentDao.getMaxDispIndex(session);
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
        	boDepartmentDao.moveUp(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("upʧ�ܣ�");
    		} 
    }
    
    public void moveDown(String id) throws BoException{
    	try {
        	session = HibernateSessionFactory.getSession();
        	boDepartmentDao.moveDown(id, session);
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("downʧ�ܣ�");
    		} 
    }
    
    public boolean hasChildBoDepartment(BoDepartment n) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boDepartmentDao.hasChildBoDepartment(n, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("hasChildBoDepartment��ѯʧ�ܣ�");
		} 
    }
    
    
    public boolean canDeleteBoDepartment(String id) throws BoException{
        	boolean result = false;    
        	try {
            	session = HibernateSessionFactory.getSession();
            	result = boDepartmentDao.canDeleteBoDepartment(id, session);
            	return result;
        	} catch (HibernateException e) {
    			e.printStackTrace();
    			throw new BoException("canDelete��ѯʧ�ܣ�");
    		}
        }
    	
    public boolean hasBoDepartment(String id) throws BoException{
    	boolean result = false;    
    	try {
        	session = HibernateSessionFactory.getSession();
        	result = boDepartmentDao.hasBoDepartment(id, session);
        	return result;
    	} catch (HibernateException e) {
			e.printStackTrace();
			throw new BoException("has��ѯʧ�ܣ�");
		} 
    }
}
