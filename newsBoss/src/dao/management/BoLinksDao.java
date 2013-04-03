package dao.management;

import java.util.List;

import model.management.BoLinks;

import model.system.PageList;


import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.base.BaseDao;

public class BoLinksDao extends BaseDao{
	/**
	 * 
	 * @author WangZ
	 * @param n 添加的连接对象
	 * @param session
	 */
	public void addBoLinks(BoLinks n,Session session){
		session.saveOrUpdate(n);
	}
	public void updateBoLinks(BoLinks n,Session session){
		session.saveOrUpdate(n);
	}
	public void deleteBoLinks(String id,Session session){
		BoLinks node = (BoLinks) session.load(BoLinks.class, id);
		session.delete(node);
	}
	public BoLinks getBoLinks(String id,Session session){
		BoLinks b = null;
		b = (BoLinks)session.load(BoLinks.class, id);
		Hibernate.initialize(b);
		return b;
	}
    public boolean hasBoLinks(String id ,Session session){
    	boolean result = false;    
	    String HQL = "select count(*) from BoLinks as n where  n.id = '"+id+"'";
	    Integer count = ((Long) load(HQL,session)).intValue();
	    if (count>0) result = true;
        return result;
    }
    /**
     * 获取所有的 链接 信息
     * @author WZ
     * @param session
     */
	public List getAllBoLinks(Session session) {
		List list = query("select n from BoLinks as n where n.id !='0' order by n.boLinksSort.serial,n.time ",session).list();
		return list;
	}
	public int getBoLinksNum(Session session) {
		
		String HQL = "select count(*) from BoLinks n where n.id !='0' ";
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}
	public List getBoLinksList(PageList pageList,Session session) {

		String HQL = "select n from BoLinks n where n.id !='0' order by n.boLinksSort.serial,n.time"  ;
		List list = query(HQL, (pageList.getPagenum() - 1)* pageList.getFetch(), pageList.getFetch(),session).list();
		return list;
	}
    
}
