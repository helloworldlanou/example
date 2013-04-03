package dao.facility;

import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import model.facility.BoFacilityType;
import model.system.PageList;

import org.hibernate.Hibernate;
import org.hibernate.Session;


import dao.base.BaseDao;

public class BoFacilityTypeDao extends BaseDao{
	public void addBoFacilityType(BoFacilityType n,Session session){
		session.saveOrUpdate(n);
	}
	
	public void updateBoFacilityType(BoFacilityType n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public void deleteBoFacilityType(String id,Session session){
        BoFacilityType node = (BoFacilityType) session.load(BoFacilityType.class, id);
        session.delete(node);
    }
    
    public BoFacilityType getBoFacilityType(String id,Session session){
    	BoFacilityType b = null;
        b = (BoFacilityType)session.load(BoFacilityType.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    
    public boolean hasBoFacilityType(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoFacilityType as n where  n.id = '"+id+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = true;
        return result;
    }
    
	public List getAllBoFacilityType(Session session) {
		List list = query("select n from BoFacilityType as n ",session).list();
		return list;
	}
	
	public int getBoFacilityTypeNum(PageList pageList,Session session) {
		
		String HQL = "select count(*) from BoFacilityType n ";
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}


	
	public List getBoFacilityTypeList(PageList pageList,Session session) {

		String HQL = "select n from BoFacilityType n " ;
		List list = query(HQL, (pageList.getPagenum() - 1)* pageList.getFetch(), pageList.getFetch(),session).list();
		List b = new ArrayList();
		for(Object n : list)
		{
			Hibernate.initialize(n);
			b.add(n);
		}
		return b;
	}
	
	

	public boolean canDelete(String tid,Session session) {
    	boolean result = true;    
	    String HQL = "select count(*) from BoFacility as n where  n.boFacilityType.id = '"+tid+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = false;
        return result;
        
        
	}
	
	public boolean hasNid(String nid,Session session) {
    	boolean result = false;    
	    String HQL = "select count(*) from BoFacilityType as n where  n.boNavigation.id = '"+nid+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = true;
        return result;
        
        
	}
	
	
	public BoFacilityType getByNid(String nid,Session session) {
    	boolean result = true;    
	    String HQL = "select n from BoFacilityType as n where  n.boNavigation.id = '"+nid+"'";
		List list = query(HQL,session).list();
        return (BoFacilityType)list.get(0);

	}

}
