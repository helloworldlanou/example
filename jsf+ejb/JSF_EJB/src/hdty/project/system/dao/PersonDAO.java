package hdty.project.system.dao;

import hdty.project.system.entity.Person;

import java.util.List;

public interface PersonDAO{
	public boolean insert(Person person);
	public boolean update(Person person);
	public boolean delete(Integer id);
	public List queryList();
	public Person queryDetail(Integer id);
	public String getNameByID(Integer id);
  
}