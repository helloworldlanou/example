package dao.facility;

import java.util.List;

import model.facility.BoFacility;
import model.system.PageList;

import org.hibernate.Hibernate;
import org.hibernate.Session;


import dao.base.BaseDao;

public class BoFacilityDao extends BaseDao{
	public void addBoFacility(BoFacility n,Session session){
		session.saveOrUpdate(n);
	}
	
	public void updateBoFacility(BoFacility n,Session session){
		session.saveOrUpdate(n);
	}	
	
    public void deleteBoFacility(String id,Session session){
        BoFacility node = (BoFacility) session.load(BoFacility.class, id);
        session.delete(node);
    }
    
    public BoFacility getBoFacility(String id,Session session){
    	BoFacility b = null;
        b = (BoFacility)session.load(BoFacility.class, id);
        Hibernate.initialize(b);
        return b;
    }
    
    
    public boolean hasBoFacility(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoFacility as n where  n.id = '"+id+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = true;
        return result;
    }
    
	public List getAllBoFacility(Session session) {
		List list = query("select n from BoFacility as n ",session).list();
		return list;
	}
	
	public int getBoFacilityNum(PageList pageList,Session session) {
		
		String HQL = "";
		if(pageList.getQ1().length()==0||pageList.getQ1().equals("-1")){
			HQL = "select count(*) from BoFacility n ";
		}
		else
		{
			HQL = "select count(*) from BoFacility n where n.boFacilityType.id = '"+pageList.getQ1()+"'";
		}
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}


	
	public List getBoFacilityList(PageList pageList,Session session) {

		String HQL = "";
		if(pageList.getQ1().length()==0||pageList.getQ1().equals("-1")){
			HQL = "select n from BoFacility n ";
		}
		else
		{
			HQL = "select n from BoFacility n where n.boFacilityType.id = '"+pageList.getQ1()+"'";
		}
		List list = query(HQL, (pageList.getPagenum() - 1)* pageList.getFetch(), pageList.getFetch(),session).list();
		Hibernate.initialize(list);
		return list;
	}



}
