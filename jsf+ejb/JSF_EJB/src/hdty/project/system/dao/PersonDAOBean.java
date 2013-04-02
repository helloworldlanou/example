package hdty.project.system.dao;

import hdty.project.system.entity.Person;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Remote({PersonDAO.class})
public class PersonDAOBean implements PersonDAO{
	@PersistenceContext//���ֻ��һ���־û��������ã�����Ҫ��ȷָ��
	protected EntityManager em;

	//��������
	public boolean insert(Person person){
		try{
			em.persist(person);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean update(Person person) {
		try {
			em.merge(person);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Integer id){
		try{
			Person person= em.find(Person.class,Integer.valueOf(id));
			if (person!=null)
			  em.remove(person);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List queryList() {
		Query query = em.createQuery("select p from Person p order by id asc");
		List list = query.getResultList();
		return list;
	}
	
	//��������
	public Person queryDetail(Integer id) {
		return em.find(Person.class, id);
	}
	
	public String getNameByID(Integer id) {
		Person person = em.find(Person.class, Integer.valueOf(id));
		return person.getName();
	}
}