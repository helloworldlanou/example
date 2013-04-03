package model.facility;

import java.util.HashSet;
import java.util.Set;

import model.management.BoNavigation;

/**
 * BoFacilityType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoFacilityType implements java.io.Serializable {

	// Fields

	private String id;
	private BoNavigation boNavigation;
	private String name;
	private String des;
	private Set boFacilities = new HashSet(0);
	private String enname;
	

	// Constructors

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	/** default constructor */
	public BoFacilityType() {
	}

	/** full constructor */
	public BoFacilityType(BoNavigation boNavigation, String name, String des,
			Set boFacilities) {
		this.boNavigation = boNavigation;
		this.name = name;
		this.des = des;
		this.boFacilities = boFacilities;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BoNavigation getBoNavigation() {
		return this.boNavigation;
	}

	public void setBoNavigation(BoNavigation boNavigation) {
		this.boNavigation = boNavigation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set getBoFacilities() {
		return this.boFacilities;
	}

	public void setBoFacilities(Set boFacilities) {
		this.boFacilities = boFacilities;
	}

}