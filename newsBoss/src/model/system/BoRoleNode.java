package model.system;

/**
 * BoRoleNode entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoRoleNode implements java.io.Serializable {

	// Fields

	private String id;
	private String roleId;
	private String nodeId;

	// Constructors

	/** default constructor */
	public BoRoleNode() {
	}

	/** full constructor */
	public BoRoleNode(String roleId, String nodeId) {
		this.roleId = roleId;
		this.nodeId = nodeId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

}