package dao.news;

import java.util.List;

import model.management.BoLinks;
import model.news.BoNews;
import model.system.PageList;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import dao.base.BaseDao;

public class BoNewsDao extends BaseDao {
	/**
	 * 
	 * @author WangZ
	 * @param n
	 *            添加的连接对象
	 * @param session
	 */
	public void addBoNews(BoNews n, Session session) {
		session.saveOrUpdate(n);
	}

	public void updateBoNews(BoNews n, Session session) {
		session.saveOrUpdate(n);
	}

	public void deleteBoNews(String id, Session session) {
		BoNews node = (BoNews) session.load(BoNews.class, id);
		session.delete(node);
	}

	public BoNews getBoNews(String id, Session session) {
		BoNews b = null;
		b = (BoNews) session.load(BoNews.class, id);
		Hibernate.initialize(b);
		return b;
	}

	public boolean hasBoNews(String id, Session session) {
		boolean result = false;
		String HQL = "select count(*) from BoNews as n where  n.id = '" + id
				+ "'";
		Integer count = ((Long) load(HQL, session)).intValue();
		if (count > 0)
			result = true;
		return result;
	}

	/**
	 * 获取所有的 链接 信息
	 * 
	 * @author WZ
	 * @param session
	 */
	public List getAllBoNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.id !='0' order by n.newsTime desc",
				session).list();
		return list;
	}
	/*public List getAllBoSmallNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.id !='0' and n.boNavigationByNewsSmall !='null' order by n.newsTime desc",
				session).list();
		return list;
	} */


	public List getBoPicNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.newsPicture = '1' and n.en = '0' and n.newsCheck = '1' order by n.newsTime desc",
				session).list();
		return list;
	}

	public List getBoCenterNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.boNavigationByNewsBig = '4a4cc0c91f6d690d011f6d6f773b0003' and n.boNavigationByNewsSmall = '4a4cc0ef1fff14f7011fff2a542d0003'  and n.newsCheck = '1'  and n.en = '0' order by n.newsTime desc",
				session).list();
		return list;
	}

	public List getBoTrainingNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.boNavigationByNewsBig = '4a4cc0c91f6d690d011f6d6f773b0003' and n.boNavigationByNewsSmall = '4a4cc0ef1fff14f7011fff2c2bbc0004' and n.newsCheck = '1'  and n.en = '0' order by n.newsTime desc",
				session).list();
		return list;
	}

	public List getBoProjectNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.boNavigationByNewsBig = '4a4cc0c91f6d690d011f6d6fe6800005' and n.boNavigationByNewsSmall = '4a4cc0c91f6d690d011f6d718dc70011' and n.newsCheck = '1'  and n.en = '0' order by n.newsTime desc",
				session).list();
		return list;
	}

	public List getEnBoPicNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.newsPicture = '1' and n.newsCheck = '1'   and n.en = '1' order by n.newsTime desc",
				session).list();
		return list;
	}

	public List getEnBoCenterNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.boNavigationByNewsBig = '4a4cc0c91f6d690d011f6d6f773b0003' and n.boNavigationByNewsSmall = '4a4cc0ef1fff14f7011fff2a542d0003'  and n.newsCheck = '1'  and n.en = '1' order by n.newsTime desc",
				session).list();
		return list;
	}

	public List getEnBoTrainingNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.boNavigationByNewsBig = '4a4cc0c91f6d690d011f6d6f773b0003' and n.boNavigationByNewsSmall = '4a4cc0ef1fff14f7011fff2c2bbc0004' and n.newsCheck = '1'  and n.en = '1' order by n.newsTime desc",
				session).list();
		return list;
	}

	public List getEnBoProjectNews(Session session) {
		List list = query(
				"select n from BoNews as n where n.boNavigationByNewsBig = '4a4cc0c91f6d690d011f6d6fe6800005' and n.boNavigationByNewsSmall = '4a4cc0c91f6d690d011f6d718dc70011' and n.newsCheck = '1'  and n.en = '1' order by n.newsTime desc",
				session).list();
		return list;
	}

	public int getBoNewsNumBySmallType(PageList pageList, Session session) {

		String HQL = "select count(*) from BoNews n where n.boNavigationByNewsSmall.id ='"
				+ pageList.getQ1() + "' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}

	public int getBoNewsNumByBigType(PageList pageList, Session session) {

		String HQL = "select count(*) from BoNews n where n.boNavigationByNewsBig.id ='"
				+ pageList.getQ1() + "' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}

	
	public List getBoNewsListByBigType(PageList pageList, Session session) {

		String HQL = "select n from BoNews n where n.boNavigationByNewsBig.id = '"
				+ pageList.getQ1() + "'";
		List list = query(HQL,
				(pageList.getPagenum() - 1) * pageList.getFetch(),
				pageList.getFetch(), session).list();
		return list;
	}

	public List getBoNewsListBySmallType(PageList pageList, Session session) {

		String HQL = "select n from BoNews n where n.boNavigationByNewsSmall.id = '"
				+ pageList.getQ1() + "'";
		List list = query(HQL,
				(pageList.getPagenum() - 1) * pageList.getFetch(),
				pageList.getFetch(), session).list();
		return list;
	}
	
	public List getBoNewsListBySpecial(PageList pageList, Session session) {

		String HQL = "select n from BoNews n where n.boSpecial.id = '"
				+ pageList.getQ1()+"'" ;
		if(pageList.getQ2().equals("en")){
			HQL=HQL+" and n.en='1' ";
		}else{
			HQL=HQL+" and n.en!='1'";
		}
		
		if(!pageList.getQ3().equals("")&&pageList.getQ3().equals("1")){
			HQL=HQL+" and n.newsCheck='1'";
		}
		HQL=HQL+" order by n.newsTime desc";
		List list = query(HQL,
				(pageList.getPagenum() - 1) * pageList.getFetch(),
				pageList.getFetch(), session).list();
		return list;
	}

	public BoNews getTopBoNews(Session session) {
		BoNews n = null;
		String HQL = "select n from BoNews n where n.newsTop = '1' and n.en='0'";
		List list = query(HQL, session).list();
		if (list.size() >= 1) {
			n = (BoNews) list.get(0);
		}
		return n;
	}

	public BoNews getTopBoNewsEn(Session session) {
		BoNews n = null;
		String HQL = "select n from BoNews n where n.newsTop = '1' and n.en ='1'";
		List list = query(HQL, session).list();
		if (list.size() >= 1) {
			n = (BoNews) list.get(0);
		}
		return n;
	}

	public int getBoNewsNumByBig(String id, Session session) {

		String HQL = "select count(*) from BoNews n where n.boNavigationByNewsBig.id ='"
				+ id + "' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}

	public int getBoNewsNumBySmall(String id, Session session) {

		String HQL = "select count(*) from BoNews n where n.boNavigationByNewsSmall.id ='"
				+ id + "' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}

	public int getBoNewsNumBySpecial(PageList pageList, Session session) {

		String HQL = "select count(*) from BoNews n where n.boSpecial.id ='"
				+ pageList.getQ1() + "' ";
		if(pageList.getQ2().equals("en")){
			HQL=HQL+" and n.en='1'";
		}	
		else
		{
			HQL=HQL+" and n.en!='1'";
		}
		
		if(!pageList.getQ3().equals("")&&pageList.getQ3().equals("1")){
			HQL=HQL+" and n.newsCheck='1'";
		}
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}
	public int getBoNewstNumBySpecial(String id, Session session) {

		String HQL = "select count(*) from BoNews n where n.boSpecial.id ='"
				+ id + "' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}
	
	public int isSpecialnullSmall(String id, Session session) {

		String HQL = "select count(*) from BoNews n where n.specialSmall.id ='"
				+ id + "' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}
	
	public int getinfonewsnum(String id, Session session) {

		String HQL = "select count(*) from BoNews n where n.boNavigationByNewsSmall.id ='"
				+ id + "' ";
		int count = ((Long) load(HQL, session)).intValue();
		return count;
	}
	
	// 后台维护分页算法

	public int getBoNewsNum(PageList pageList,Session session) {
		String HQL = "select count(*) from BoNews n where '1' = '1'";
		if(pageList.getQ1().length()==0&&pageList.getQ2().length()==0&&pageList.getQ3().length()==0&&pageList.getQ4().length()==0&&pageList.getQ5().length()==0&&pageList.getQ6().length()==0&&pageList.getQ7().length()==0&&pageList.getQ8().length()==0&&pageList.getQ9().length()==0)
		{
		 	;
		}
		else
		{
			if(pageList.getQ1().equals("-1"))
			{
				;
			}
			else
			{
				HQL += " and n.boNavigationByNewsBig.id='"+pageList.getQ1()+"' ";
				if(pageList.getQ2().equals("-1"))
				{
					;
				}
				else
				{
					HQL += " and n.boNavigationByNewsSmall.id='"+pageList.getQ2()+"' ";
				}
					
			}
			if(pageList.getQ3().equals("-1"))
			{
				;
			}
			else
			{
				HQL += " and n.boSpecial.id='"+pageList.getQ3()+"' ";
			}
			if(pageList.getQ10().equals("-1"))
			{
				;
			}
			else
			{
				HQL += " and n.specialSmall.id='"+pageList.getQ10()+"' ";
			}
			if(pageList.getQ4().length()>0)
			{
				HQL += " and n.newsTime >'"+pageList.getQ4()+"' ";
			}
			else
			{
				;
			}
			if(pageList.getQ5().length()>0)
			{
				HQL += " and n.newsTime <'"+pageList.getQ5()+"' ";
			}
			else
			{
				;
			}
			if(pageList.getQ6().equals("-1"))
			{
				;
			}
			else if(pageList.getQ6().equals("0"))
			{
				HQL += " and n.en ='0' ";
			}
			else
			{
				HQL += " and n.en ='1' ";
			}
			if(pageList.getQ7().equals("-1"))
			{
				;
			}
			else if(pageList.getQ7().equals("0"))
			{
				HQL += " and n.newsCheck ='0' ";
			}
			else
			{
				HQL += " and n.newsCheck ='1' ";
			}
			if(pageList.getQ8().equals("-1"))
			{
				;
			}
			else if(pageList.getQ8().equals("0"))
			{
				HQL += " and n.newsPicture ='0' ";
			}
			else
			{
				HQL += " and n.newsPicture ='1' ";
			}
			if(pageList.getQ9().trim().length()>0)
			{
				HQL += " and n.newsAuthor like '%"+pageList.getQ9().trim()+"%'";
			}
			else
			{
				;
			}
			
		}
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}

	public List getBoNewsList(PageList pageList, Session session) {

		String HQL = "select n from BoNews n where '1' = '1'"; 
		
		if(pageList.getQ1().length()==0&&pageList.getQ2().length()==0&&pageList.getQ3().length()==0&&pageList.getQ4().length()==0&&pageList.getQ5().length()==0&&pageList.getQ6().length()==0&&pageList.getQ7().length()==0&&pageList.getQ8().length()==0&&pageList.getQ9().length()==0)
		{
		 	;
		}
		else
		{
			if(pageList.getQ1().equals("-1"))
			{
				;
			}
			else
			{
				HQL += " and n.boNavigationByNewsBig.id='"+pageList.getQ1()+"' ";
				if(pageList.getQ2().equals("-1"))
				{
					;
				}
				else
				{
					HQL += " and n.boNavigationByNewsSmall.id='"+pageList.getQ2()+"' ";
				}
					
			}
			if(pageList.getQ3().equals("-1"))
			{
				;
			}
			else
			{
				HQL += " and n.boSpecial.id='"+pageList.getQ3()+"' ";
			}
			if(pageList.getQ10().equals("-1"))
			{
				;
			}
			else
			{
				HQL += " and n.specialSmall.id='"+pageList.getQ10()+"' ";
			}
			
			if(pageList.getQ4().length()>0)
			{
				HQL += " and n.newsTime >'"+pageList.getQ4()+"' ";
			}
			else
			{
				;
			}
			if(pageList.getQ5().length()>0)
			{
				HQL += " and n.newsTime <'"+pageList.getQ5()+"' ";
			}
			else
			{
				;
			}
			if(pageList.getQ6().equals("-1"))
			{
				;
			}
			else if(pageList.getQ6().equals("0"))
			{
				HQL += " and n.en ='0' ";
			}
			else
			{
				HQL += " and n.en ='1' ";
			}
			if(pageList.getQ7().equals("-1"))
			{
				;
			}
			else if(pageList.getQ7().equals("0"))
			{
				HQL += " and n.newsCheck ='0' ";
			}
			else
			{
				HQL += " and n.newsCheck ='1' ";
			}
			if(pageList.getQ8().equals("-1"))
			{
				;
			}
			else if(pageList.getQ8().equals("0"))
			{
				HQL += " and n.newsPicture ='0' ";
			}
			else
			{
				HQL += " and n.newsPicture ='1' ";
			}
			if(pageList.getQ9().trim().length()>0)
			{
				HQL += " and n.newsAuthor like '%"+pageList.getQ9().trim()+"%'";
			}
			else
			{
				;
			}
			
		}
		HQL +=" order by n.newsTime desc";
		List list = query(HQL,
				(pageList.getPagenum() - 1) * pageList.getFetch(),
				pageList.getFetch(), session).list();
		return list;
	}

	//over
	
	
	// Secondry Page 分页算法

	public int getBoNewsNumForSecondaryPage(PageList pageList,String en ,Session session) {
		String HQL = "select count(*) from BoNews n where '1' = '1'";
		if(pageList.getQ1().length()==0&&pageList.getQ2().length()==0)
		{
		 	;
		}
		else
		{
			if(pageList.getQ1().equals("-1"))
			{
				;
			}
			else
			{
				HQL += " and n.boNavigationByNewsBig.id='"+pageList.getQ1()+"' ";
				if(pageList.getQ2().equals("-1"))
				{
					;
				}
				else
				{
					HQL += " and n.boNavigationByNewsSmall.id='"+pageList.getQ2()+"' ";
				}
					
			}
			
		}
		HQL +=" and n.en='"+en+"' and n.newsCheck = '1'  ";
		int count = ((Long) load(HQL,session)).intValue();
		return count;
	}

	
	
	public List getBoNewsListForSecondaryPage(PageList pageList, String en ,Session session) {

		String HQL = "select n from BoNews n where '1' = '1'"; 
		
		if(pageList.getQ1().length()==0&&pageList.getQ2().length()==0)
		{
		 	;
		}
		else
		{
			if(pageList.getQ1().equals("-1"))
			{
				;
			}
			else
			{
				HQL += " and n.boNavigationByNewsBig.id='"+pageList.getQ1()+"' ";
				if(pageList.getQ2().equals("-1"))
				{
					;
				}
				else
				{
					HQL += " and n.boNavigationByNewsSmall.id='"+pageList.getQ2()+"' ";
				}
					
			}
		}
		HQL +=" and n.en='"+en+"'  and n.newsCheck = '1'   order by n.newsTime desc";
		List list = query(HQL,
				(pageList.getPagenum() - 1) * pageList.getFetch(),
				pageList.getFetch(), session).list();
		return list;
	}

	//over

	public BoNews getBoNewsBySmallType(String id, String en ,Session session)
	{
		BoNews n = new BoNews();
		String HQL ="select n from BoNews n  where n.boNavigationByNewsSmall.id = '"+id+"' and n.en='"+en+"'";
		List list= query(HQL,session).list();
		if(list.size()>0)
		{
			n = (BoNews)list.get(0);
		}
		return n;
	}
	
	public BoNews getBoNewsByBigType(String id, String en , Session session)
	{
		BoNews n = new BoNews();
		String HQL ="select n from BoNews n  where n.boNavigationByNewsBig.id =  '"+id+"' and n.en='"+en+"'";
		List list= query(HQL,session).list();
		if(list.size()>0)
		{
			n = (BoNews)list.get(0);
		}
		return n;
	}
	
	public List getTop10ByBigType(String id,Session session,String en) {
		List list = query(
				"select n from BoNews as n where n.boNavigationByNewsBig.id = '"+id+"' and n.en='"+en+"' order by n.newsTime desc",
				session).setFirstResult(0).setFetchSize(10).list();
		return list;
	}
	
	public List getTop10BySmallType(String id,Session session,String en) {
		List list = query(
				"select n from BoNews as n where n.boNavigationByNewsSmall = '"+id+"' and n.en='"+en+"' order by n.newsTime desc",
				session).setFirstResult(0).setFetchSize(10).list();
		return list;
	}

	public List getAllBoSmallNews(Session session) {
		// TODO Auto-generated method stub
		List list = query(
				"select n from BoNews as n where n.id !='0' and n.boNavigationByNewsSmall !='null' order by n.newsTime desc",
				session).list();
		return list;
	}
	
	
	//新添加为
	public List getCnSpecialBoNews(String id,String en,Session session) {

		List list = query(
				"select n from BoNews as n where n.boSpecial.id = '"+id+"' and n.en='"+en+"' and n.newsCheck = '1' order by n.newsTime desc",
				session).list();
		return list;
	}

}
