package hdty.project.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Entity
//@Table(name = "Person",schema = "EJB_TEST") //for oracle

public class Person implements Serializable {
	private Integer id;
	private String name;
	private boolean sex;
	private Short age;
	private Date birthday;
	private String image;

	@TableGenerator(name = "IDGenerator", // Ϊ�����ɷ�ʽȡ������
	//schema = "EJB_TEST",
	table = "T_IDGENERATOR", // ����ID�ı�
	pkColumnName = "TB_NAME", // �����е�����
	valueColumnName = "ID_VALUE", // �������IDֵ���е�����
	pkColumnValue = "PERSON", // �����е�ֵ(��λĳ����¼)
	allocationSize = 1)
	// ����ֵ
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "IDGenerator")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(nullable = false, length = 32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = true)
	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Column(nullable = true)
	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	///????
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(nullable = true)
	public String getImage(){
	  return image;
	}
	
	public void setImage(String image){
		this.image= image;
	}

	/**
	 * ���ض����ɢ�д���ֵ����ʵ�ָ��ݴ˶��� ��id�ֶμ���ɢ�д���ֵ��
	 * 
	 * @return�˶����ɢ�д���ֵ��
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	/**
	 * ȷ�����������Ƿ���ڴ�CommentContent�����ҽ���
	 * ������Ϊnull�Ҹò����Ǿ�����˶�����ͬid�ֶ�ֵ��CommentContent����ʱ�� �����Ϊ<code>true</code>��
	 * 
	 * @param����Ҫ�Ƚϵ����ö��� ����˶����������ͬ����@return<code>true</code>�� ����Ϊ<code>false</code>��
	 */
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Person)) {
			return false;
		}
		Person other = (Person) object;
		if (this.id != other.id
				&& (this.id == null || !this.id.equals(other.id)))
			return false;
		return true;
	}

	/**
	 * ���ض�����ַ�����ʾ������ʵ�ָ���id�ֶ� ����˱�ʾ����
	 * 
	 * @return������ַ�����ʾ����
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + "[id=" + id + "]";
	}
}