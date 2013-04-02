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

	@TableGenerator(name = "IDGenerator", // 为该生成方式取个名称
	//schema = "EJB_TEST",
	table = "T_IDGENERATOR", // 生成ID的表
	pkColumnName = "TB_NAME", // 主键列的名称
	valueColumnName = "ID_VALUE", // 存放生成ID值的列的名称
	pkColumnValue = "PERSON", // 主键列的值(定位某条记录)
	allocationSize = 1)
	// 递增值
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
	 * 返回对象的散列代码值。该实现根据此对象 中id字段计算散列代码值。
	 * 
	 * @return此对象的散列代码值。
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	/**
	 * 确定其他对象是否等于此CommentContent。当且仅当
	 * 参数不为null且该参数是具有与此对象相同id字段值的CommentContent对象时， 结果才为<code>true</code>。
	 * 
	 * @param对象，要比较的引用对象 如果此对象与参数相同，则@return<code>true</code>； 否则为<code>false</code>。
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
	 * 返回对象的字符串表示法。该实现根据id字段 构造此表示法。
	 * 
	 * @return对象的字符串表示法。
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + "[id=" + id + "]";
	}
}