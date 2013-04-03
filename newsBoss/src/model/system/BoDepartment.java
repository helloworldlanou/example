package model.system;

/**
 * BoDepartment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoDepartment implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String parentId;
	private Integer dispIndex;
	private String des;
	private String icon;
	private String iconOpen;

	// Constructors

	/** default constructor */
	public BoDepartment() {
	}

	/** full constructor */
	public BoDepartment(String name, String parentId, Integer dispIndex,
			String des, String icon, String iconOpen) {
		this.name = name;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
		this.des = des;
		this.icon = icon;
		this.iconOpen = iconOpen;
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

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
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

}