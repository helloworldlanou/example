package beans;




/**
 * @author wangz
 *	IcingaService is from icinga mysql databases 
 *	references table :icinga_services,icinga_servicestatus,icinga_objects 
 */
public class IcingaService {
	
	protected BaseParam params = new BaseParam();
	/**
	 * @return
	 */
	public BaseParam getParams() {
		return params;
	}

	/**
	 * @param params
	 */
	public void setParams(BaseParam params) {
		this.params = params;
	}
	
	/**
	 * Column label of "service_id" in DB-Table: icinga_services
	 */
	public static final String SQL_COLUMN_LABEL_SERVICE_ID = "service_id";
	
	/**
	 * Column label of "host_object_id" in DB-Table: icinga_services
	 */
	public static final String SQL_COLUMN_LABEL_HOST_OBJECT_ID = "host_object_id";
	
	/**
	 * Column label of "service_object_id" in DB-Table: icinga_services
	 */
	public static final String SQL_COLUMN_LABEL_SERVICE_OBJECT_ID = "service_object_id";
	
	/**
	 * Column label of "display_name" in DB-Table: icinga_services
	 */
	public static final String SQL_COLUMN_LABEL_DISPLAY_NAME = "display_name";
	
	/**
	 * Column label of "action_url" in DB-Table: icinga_services
	 */
	public static final String SQL_COLUMN_LABEL_ACTION_URL = "action_url";
	
	/**
	 * Column label of "status_update_time" in DB-Table: icinga_servicestatus
	 */
	public static final String SQL_COLUMN_LABEL_STATUS_UPDATE_TIME = "status_update_time";
	
	/**
	 * Column label of "output" in DB-Table: icinga_servicestatus
	 */
	public static final String SQL_COLUMN_LABEL_OUTPUT = "output";
	/**
	 * Column label of "current_state" in DB-Table: icinga_servicestatus
	 */
	public static final String SQL_COLUMN_LABEL_CURRENT_STATE = "current_state";
	/**
	 * Column label of "host_id" in DB-Table: icinga_hosts
	 */
	public static final String SQL_COLUMN_LABEL_HOST_ID = "host_id";
	/**
	 * Column label of "host_display_name" in DB-Table: icinga_hosts
	 */
	public static final String SQL_COLUMN_LABEL_HOST_DISPLAY_NAME = "host_display_name";
	
	private Integer service_id;
	private Integer host_object_id;
	private String host_display_name;
	private Integer service_object_id;
	private String display_name;
	private String action_url;
	private String status_update_time;
	private String output;
	private Integer current_state;
	private String current_state_str;
	private String display_name_CN;
	private String address;
	private Integer host_current_state;//0运行，1宕机 其他未知
	private String hostNameAndstate;
	private String host_display_name_full;


	public String getHostNameAndstate() {
		return hostNameAndstate;
	}
	public void setHostNameAndstate(String hostNameAndstate) {
		this.hostNameAndstate = hostNameAndstate;
	}
	public Integer getHost_current_state() {
		return host_current_state;
	}
	public void setHost_current_state(Integer host_current_state) {
		this.host_current_state = host_current_state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getService_id() {
		return service_id;
	}
	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}
	public Integer getHost_object_id() {
		return host_object_id;
	}
	public void setHost_object_id(Integer host_object_id) {
		this.host_object_id = host_object_id;
	}
	public String getHost_display_name() {
		return host_display_name;
	}
	public void setHost_display_name(String host_display_name) {
		this.host_display_name = host_display_name;
	}
	public Integer getService_object_id() {
		return service_object_id;
	}
	public void setService_object_id(Integer service_object_id) {
		this.service_object_id = service_object_id;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getAction_url() {
		return action_url;
	}
	public void setAction_url(String action_url) {
		this.action_url = action_url;
	}
	public String getStatus_update_time() {
		return status_update_time;
	}
	public void setStatus_update_time(String status_update_time) {
		this.status_update_time = status_update_time;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	/**
	 * @return 0 = OK; 1 =WARNING; 2 =CRITICAL; 3 =UNKNOWN
	 */
	public Integer getCurrent_state() {
		return current_state;
	}
	public void setCurrent_state(Integer current_state) {
		this.current_state = current_state;
	}
	public String getCurrent_state_str() {
		return current_state_str;
	}
	public void setCurrent_state_str(String current_state_str) {
		this.current_state_str = current_state_str;
	}
	public String getDisplay_name_CN() {
		return display_name_CN;
	}
	public void setDisplay_name_CN(String display_name_CN) {
		this.display_name_CN = display_name_CN;
	}
	public String getHost_display_name_full() {
		return host_display_name_full;
	}
	public void setHost_display_name_full(String host_display_name_full) {
		this.host_display_name_full = host_display_name_full;
	}
}
