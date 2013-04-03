package model.management;

import java.util.Date;

/**
 * BoLinksSort entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoLinksSort implements java.io.Serializable {

	// Fields

	private String id;
	private String sortname;
	private Integer serial;
	private Date createtime;

	// Constructors

	/** default constructor */
	public BoLinksSort() {
	}

	/** full constructor */
	public BoLinksSort(String sortname, Integer serial, Date createtime) {
		this.sortname = sortname;
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

	public String getSortname() {
		return this.sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
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

}