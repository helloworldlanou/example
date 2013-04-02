package hdty.project.system.service;

import hdty.project.system.dao.PersonDAO;
import hdty.project.system.entity.Person;
import hdty.project.system.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class PersonService {
	
	private PersonDAO personDao;

	public PersonService() {
		try {
			Properties props = new Properties();
			// 设置Jboss服务器的JNDI驱动的类名
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			// 设置Jboss服务器提供命名服务的URL
			props.setProperty(Context.PROVIDER_URL, "127.0.0.1:1099");
			InitialContext ctx = new InitialContext(props);

			// looking up SessionBean
			personDao = (PersonDAO) ctx.lookup("PersonDAOBean/remote");

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//基本方法
	public void insert(PersonVO person){
		personDao.insert(person.getPO());
	}

	public void delete(PersonVO person){
		personDao.delete(person.getId());
	}

	public void update(PersonVO person){
		personDao.update(person.getPO());
	}

	@SuppressWarnings("unchecked")
	public List<PersonVO> queryList(){
		List<PersonVO> result = new ArrayList<PersonVO>();

		List<Person> list = personDao.queryList();
		int size = list == null ? 0 : list.size();
		for (int i = 0; i < size; i++) {
			result.add(new PersonVO(list.get(i)));
		}		
		return result;
	}

	public PersonVO queryDetail(Integer id){
		Person person = personDao.queryDetail(id);
		return (person == null ? null : new PersonVO(person));
	}
	
	//其他方法
	public String getNameByID(Integer id){
		return personDao.getNameByID(id);
	}

}
