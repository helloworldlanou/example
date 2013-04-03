package model.system;

/**
 * BoRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoRole implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String parentId;
	private String icon;
	private String iconOpen;
	private String des;
	private Integer dispIndex;

	// Constructors

	/** default constructor */
	public BoRole() {
	}

	/** full constructor */
	public BoRole(String name, String parentId, String icon, String iconOpen,
			String des, Integer dispIndex) {
		this.name = name;
		this.parentId = parentId;
		this.icon = icon;
		this.iconOpen = iconOpen;
		this.des = des;
		this.dispIndex = dispIndex;
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

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}