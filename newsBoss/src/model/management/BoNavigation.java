package model.management;

import java.util.HashSet;
import java.util.Set;

import model.facility.BoFacilityType;

/**
 * BoNavigation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoNavigation implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String parentId;
	private String des;
	private String icon;
	private String iconOpen;
	private Integer dispIndex;
	private String target;
	private String type;
	private String url;
	private String centershow;
	private String showup;
	private String defaultchecked;
	private String enname;
	private BoFacilityType boFacilityType ;
	private Set boNewsesForNewsSmall = new HashSet(0);
	private Set boNewsesForNewsBig = new HashSet(0);
	// Constructors

	public Set getBoNewsesForNewsSmall() {
		return boNewsesForNewsSmall;
	}

	public void setBoNewsesForNewsSmall(Set boNewsesForNewsSmall) {
		this.boNewsesForNewsSmall = boNewsesForNewsSmall;
	}

	public Set getBoNewsesForNewsBig() {
		return boNewsesForNewsBig;
	}

	public void setBoNewsesForNewsBig(Set boNewsesForNewsBig) {
		this.boNewsesForNewsBig = boNewsesForNewsBig;
	}

	/** default constructor */
	public BoNavigation() {
	}

	/** minimal constructor */
	public BoNavigation(String name, String parentId, Integer dispIndex) {
		this.name = name;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
	}

	/** full constructor */
	public BoNavigation(String name, String parentId, String des, String icon,
			String iconOpen, Integer dispIndex, String target, String type,
			String url, BoFacilityType boFacilityType) {
		this.name = name;
		this.parentId = parentId;
		this.des = des;
		this.icon = icon;
		this.iconOpen = iconOpen;
		this.dispIndex = dispIndex;
		this.target = target;
		this.type = type;
		this.url = url;
		this.boFacilityType = boFacilityType;
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

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconOpen() {
		return this.iconOpen;
	}

	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BoFacilityType getBoFacilityType() {
		return boFacilityType;
	}

	public void setBoFacilityType(BoFacilityType boFacilityType) {
		this.boFacilityType = boFacilityType;
	}

	public String getDefaultchecked() {
		return defaultchecked;
	}

	public void setDefaultchecked(String defaultchecked) {
		this.defaultchecked = defaultchecked;
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public String getCentershow() {
		return centershow;
	}

	public void setCentershow(String centershow) {
		this.centershow = centershow;
	}
	
	public String getShowup() {
		return showup;
	}

	public void setShowup(String showup) {
		this.showup = showup;
	}



}