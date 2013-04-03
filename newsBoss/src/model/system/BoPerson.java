package model.system;

/**
 * BoPerson entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoPerson implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String parentId;
	private Integer dispIndex;
	private String sex;
	private String userName;
	private String password;
	private String lastLoginTime;
	private Integer loginTimes;
	private String registerTime;
	private String depName;
	private String duty;
	private String des;
	private String icon;
	private String iconOpen;
	private String roleId;
	private String roleName;

	// Constructors

	/** default constructor */
	public BoPerson() {
	}

	/** minimal constructor */
	public BoPerson(String name, String parentId) {
		this.name = name;
		this.parentId = parentId;
	}

	/** full constructor */
	public BoPerson(String name, String parentId, Integer dispIndex,
			String sex, String userName, String password, String lastLoginTime,
			Integer loginTimes, String registerTime, String depName,
			String duty, String des, String icon, String iconOpen,
			String roleId, String roleName) {
		this.name = name;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
		this.sex = sex;
		this.userName = userName;
		this.password = password;
		this.lastLoginTime = lastLoginTime;
		this.loginTimes = loginTimes;
		this.registerTime = registerTime;
		this.depName = depName;
		this.duty = duty;
		this.des = des;
		this.icon = icon;
		this.iconOpen = iconOpen;
		this.roleId = roleId;
		this.roleName = roleName;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginTimes() {
		return this.loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
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

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}