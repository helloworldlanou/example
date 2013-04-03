package model.system;

public class DtreeNode implements java.io.Serializable, Comparable<DtreeNode>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8938143971040452532L;
	private String id;
	private String parentId;
	private String name;
	private String url;
	private String title;
	private String target;
	private String icon;
	private String iconOpen;
	private String open;
	private Integer dispindex;

	public Integer getDispindex() {
		return dispindex;
	}

	public void setDispindex(Integer dispIndex) {
		this.dispindex = dispIndex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconOpen() {
		return iconOpen;
	}

	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public int compareTo(DtreeNode o) {
		return (int)(this.getDispindex()-o.getDispindex());
	}
}
