package dao.system;

import java.util.List;

import model.system.BoPerson;
import model.system.PageList;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import service.system.BoPersonService;
import util.hibernate.HibernateSessionFactory;

import dao.base.BaseDao;
import exception.BoException;

public class BoPersonDao extends BaseDao{
	public void addBoPerson(BoPerson n,Session session){
		session.saveOrUpdate(n);
	}
	
	public void updateBoPerson(BoPerson n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public void deleteBoPerson(String id,Session session){
        BoPerson node = (BoPerson) session.load(BoPerson.class, id);
        session.delete(node);
    }
    
    public BoPerson getBoPerson(String id,Session session){
    	BoPerson b = null;
        b = (BoPerson)session.load(BoPerson.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    public Integer getMaxDispIndex(Session session){
    	String HQL = "select MAX (n.dispIndex) from BoPerson as n ";
    	return Integer.parseInt(load(HQL,session).toString());
    }
    
    public boolean hasBoPerson(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoPerson as n where  n.id = '"+id+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = true;
        return result;
    }
    
	public List getAllBoPerson(Session session) {
		List list = query("select n from BoPerson as n where n.id !='0' order by n.depName,n.registerTime",session).list();
		return list;
	}
	
	public int getBoPersonNum(PageList pageList,Session session) {
		
		String HQL = "select count(*) from BoPerson n where n.id !='0' ";
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}

	public List getBoPersonByParentId(String id,Session session) {		
		String HQL = "select n from BoPerson as n where n.parentId = '" + id +"'";
		List list = query(HQL,session).list();
		return list;
	}
	
	public List getBoPersonByRoleId(String id,Session session) {		
		String HQL = "select n from BoPerson as n where n.roleId = '" + id +"'";
		List list = query(HQL,session).list();
		return list;
	}
	
	public List getBoPersonList(PageList pageList,Session session) {

		String HQL = "select n from BoPerson n where n.id !='0' " ;
		List list = query(HQL, (pageList.getPagenum() - 1)* pageList.getFetch(), pageList.getFetch(),session).list();
		return list;
	}
	
	public List checkPwd(Session session,String user,String pwd) {
		String x = util.encode.MD5.encode2(pwd);
		String HQL = "select n from BoPerson n where n.userName='"+user+"' and n.password='"+x+"'" ;
		List list = query(HQL,session).list();
		return list;
	}


}
