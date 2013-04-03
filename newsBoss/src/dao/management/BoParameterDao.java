package dao.management;

import dao.base.BaseDao;
import exception.BoException;
import model.management.BoParameter;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.hibernate.HibernateSessionFactory;

public class BoParameterDao extends BaseDao {
	
	public void updateBoParameter(BoParameter n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public BoParameter getBoParameter(String id,Session session){
    	BoParameter b = null;
        b = (BoParameter)session.load(BoParameter.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    public boolean hasBoParameter(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoParameter as n where  n.id = '"+id+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = true;
        return result;
    }

}
