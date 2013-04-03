package dao.management;

import java.util.List;

import model.management.BoLinks;
import model.management.BoLinksSort;
import model.management.BoSpecial;

import model.system.PageList;


import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.base.BaseDao;
/**
 * 专题操作的Dao
 * @author WZ
 *
 */
public class BoSpecialDao extends BaseDao{

	public void addBoSpecial(BoSpecial n,Session session){
		session.saveOrUpdate(n);
	}
	public void updateBoSpecial(BoSpecial n,Session session){
		session.saveOrUpdate(n);
	}
	public void deleteBoSpecial(String id,Session session){
		BoSpecial node = (BoSpecial) session.load(BoSpecial.class, id);
		session.delete(node);
	}
	public BoSpecial getBoSpecial(String id,Session session){
		BoSpecial b = null;
		b = (BoSpecial)session.load(BoSpecial.class, id);
		Hibernate.initialize(b);
		return b;
	}
    public boolean hasBoSpecial(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoSpecial as n where  n.id = '"+id+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = true;
        return result;
    }
    /**
     * 获取所有的 专题 信息
     * @author WZ
     * @param session
     */
	public List getAllBoSpecial(Session session) {
		List list = query("select n from BoSpecial as n where n.id !='0' and n.parentid='0' order by n.serial ",session).list();
		return list;
	}
	
	
	public List getSmallBoSpecial(Session session) {
		List list = query("select n from BoSpecial as n where n.id !='0' and n.parentid!='0' order by n.serial ",session).list();
		return list;
	}
	
	public List getSmallBoSpecialByPid(String pid,Session session) {
		List list = query("select n from BoSpecial as n where n.id !='0' and n.parentid='"+pid+"' order by n.serial ",session).list();
		return list;
	}
	
	public int getBoSpecialNum(Session session) {
		
		String HQL = "select count(*) from BoSpecial n where n.id !='0' ";
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}
	public List getBoSpecialList(PageList pageList,Session session) {

		String HQL = "select n from BoSpecial n where n.id !='0' order by n.serial "  ;
		List list = query(HQL, (pageList.getPagenum() - 1)* pageList.getFetch(), pageList.getFetch(),session).list();
		return list;
	}
	
	public int getMaxSerial(Session session) {
		
		String HQL = "select Max (n.serial) from BoSpecial as n  ";
		return Integer.parseInt(load(HQL,session).toString());
		
	}
	
	
	public int getSpecialNumByPid(String pid,Session session) {
		
		String HQL = "select count(*) from BoSpecial as n where n.parentid  ='"+pid+"'";
		return Integer.parseInt(load(HQL,session).toString());
		
	}
	
	public void moveUp(String id,Session session){
		String HQL="select n from BoSpecial n where n.id='"+id+"'";
		BoSpecial base = (BoSpecial)load(HQL,session);
		
		String HQL1="select Max(n.serial) from BoSpecial n where  n.serial<"+base.getSerial();
		int serial = Integer.parseInt(load(HQL1,session).toString());
		String HQL2="select n from BoSpecial n where n.serial="+serial;
		BoSpecial n = (BoSpecial) load(HQL2,session);
		n.setSerial(base.getSerial());
    	base.setSerial(serial);
    	session.update(base);
    	session.update(n);
	}
	public void moveDown(String id,Session session){
		String HQL="select n from BoSpecial n where n.id='"+id+"'";
		BoSpecial base = (BoSpecial)load(HQL,session);
		
		String HQL1="select Min(n.serial) from BoSpecial n where  n.serial>"+base.getSerial();
		int serial = Integer.parseInt(load(HQL1,session).toString());
		String HQL2="select n from BoSpecial n where n.serial="+serial;
		BoSpecial n = (BoSpecial) load(HQL2,session);
		n.setSerial(base.getSerial());
    	base.setSerial(serial);
    	session.update(base);
    	session.update(n);
	}
    
}
