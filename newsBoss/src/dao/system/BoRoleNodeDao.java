package dao.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.base.BaseDao;
import model.system.BoRoleNode;

public class BoRoleNodeDao extends BaseDao{
    
	public void addBoRoleNode(BoRoleNode n,Session session){
		session.saveOrUpdate(n);
	}
	
	public void updateBoRoleNode(BoRoleNode n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public void deleteBoRoleNode(String id,Session session){
        BoRoleNode node = (BoRoleNode) session.load(BoRoleNode.class, id);
        session.delete(node);
    }
    
    public BoRoleNode getBoRoleNode(String id,Session session){
    	BoRoleNode b = null;
        b = (BoRoleNode)session.load(BoRoleNode.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    public boolean hasBoRoleNode(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoRoleNode as n where n.id = '"+id+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }
    
    public boolean hasBoRoleNode(String roleId,String nodeId,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoRoleNode as n where n.roleId = '"+roleId+"' and n.nodeId= '"+nodeId+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }
    
    
    
    //get  Department
    public List getList(Session session){
    	String HQL = "select n from BoRoleNode as n where n.id <> '0' order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }

    
    public List getListByRoleId(String roleId,Session session){
    	String HQL = "select n from BoRoleNode as n where n.roleId = '"+roleId+"'";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }
    
    public List getRootListByRoleId(String roleId,Session session){
    	String HQL = "select n from BoRoleNode as n where n.roleId = '"+roleId+"'";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        List list = new ArrayList();
        for(Iterator it = father.iterator();it.hasNext();)
        {
        	BoRoleNode b = (BoRoleNode)it.next();
        	String HQL1 = "select n from BoNode as n where n.id = '"+b.getNodeId()+"' and n.parentId='0'";
        	Query query1 = session.createQuery(HQL1);
            List father1  = query1.list();
            list.addAll(father1);
        }
        return list;
    }
    
    
    public List getChildListByRoleId(String roleId,Session session){
    	String HQL = "select n from BoRoleNode as n where n.roleId = '"+roleId+"'";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        List list = new ArrayList();
        for(Iterator it = father.iterator();it.hasNext();)
        {
        	BoRoleNode b = (BoRoleNode)it.next();
        	String HQL1 = "select n from BoNode as n where n.id = '"+b.getNodeId()+"' and n.parentId<>'0'";
        	Query query1 = session.createQuery(HQL1);
            List father1  = query1.list();
            list.addAll(father1);
        }
        return list;
    }
}
