package hdty.project.system.vo;

import java.util.Date;

import hdty.project.system.entity.Person;

public class PersonVO{
  
  private Integer id;

	private String name;

	private boolean sex;

	private Short age;

	private Date birthday;
	
	private String image;
	
	
	public PersonVO(){}
	/**
	 * PO --> VO
	 * @return
	 */
	public PersonVO(Person person){
		this.id = person.getId();
		this.name = person.getName();
		this.sex = person.getSex();
		this.age = person.getAge();
		this.birthday = person.getBirthday();
		this.image = person.getImage();
	}
	/**
	 * VO --> PO
	 * @return
	 */
	public Person getPO(){
		Person person = new Person();
		
		person.setId(id);
		person.setName(name);
		person.setSex(sex);
		person.setAge(age);
		person.setBirthday(birthday);
		//person.setImage(image);
		return person;
	}
	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
}