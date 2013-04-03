package dao.management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.base.BaseDao;
import model.management.BoNavigation;

public class BoNavigationDao extends BaseDao{
    
	public void addBoNavigation(BoNavigation n,Session session){
		session.saveOrUpdate(n);
	}
	
	public void updateBoNavigation(BoNavigation n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public void deleteBoNavigation(String id,Session session){
    	BoNavigation node = (BoNavigation) session.load(BoNavigation.class, id);
        session.delete(node);
    }
    
    public BoNavigation getBoNavigation(String id,Session session){
    	BoNavigation b = null;
        b = (BoNavigation)session.load(BoNavigation.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    
    public BoNavigation getCheckedBoNavigation(Session session){
    	BoNavigation b = null;
    	String HQL = "select n from BoNavigation as n  where n.defaultchecked = 'checked' ";
        List list = session.createQuery(HQL).list();
        if(list.size()>0)
        {
        	b = (BoNavigation)list.get(0);
        }
        return b;
    }
    
    public List getBoNavigationRootList(Session session){
    	String HQL = "select n from BoNavigation as n  where n.parentId = '0' order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List b  = query.list();     
        return b;
    }
    
    public List getBoNavigationListByParentId(String pid,Session session){
    	String HQL = "select n from BoNavigation as n  where n.parentId = '"+pid+"' order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List b  = query.list();     
        return b;
    }
    
    public boolean canUp(String id,Session session){
    	
        boolean result = false;
        BoNavigation node = getBoNavigation(id,session);
        String HQL = "select MIN (n.dispIndex) from BoNavigation as n where n.parentId = '"+node.getParentId()+"'";
        Integer minid = Integer.parseInt(load(HQL,session).toString());
        if (node.getDispIndex()>minid)
            result = true;
        return result;
    }
    
    public boolean canDown(String id,Session session){
        boolean result = false;
        BoNavigation node = getBoNavigation(id,session);
        String HQL = "select MAX (n.dispIndex) from BoNavigation as n where n.parentId = '"+node.getParentId()+"'";
        Integer maxid = Integer.parseInt(load(HQL,session).toString());
        if (node.getDispIndex()<maxid)
            result = true;
        return result;
    }
    
    //get All Navigation
    public List getNodeManage(Session session){
    	String HQL = "select n from BoNavigation as n order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }
    
    public List getNodeManageSmall(Session session){    //获得小类中属于info型list
    	String HQL = "select n from BoNavigation as n where n.id != '0' and n.type ='info' and n.parentId !='0' order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }
    public List getinfoSmall(String id,Session session){    //获得大类id中属于info型的小类list
    	String HQL = "select n from BoNavigation as n where n.id != '0' and n.type ='info' and n.parentId ='"+id+"' order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }
    
	public int getBoNavigationSmallnum(String s, Session session) {   //获取大类中存在info型新闻的小类条数

		String HQL = "select count(*) from BoNavigation as n where n.parentId ='"	+ s+ "' and n.type = 'info' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}
	public int getBoNavigationSmallnotinfonum(String s, Session session) {   //获取大类中不是info型新闻的小类条数

		String HQL = "select count(*) from BoNavigation as n where n.parentId ='"	+ s+ "' and n.type != 'info' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}
	
    public BoNavigation getNodeParent(String id,Session session){
    	BoNavigation node = getBoNavigation(id,session);
    	BoNavigation parent = getBoNavigation(node.getParentId(),session);
        return parent;
    }
    
    public boolean hasBoNavigation(String id ,Session session){
    	//有没有id节点？
    	boolean result = false;    
	    String HQL = "select count(*) from BoNavigation as n where n.id = '"+id+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }

    public boolean hasChildBoNavigation(BoNavigation n,Session session){
    	//n节点有没有子节点？
    	boolean result = false;    
	    String HQL = "select count(*) from BoNavigation as n where n.parentId = '"+n.getId()+"'";
	    Integer count = Integer.parseInt(load(HQL,session).toString());
	    if (count>0) result = true;
        return result;
    }
    
    public boolean canDeleteBoNavigation(String id,Session session){
    	//id节点能否删除？
    	boolean result = false;    
    	boolean result1 = false;  
    	String HQL = "select count(*) from BoNavigation as n where n.parentId = '"+id+"'";
 	    Integer count = Integer.parseInt(load(HQL,session).toString());
 	    if (count>0) result = true;
    	String HQL1 = "select count(*) from BoPerson as n where n.parentId = '"+id+"'";
    	Integer count1 = Integer.parseInt(load(HQL1,session).toString());
    	 if (count1>0) result1 = true;
    	return !(result|result1);
    }
    
    public Integer getMaxDispIndex(Session session){
    	//获得最大序列号
    	String HQL = "select MAX (n.dispIndex) from BoNavigation as n ";
    	return Integer.parseInt(load(HQL,session).toString());
    }
    

    public void moveUp(String id,Session session){
    	BoNavigation fb = getNodeParent(id,session);
    	BoNavigation now = getBoNavigation(id,session);
    	String HQL = "select MAX (n.dispIndex) from BoNavigation as n where n.parentId = '"+fb.getId()+"' and n.dispIndex <"+now.getDispIndex();  	
    	Integer disp = Integer.parseInt(load(HQL,session).toString());
    	String HQL1 = "select n from BoNavigation as n where  n.dispIndex ="+disp;  	
    	BoNavigation n = (BoNavigation) load(HQL1,session);
    	n.setDispIndex(now.getDispIndex());
    	now.setDispIndex(disp);
    	session.update(now);
    	session.update(n);
    }
     
    public void moveDown(String id,Session session){
    	BoNavigation fb = getNodeParent(id,session);
    	BoNavigation now = getBoNavigation(id,session);
    	String HQL = "select MIN (n.dispIndex) from BoNavigation as n where n.parentId = '"+fb.getId()+"' and n.dispIndex >"+now.getDispIndex();  	
    	Integer disp = Integer.parseInt(load(HQL,session).toString());
    	String HQL1 = "select n from BoNavigation as n where  n.dispIndex ="+disp;  	
    	BoNavigation n = (BoNavigation) load(HQL1,session);
    	n.setDispIndex(now.getDispIndex());
    	now.setDispIndex(disp);	
    	session.update(now);
    	session.update(n);
    }
    
    public List getChild(String id,Session session){
    	//获得id节点子节点
	    String HQL = "select n from BoNavigation as n where n.parentId = '"+id+"'";
	    Query query = session.createQuery(HQL);
        return query.list();
    }
    
    public List getCustomNavigatorList(Session session){
	    String HQL = "select n from BoNavigation as n where n.type = 'custom' and n.parentId!=0";
	    Query query = session.createQuery(HQL);
        return query.list();
    }

    public List getSecondNodeList(Session session){
    	String HQL = "select n from BoNavigation as n where n.parentId !='0' and n.parentId !='-1' order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List father  = query.list();
        return father;
    }
    
    public List getBoNavigationListCenterShow(Session session){
    	String HQL = "select n from BoNavigation as n  where n.centershow = 'yes' order by n.dispIndex";
        Query query = session.createQuery(HQL);
        List b  = query.list();     
        return b;
    }
    
}
