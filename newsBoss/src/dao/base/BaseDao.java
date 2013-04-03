package dao.base;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

public class BaseDao {
    

    
    public Query query(String HQL,Session session){
        Query query = session.createQuery(HQL);
        return query;
    }
    
    
     
    public Query query(String HQL,int firstResult,int fetchSize,Session session){
        Query query = session.createQuery(HQL);
        query.setFirstResult(firstResult);
        query.setMaxResults(fetchSize);
        return query;
    }
    
    
    public Object load(Class c,String id,Session session){
        Object o = (Object) session.load(c, id);
        Hibernate.initialize(o);
        return o;
    }
    //去有关数字的时候用这个
    public Object load(String queryString,Session session){
    	Object o = null;
        Query query = session.createQuery(queryString);
        query.setFirstResult(0);
        query.setFetchSize(1);
        List list = query.list();
        if(list.size()>0){
        	o = list.get(0);
        }
        Hibernate.initialize(o);
        return o;
    }
    
    public void saveOrUpdate(Object o,Session session){
        session.saveOrUpdate(o);
    }
    
    public void delete(Object o,Session session){
        session.delete(o);
    }
    
    public void update(Object o,Session session){
        session.update(o);
    }
    
    public void execute(String HQL,Session session){
    	Query query = session.createQuery(HQL);
    	query.executeUpdate();
    }
    
    public static void main(String[] args) {
    	
    }

}
