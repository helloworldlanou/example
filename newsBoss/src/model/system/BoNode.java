package model.system;

/**
 * BoNode entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoNode implements java.io.Serializable,Comparable{

	// Fields

	private String id;
	private String name;
	private String parentId;
	private String url;
	private String icon;
	private String iconOpen;
	private String title;
	private String target;
	private String open;
	private Integer dispIndex;
	private String type;
	private String state;
	private String bigIcon;

	// Constructors

	/** default constructor */
	public BoNode() {
	}

	/** minimal constructor */
	public BoNode(String name, String parentId) {
		this.name = name;
		this.parentId = parentId;
	}

	/** full constructor */
	public BoNode(String name, String parentId, String url, String icon,
			String iconOpen, String title, String target, String open,
			Integer dispIndex, String type, String state, String bigIcon) {
		this.name = name;
		this.parentId = parentId;
		this.url = url;
		this.icon = icon;
		this.iconOpen = iconOpen;
		this.title = title;
		this.target = target;
		this.open = open;
		this.dispIndex = dispIndex;
		this.type = type;
		this.state = state;
		this.bigIcon = bigIcon;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getOpen() {
		return this.open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBigIcon() {
		return this.bigIcon;
	}

	public void setBigIcon(String bigIcon) {
		this.bigIcon = bigIcon;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return (int)(this.getDispIndex()-((BoNode)o).getDispIndex());
	}

}