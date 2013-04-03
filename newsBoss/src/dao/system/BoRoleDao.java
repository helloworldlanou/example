package dao.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.base.BaseDao;
import model.system.BoRole;

public class BoRoleDao extends BaseDao{
    
	public void addBoRole(BoRole n,Session session){
		session.saveOrUpdate(n);
	}
	
	public void updateBoRole(BoRole n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public void deleteBoRole(String id,Session session){
        BoRole node = (BoRole) session.load(BoRole.class, id);
        session.delete(node);
    }
    
    public BoRole getBoRole(String id,Session session){
    	BoRole b = null;
        b = (BoRole)session.load(BoRole.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    public boolean canUp(String id,Session session){
    	
        boolean result = false;
        BoRole node = getBoRole(id,session);
        String HQL = "select MIN (n.dispIndex) from BoRole as n where n.parentId = '"+node.getParentId()+"'";
        Integer minid = Integer.parseInt(load(HQL,session).toString());
        if (node.getDispIndex()>minid)
            result = true;
        return result;
    }
    
    public boolean canDown(String id,Session session){
        boolean result = false;
        BoRole node = getBoRole(id,session);
        String HQL = "select MAX (n.dispIndex) from BoRole as n where n.parentId = '"+node.getParentId()+"'";
        Integer maxid = Integer.parseInt(load(HQL,session).toString());
        if (node.getDispIndex()<maxid)
            result = true;
        return result;
    }
    
    //get  Department
    public List getNodeManage(Session session){
    	String HQL = "select n from BoRole as n  order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }
    
    //get  Department
    public List getList(Session session){
    	String HQL = "select n from BoRole as n where n.id <> '0' order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }
    
    public BoRole getNodeParent(String id,Session session){
        BoRole node = getBoRole(id,session);
        BoRole parent = getBoRole(node.getParentId(),session);
        return parent;
    }
    
    public boolean hasBoRole(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoRole as n where n.id = '"+id+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }

    public boolean hasChildBoRole(BoRole n,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoRole as n where n.parentId = '"+n.getId()+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }
    
    public boolean canDeleteBoRole(String id,Session session){
    	boolean result = false;    
    	boolean result1 = false;  
    	String HQL = "select count(*) from BoRole as n where n.parentId = '"+id+"'";
 	    Integer count = Integer.parseInt(load(HQL,session).toString());
 	    if (count>0) result = true;
    	String HQL1 = "select count(*) from BoPerson as n where n.roleId = '"+id+"'";
    	Integer count1 = Integer.parseInt(load(HQL1,session).toString());
    	 if (count1>0) result1 = true;
    	return !(result|result1);
    }
    
    public Integer getMaxDispIndex(Session session){
    	String HQL = "select MAX (n.dispIndex) from BoRole as n ";
    	return Integer.parseInt(load(HQL,session).toString());
    }
    

    public void moveUp(String id,Session session){
    	BoRole fb = getNodeParent(id,session);
    	BoRole now = getBoRole(id,session);
    	String HQL = "select MAX (n.dispIndex) from BoRole as n where n.parentId = '"+fb.getId()+"' and n.dispIndex <"+now.getDispIndex();  	
    	Integer disp = Integer.parseInt(load(HQL,session).toString());
    	String HQL1 = "select n from BoRole as n where  n.dispIndex ="+disp;  	
    	BoRole n = (BoRole) load(HQL1,session);
    	n.setDispIndex(now.getDispIndex());
    	now.setDispIndex(disp);
    	session.update(now);
    	session.update(n);
    }
     
    public void moveDown(String id,Session session){
    	BoRole fb = getNodeParent(id,session);
    	BoRole now = getBoRole(id,session);
    	String HQL = "select MIN (n.dispIndex) from BoRole as n where n.parentId = '"+fb.getId()+"' and n.dispIndex >"+now.getDispIndex();  	
    	Integer disp = Integer.parseInt(load(HQL,session).toString());
    	String HQL1 = "select n from BoRole as n where  n.dispIndex ="+disp;  	
    	BoRole n = (BoRole) load(HQL1,session);
    	n.setDispIndex(now.getDispIndex());
    	now.setDispIndex(disp);	
    	session.update(now);
    	session.update(n);
    }
    
    public List getChild(String id,Session session){
	    String HQL = "select n from BoRole as n where n.parentId = '"+id+"'";
	    Query query = session.createQuery(HQL);
        return query.list();
    }
    

}
