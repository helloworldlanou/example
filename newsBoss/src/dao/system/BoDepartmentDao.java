package dao.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.base.BaseDao;
import model.system.BoDepartment;

public class BoDepartmentDao extends BaseDao{
    
	public void addBoDepartment(BoDepartment n,Session session){
		session.saveOrUpdate(n);
	}
	
	public void updateBoDepartment(BoDepartment n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public void deleteBoDepartment(String id,Session session){
        BoDepartment node = (BoDepartment) session.load(BoDepartment.class, id);
        session.delete(node);
    }
    
    public BoDepartment getBoDepartment(String id,Session session){
    	BoDepartment b = null;
        b = (BoDepartment)session.load(BoDepartment.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    public boolean canUp(String id,Session session){
    	
        boolean result = false;
        BoDepartment node = getBoDepartment(id,session);
        String HQL = "select MIN (n.dispIndex) from BoDepartment as n where n.parentId = '"+node.getParentId()+"'";
        Integer minid = Integer.parseInt(load(HQL,session).toString());
        if (node.getDispIndex()>minid)
            result = true;
        return result;
    }
    
    public boolean canDown(String id,Session session){
        boolean result = false;
        BoDepartment node = getBoDepartment(id,session);
        String HQL = "select MAX (n.dispIndex) from BoDepartment as n where n.parentId = '"+node.getParentId()+"'";
        Integer maxid = Integer.parseInt(load(HQL,session).toString());
        if (node.getDispIndex()<maxid)
            result = true;
        return result;
    }
    
    //get All Department
    public List getNodeManage(Session session){
    	String HQL = "select n from BoDepartment as n order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }
    
    public BoDepartment getNodeParent(String id,Session session){
        BoDepartment node = getBoDepartment(id,session);
        BoDepartment parent = getBoDepartment(node.getParentId(),session);
        return parent;
    }
    
    public boolean hasBoDepartment(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoDepartment as n where n.id = '"+id+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }

    public boolean hasChildBoDepartment(BoDepartment n,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoDepartment as n where n.parentId = '"+n.getId()+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }
    
    public boolean canDeleteBoDepartment(String id,Session session){
    	boolean result = false;    
    	boolean result1 = false;  
    	String HQL = "select count(*) from BoDepartment as n where n.parentId = '"+id+"'";
 	    Integer count = Integer.parseInt(load(HQL,session).toString());
 	    if (count>0) result = true;
    	String HQL1 = "select count(*) from BoPerson as n where n.parentId = '"+id+"'";
    	Integer count1 = Integer.parseInt(load(HQL1,session).toString());
    	 if (count1>0) result1 = true;
    	return !(result|result1);
    }
    
    public Integer getMaxDispIndex(Session session){
    	String HQL = "select MAX (n.dispIndex) from BoDepartment as n ";
    	return Integer.parseInt(load(HQL,session).toString());
    }
    

    public void moveUp(String id,Session session){
    	BoDepartment fb = getNodeParent(id,session);
    	BoDepartment now = getBoDepartment(id,session);
    	String HQL = "select MAX (n.dispIndex) from BoDepartment as n where n.parentId = '"+fb.getId()+"' and n.dispIndex <"+now.getDispIndex();  	
    	Integer disp = Integer.parseInt(load(HQL,session).toString());
    	String HQL1 = "select n from BoDepartment as n where  n.dispIndex ="+disp;  	
    	BoDepartment n = (BoDepartment) load(HQL1,session);
    	n.setDispIndex(now.getDispIndex());
    	now.setDispIndex(disp);
    	session.update(now);
    	session.update(n);
    }
     
    public void moveDown(String id,Session session){
    	BoDepartment fb = getNodeParent(id,session);
    	BoDepartment now = getBoDepartment(id,session);
    	String HQL = "select MIN (n.dispIndex) from BoDepartment as n where n.parentId = '"+fb.getId()+"' and n.dispIndex >"+now.getDispIndex();  	
    	Integer disp = Integer.parseInt(load(HQL,session).toString());
    	String HQL1 = "select n from BoDepartment as n where  n.dispIndex ="+disp;  	
    	BoDepartment n = (BoDepartment) load(HQL1,session);
    	n.setDispIndex(now.getDispIndex());
    	now.setDispIndex(disp);	
    	session.update(now);
    	session.update(n);
    }
    
    public List getChild(String id,Session session){
	    String HQL = "select n from BoDepartment as n where n.parentId = '"+id+"'";
	    Query query = session.createQuery(HQL);
        return query.list();
    }
    

}
