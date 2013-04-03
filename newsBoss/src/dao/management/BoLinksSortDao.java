package dao.management;

import java.util.List;

import model.management.BoLinks;
import model.management.BoLinksSort;

import model.system.BoNode;
import model.system.PageList;


import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.base.BaseDao;

public class BoLinksSortDao extends BaseDao{
	/**
	 * 
	 * @author WangZ
	 * @param n 添加的连接对象
	 * @param session
	 */
	public void addBoLinksSort(BoLinksSort n,Session session){
		session.saveOrUpdate(n);
	}
	public void updateBoLinksSort(BoLinksSort n,Session session){
		session.saveOrUpdate(n);
	}
	public void deleteBoLinksSort(String id,Session session){
		BoLinksSort node = (BoLinksSort) session.load(BoLinksSort.class, id);
		session.delete(node);
	}
	public BoLinksSort getBoLinksSort(String id,Session session){
		BoLinksSort b = null;
		b = (BoLinksSort)session.load(BoLinksSort.class, id);
		Hibernate.initialize(b);
		return b;
	}
    public boolean hasBoLinksSort(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoLinksSort as n where  n.id = '"+id+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = true;
        return result;
    }
    /**
     * 获取所有的 链接 信息
     * @author WZ
     * @param session
     */
	public List getAllBoLinksSort(Session session) {
		List list = query("select n from BoLinksSort as n where n.id !='0' order by n.serial",session).list();
		return list;
	}
	public int getBoLinksSortNum(Session session) {		
		String HQL = "select count(*) from BoLinksSort n where n.id !='0' ";
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}
	public List getBoLinksSortList(PageList pageList,Session session) {

		String HQL = "select n from BoLinksSort n where n.id !='0' " ;
		List list = query(HQL, (pageList.getPagenum() - 1)* pageList.getFetch(), pageList.getFetch(),session).list();
		return list;
	}
	/**
	 * @author WZ
	 * 获取排序序列的最大值
	 */
	public int getMaxSerial(Session session) {
		
		String HQL = "select Max (n.serial) from BoLinksSort as n  ";
		return Integer.parseInt(load(HQL,session).toString());
		
	}
	/**
	 * 获取当前类别下的链接
	 * @param sortid 类别的id
	 * @return
	 */
	public List getthisBoLinksList(String sortid,Session session) {
		String HQL = "select n from BoLinks n where n.id !='0' and n.boLinksSort.id='"+sortid+"' order by n.time" ;
		List list = query(HQL,session).list();
		return list;
	}
	/**
	 * 获取当前类别下链接的数目
	 * @param sortid 类别的id
	 * @return
	 */
	public int getthisBoLinksNum(String sortid,Session session) {		
		String HQL = "select count(*) from BoLinks n where n.id !='0' and n.boLinksSort.id='"+sortid+"'";
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}
	public void moveUp(String id,Session session){
		String HQL="select n from BoLinksSort n where n.id='"+id+"'";
		BoLinksSort base = (BoLinksSort)load(HQL,session);
		
		String HQL1="select Max(n.serial) from BoLinksSort n where  n.serial<"+base.getSerial();
		int serial = Integer.parseInt(load(HQL1,session).toString());
		String HQL2="select n from BoLinksSort n where n.serial="+serial;
		BoLinksSort n = (BoLinksSort) load(HQL2,session);
		n.setSerial(base.getSerial());
    	base.setSerial(serial);
    	session.update(base);
    	session.update(n);
	}
	public void moveDown(String id,Session session){
		String HQL="select n from BoLinksSort n where n.id='"+id+"'";
		BoLinksSort base = (BoLinksSort)load(HQL,session);
		
		String HQL1="select Min(n.serial) from BoLinksSort n where  n.serial>"+base.getSerial();
		int serial = Integer.parseInt(load(HQL1,session).toString());
		String HQL2="select n from BoLinksSort n where n.serial="+serial;
		BoLinksSort n = (BoLinksSort) load(HQL2,session);
		n.setSerial(base.getSerial());
    	base.setSerial(serial);
    	session.update(base);
    	session.update(n);
	}

    
}
