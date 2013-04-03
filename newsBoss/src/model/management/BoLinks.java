package model.management;

import java.util.Date;

/**
 * BoLinks entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoLinks implements java.io.Serializable {

	// Fields

	private String id;
	private BoLinksSort boLinksSort;
	private String name;
	private String url;
	private Date time;

	// Constructors

	/** default constructor */
	public BoLinks() {
	}

	/** full constructor */
	public BoLinks(BoLinksSort boLinksSort, String name, String url, Date time) {
		this.boLinksSort = boLinksSort;
		this.name = name;
		this.url = url;
		this.time = time;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BoLinksSort getBoLinksSort() {
		return this.boLinksSort;
	}

	public void setBoLinksSort(BoLinksSort boLinksSort) {
		this.boLinksSort = boLinksSort;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}