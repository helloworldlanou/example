package dao.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.base.BaseDao;
import model.system.BoNode;

public class BoNodeDao extends BaseDao{
    
	public void addBoNode(BoNode n,Session session){
		session.saveOrUpdate(n);
	}
	
	public void updateBoNode(BoNode n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public void deleteBoNode(String id,Session session){
        BoNode node = (BoNode) session.load(BoNode.class, id);
        session.delete(node);
    }
    
    public BoNode getBoNode(String id,Session session){
    	BoNode b = null;
        b = (BoNode)session.load(BoNode.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    public boolean canUp(String id,Session session){
    	
        boolean result = false;
        BoNode node = getBoNode(id,session);
        String HQL = "select MIN (n.dispIndex) from BoNode as n where n.parentId = '"+node.getParentId()+"'";
        Integer minid = Integer.parseInt(load(HQL,session).toString());
        if (node.getDispIndex()>minid)
            result = true;
        return result;
    }
    
    public boolean canDown(String id,Session session){
        boolean result = false;
        BoNode node = getBoNode(id,session);
        String HQL = "select MAX (n.dispIndex) from BoNode as n where n.parentId = '"+node.getParentId()+"'";
        Integer maxid = Integer.parseInt(load(HQL,session).toString());
        if (node.getDispIndex()<maxid)
            result = true;
        return result;
    }
    
   //Menu
    public List getNodeChildByPid(String id,Session session,List cap){
    	//List cap = new ArrayList();
    	String HQLfather = "select n from BoNode as n where n.parentId='"+id+"' and n.state <> 'hide' order by n.dispIndex";
    	Query query = session.createQuery(HQLfather);
        List father  = query.list();
        if(!cap.containsAll(father)){
        cap.addAll(father);
        }
        for(Iterator fa = father.iterator();fa.hasNext();){
        	BoNode b = (BoNode)fa.next();
        	String HQLchild = "select n from BoNode as n where n.parentId='"+b.getId()+"' and n.state <> 'hide'  order by n.dispIndex";
        	cap.addAll(session.createQuery(HQLchild).list());  
        	getNodeChildByPid(b.getId(),session,cap);
        }
        java.util.Collections.sort(cap);
        return cap;
    }
    //Manage
    public List getNodeManage(Session session){
    	List cap = new ArrayList();
    	String HQLfather = "select n from BoNode as n where n.type='father' order by n.dispIndex";
        Query query = session.createQuery(HQLfather);
        List father  = query.list();
        cap.addAll(father);
        for(Iterator fa = father.iterator();fa.hasNext();){
        	BoNode b = (BoNode)fa.next();
        	String HQLchild = "select n from BoNode as n where n.parentId='"+b.getId()+"' and n.type='child' order by n.dispIndex";
        	cap.addAll(session.createQuery(HQLchild).list());
        }
        java.util.Collections.sort(cap);
        return cap;
    }
    
    public BoNode getNodeParent(String id,Session session){
        BoNode node = getBoNode(id,session);
        BoNode parent = getBoNode(node.getParentId(),session);
        return parent;
    }
    
    public boolean hasBoNode(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoNode as n where n.id = '"+id+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }

    public boolean hasChildBoNode(BoNode n,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoNode as n where n.parentId = '"+n.getId()+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }
    
    public Integer getMaxDispIndex(Session session){
    	String HQL = "select MAX (n.dispIndex) from BoNode as n ";
    	return Integer.parseInt(load(HQL,session).toString());
    }
    

    public void moveUp(String id,Session session){
    	BoNode fb = getNodeParent(id,session);
    	BoNode now = getBoNode(id,session);
    	String HQL = "select MAX (n.dispIndex) from BoNode as n where n.parentId = '"+fb.getId()+"' and n.dispIndex <"+now.getDispIndex();  	
    	Integer disp = Integer.parseInt(load(HQL,session).toString());
    	String HQL1 = "select n from BoNode as n where  n.dispIndex ="+disp;  	
    	BoNode n = (BoNode) load(HQL1,session);
    	n.setDispIndex(now.getDispIndex());
    	now.setDispIndex(disp);
    	session.update(now);
    	session.update(n);
    }
     
    public void moveDown(String id,Session session){
    	BoNode fb = getNodeParent(id,session);
    	BoNode now = getBoNode(id,session);
    	String HQL = "select MIN (n.dispIndex) from BoNode as n where n.parentId = '"+fb.getId()+"' and n.dispIndex >"+now.getDispIndex();  	
    	Integer disp = Integer.parseInt(load(HQL,session).toString());
    	String HQL1 = "select n from BoNode as n where  n.dispIndex ="+disp;  	
    	BoNode n = (BoNode) load(HQL1,session);
    	n.setDispIndex(now.getDispIndex());
    	now.setDispIndex(disp);	
    	session.update(now);
    	session.update(n);
    }
    
    public List getChild(String id,Session session){
	    String HQL = "select n from BoNode as n where n.parentId = '"+id+"'";
	    Query query = session.createQuery(HQL);
        return query.list();
    }
    
    public List getNodeFatherRoot(Session session){
    	String HQL = "select n from BoNode as n where n.parentId ='0' order by n.dispIndex";
    	Query query = session.createQuery(HQL);
    	List list = query.list();
        return list;
    }

}
