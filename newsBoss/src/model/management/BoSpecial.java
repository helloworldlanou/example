package model.management;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BoSpecial entity.
 * 
 * @author MyEclipse Persistence Tools
 */

/**
 * @author Administrator
 *
 */
public class BoSpecial implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Integer serial;
	private Date createtime;
	private String enname;
	private String prename;
	private String preenname;
	private String parentid;
	private Set boNewses = new HashSet(0);
	// Constructors

	public Set getBoNewses() {
		return boNewses;
	}

	public void setBoNewses(Set boNewses) {
		this.boNewses = boNewses;
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	/** default constructor */
	public BoSpecial() {
	}

	/** full constructor */
	public BoSpecial(String name, Integer serial, Date createtime) {
		this.name = name;
		this.serial = serial;
		this.createtime = createtime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSerial() {
		return this.serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getPrename() {
		return prename;
	}

	public void setPrename(String prename) {
		this.prename = prename;
	}

	public String getPreenname() {
		return preenname;
	}

	public void setPreenname(String preenname) {
		this.preenname = preenname;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

}