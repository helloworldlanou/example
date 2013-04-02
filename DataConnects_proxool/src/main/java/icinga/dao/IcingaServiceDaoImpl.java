package icinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.consts.ExceptionConsts;
import common.consts.NeoException;
import dao.base.BaseDaoImpl;
import dao.base.IcingaConnectionManager;

import beans.IcingaService;
//import org.springframework.stereotype.Repository;


public class IcingaServiceDaoImpl extends BaseDaoImpl<IcingaService> implements
		IcingaServiceDao {

	private static final Logger logger = LoggerFactory
			.getLogger(IcingaServiceDaoImpl.class);
	private List<IcingaService> icingaServiceList;
	private Integer count = null;
	private static final String SQL_FIND_ALL = "SELECT s.service_id,s.host_object_id,s.service_object_id,s.display_name,s.action_url,ss.status_update_time,ss.output,ss.current_state,ss.has_been_checked,h.host_id,h.display_name host_display_name,h.address,hs.current_state host_current_state"
			+ " FROM icinga_services s,icinga_servicestatus ss,icinga_hosts h,icinga_hoststatus hs"
			+ " WHERE s.service_object_id = ss.service_object_id AND s.host_object_id = h.host_object_id AND hs.host_object_id = h.host_object_id ";
	
	private static final String ORDER_BY = " ORDER BY h.host_id ";
		
	private static final String SQL_FIND_BY_CURRENT_STATE = SQL_FIND_ALL
			+ " AND ss.current_state IN ";
	private static final String SQL_FIND_BY_HOST_ID = SQL_FIND_ALL
			+ " AND h.host_id IN ";
	private static final String SQL_FIND_BY_HOST_NAME = SQL_FIND_ALL
	+ " AND h.display_name = ?";
	private static final String SQL_FINDCHECKVMS_BY_HOST_NAME = SQL_FIND_ALL
	+ " AND h.display_name = ? AND s.display_name = 'check_vms'";
	private static final String SQL_FINDCHECKVMS = SQL_FIND_ALL
	+ " AND s.display_name = 'check_vms'";
	private static final String SQL_FIND_COUNT_BY_CURRENT_STATE = "SELECT count(*) from icinga_servicestatus s  ";
	
	private static final String SQL_FIND_BY_GROUP_NAME = "SELECT s.service_id,s.host_object_id,s.service_object_id,s.display_name,s.action_url,ss.status_update_time,ss.output,ss.current_state,ss.has_been_checked,h.host_id,h.display_name host_display_name,h.address,hs.current_state host_current_state"
		+ " FROM icinga_services s,icinga_servicestatus ss,icinga_hosts h,icinga_hostgroups hg,icinga_hostgroup_members hgm,icinga_hoststatus hs"
		+ " WHERE s.service_object_id = ss.service_object_id AND s.host_object_id = h.host_object_id AND hg.hostgroup_id = hgm.hostgroup_id AND hgm.host_object_id = h.host_object_id AND hs.host_object_id = h.host_object_id AND hg.alias = ? ORDER BY h.display_name;";
	private IcingaService buildIcingaService(ResultSet resultSet)
			throws NeoException {
		IcingaService icingaService = new IcingaService();
		try {
			icingaService.setService_id(resultSet.getInt(IcingaService.SQL_COLUMN_LABEL_SERVICE_ID));
			//icingaService.setId(resultSet.getInt(IcingaService.SQL_COLUMN_LABEL_SERVICE_ID));//添加上用于后面的假分页统一使用id来做
			icingaService.setHost_object_id(resultSet.getInt(IcingaService.SQL_COLUMN_LABEL_HOST_OBJECT_ID));
			icingaService.setService_object_id(resultSet.getInt(IcingaService.SQL_COLUMN_LABEL_SERVICE_OBJECT_ID));
			icingaService.setDisplay_name(resultSet.getString(IcingaService.SQL_COLUMN_LABEL_DISPLAY_NAME));
			// icingaService.setAction_url(resultSet.getString(IcingaService.SQL_COLUMN_LABEL_ACTION_URL));
			String url = resultSet.getString(IcingaService.SQL_COLUMN_LABEL_ACTION_URL);
			if(url==null || url.length()<1){
				icingaService.setAction_url("");
			}else{
				icingaService.setAction_url("?host="
						+ resultSet.getString("host_display_name") + "&service="
						+ icingaService.getDisplay_name());
			}
			icingaService.setHost_display_name_full(resultSet.getString(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME));
			//虚拟机去掉@号
//			String hostdisplayname = resultSet.getString(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME);
//			if(hostdisplayname.indexOf("@")>0){
//				hostdisplayname = hostdisplayname.substring(0, hostdisplayname.indexOf("@"));
//			}
//			icingaService.setHost_display_name(hostdisplayname);
			icingaService.setHost_display_name(resultSet.getString(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME));
			
			icingaService.setStatus_update_time(resultSet.getTimestamp(IcingaService.SQL_COLUMN_LABEL_STATUS_UPDATE_TIME).toString());
			icingaService.setOutput(resultSet.getString(IcingaService.SQL_COLUMN_LABEL_OUTPUT));
			icingaService.setCurrent_state(resultSet.getInt(IcingaService.SQL_COLUMN_LABEL_CURRENT_STATE));
			icingaService.setCurrent_state_str(statusInt2String(icingaService.getCurrent_state(),resultSet.getInt("has_been_checked")));
			icingaService.setAddress(resultSet.getString("address"));
			String val = icingaService.getDisplay_name();
			icingaService.setDisplay_name_CN(service2cn(val));
			icingaService.setHost_current_state(resultSet.getInt("host_current_state"));
			if(icingaService.getHost_current_state()==0){
				icingaService.setHostNameAndstate(icingaService.getHost_display_name() + " "+ "运行");
			}else if (icingaService.getHost_current_state()==1){
				icingaService.setHostNameAndstate(icingaService.getHost_display_name() + " "+ "宕机");
			}else{
				icingaService.setHostNameAndstate(icingaService.getHost_display_name() + " "+ "未知");
			}
			
//			if(icingaService.getDisplay_name().equals("CPU_Usage_AVE")){//此项不显示
//				return null;
//			}
//			if(icingaService.getDisplay_name().equals("CPU_Usage")){//此项不显示.之前是显示CPU使用率，后来改成显示5分钟的平均使用率
//				return null;
//			}
			
			//System.out.println(icingaService.getStatus_update_time());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED);
		}
		return icingaService;
	}
//此转换系统一共有3额，JS里有2个，这里有一个
	public static String service2cn(String val){
		if(val==null || val.equals("")){
			return "";
		}
		if(val.equals("CPU_Usage")||val.equals("local_cpu_usage")){
			return "CPU使用率";
		}if(val.equals("CPU_Usage_AVE")){
			return "CPU平均使用率";
		}else if(val.equals("Current_Load")||val.equals("local_current_load")){
			return "当前负载";
		}else if(val.equals("Current_Users")||val.equals("local_current_users")){
			return "当前用户数";
		}else if(val.equals("Iptables")||val.equals("local_iptalbes")){
			return "Iptables服务";
		}else if(val.equals("KVM")){
			return "KVM虚拟化";
		}else if(val.equals("Memory_Usage")||val.equals("local_mem_usage")){
			return "内存使用率";
		}else if(val.equals("NFS_mount")){
			return "NFS服务";
		}else if(val.equals("PING")||val.equals("local_ping")){
			return "PING响应时间";
		}else if(val.equals("Root_Partition")||val.equals("local_root_partition")){
			return "Root分区";
		}else if(val.equals("SELinux")||val.equals("local_selinux")){
			return "SELinux服务";
		}else if(val.equals("SSH")){
			return "SSH服务";
		}else if(val.equals("Swap_Usage")||val.equals("local_swap_usage")){
			return "交换分区使用";
		}else if(val.equals("Total_Processes")||val.equals("local_total_procs")){
			return "进程数";
		}else if(val.equals("check_iostat")||val.equals("IOstat")||val.equals("local_iostat")){
			return "磁盘IO";
		}else if(val.equals("HTTP")||val.equals("local_http")){
			return "HTTP响应时间";
		}else if(val.equals("MySQL")||val.equals("local_MySQL")){
			return "MySQL数据库";
		}else if(val .equals("check_win_cpu")){
			return "CPU负载";
		}  else if(val .equals( "check_win_disk")){
		return "磁盘空间";
		}  else if(val .equals( "check_win_diskio")){
		return "磁盘IO";
		} else if(val.equals("NetIO") || val.equals("local_netio")){
		return "网络使用总量";
		} else if(val .equals( "check_win_mem")){
		return "内存";
		}  else if(val .equals( "check_win_net")){
		return "网络";
		}  else if(val .equals( "check_win_explorer")){
		return "资源管理器";
		}  else if(val .equals( "check_win_uptime")){
		return "运行时间";
		}else if(val.equals( "check_win_mssql")){
			return "SQL Server";
		}else if(val.equals("check_win_servicestat")){
		return "服务状态";
		} else{
			return val;
		}
	}
	/**
	 * 
	 * @param status
	 *            0 = OK; 1 =WARNING; 2 =CRITICAL; 3 =UNKNOWN
	 * @return the String discription of servicestatus
	 */
	public String statusInt2String(Integer status,Integer has_been_checked) {
		if(has_been_checked == 1){
			switch (status) {
			case 0:
				return "正常";
			case 1:
				return "警告";
			case 2:
				return "严重";
			case 3:
				return "未知";
			default:
				break;
			}
		}else{
			return "未决";
		}
		
		return "";
	}

	@Override
	public int allocate(IcingaService icingaService) throws NeoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IcingaService> findAll(IcingaService icingaService)
			throws NeoException {
		logger.info("Find all IcingaServices");
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		icingaServiceList = new ArrayList<IcingaService>();
		try {
			conn = IcingaConnectionManager.getInstance().getConnection();
			statement = conn.prepareStatement(SQL_FIND_ALL + ";");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				IcingaService icingaServiceTmp = this.buildIcingaService(resultSet);
				if(icingaServiceTmp!=null){
				icingaServiceList.add(icingaServiceTmp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED);
		} finally {
			IcingaConnectionManager.closeConnection(conn, statement,
					resultSet);
		}
		return icingaServiceList;
	}

	@Override
	public IcingaService findById(IcingaService icingaService)
			throws NeoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(IcingaService icingaService) throws NeoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IcingaService> findByCurrentState(IcingaService icingaService)
			throws NeoException {
		logger.info("Find icingaServices by current_state - {}",
				icingaService.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_CURRENT_STATE));
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		icingaServiceList = new ArrayList<IcingaService>();
		try {
			conn = IcingaConnectionManager.getInstance().getConnection();
			statement = conn.prepareStatement(SQL_FIND_BY_CURRENT_STATE
					+ "("
					+ icingaService.getParams().getParam(
							IcingaService.SQL_COLUMN_LABEL_CURRENT_STATE)
							.toString() + ");");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				IcingaService icingaServiceTmp = buildIcingaService(resultSet);
				if(icingaServiceTmp!=null){
				icingaServiceList.add(icingaServiceTmp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED);
		} finally {
			IcingaConnectionManager.closeConnection(conn, statement,
					resultSet);
		}
		return icingaServiceList;
	}

	@Override
	public List<IcingaService> findByServiceIds(IcingaService icingaService)
			throws NeoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IcingaService> findByHostIds(IcingaService icingaService)
			throws NeoException {
		logger.info("Find icingaServices by host_id - {}", icingaService
				.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_HOST_ID));
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		icingaServiceList = new ArrayList<IcingaService>();
		try {
			conn = IcingaConnectionManager.getInstance().getConnection();
			statement = conn.prepareStatement(SQL_FIND_BY_HOST_ID
					+ "("
					+ icingaService.getParams()
							.getParam(IcingaService.SQL_COLUMN_LABEL_HOST_ID)
							.toString() + ");");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				IcingaService icingaServiceTmp = this.buildIcingaService(resultSet);
				if(icingaServiceTmp!=null){
					icingaServiceList.add(icingaServiceTmp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED);
		} finally {
			IcingaConnectionManager.closeConnection(conn, statement,
					resultSet);
		}
		return icingaServiceList;
	}

	@Override
	public Integer findCountByCurrentState(IcingaService icingaService)
			throws NeoException {
		logger.info(
				"Find icingaService count by current_state - {}",
				icingaService.getParams().getParam(
						IcingaService.SQL_COLUMN_LABEL_CURRENT_STATE));
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "";
		if (icingaService.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_CURRENT_STATE) != null
				&& !icingaService.getParams().getParam(
						IcingaService.SQL_COLUMN_LABEL_CURRENT_STATE)
						.equals("")) {
			sql = SQL_FIND_COUNT_BY_CURRENT_STATE
					+ " WHERE s.current_state IN ("
					+ icingaService.getParams().getParam(
							IcingaService.SQL_COLUMN_LABEL_CURRENT_STATE)
							.toString() + ");";
		} else {
			sql = SQL_FIND_COUNT_BY_CURRENT_STATE;
		}
		try {
			conn = IcingaConnectionManager.getInstance().getConnection();
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED);
		} finally {
			IcingaConnectionManager.closeConnection(conn, statement,
					resultSet);
		}
		return count;
	}

	@Override
	public List<IcingaService> findByHostName(IcingaService icingaService)
			throws NeoException {
		logger.info("Find icingaServices by HostName - {}", icingaService
				.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME));
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		icingaServiceList = new ArrayList<IcingaService>();
		try {
			conn = IcingaConnectionManager.getInstance().getConnection();
			statement = conn.prepareStatement(SQL_FIND_BY_HOST_NAME);
			statement.setString(1, icingaService.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME).toString());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				IcingaService icingaServiceTmp = this.buildIcingaService(resultSet);
				if(icingaServiceTmp!=null){
				icingaServiceList.add(icingaServiceTmp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED);
		} finally {
			IcingaConnectionManager.closeConnection(conn, statement,
					resultSet);
		}
		return icingaServiceList;
	}

	@Override
	public List<IcingaService> findcheckvmsByHostName(
			IcingaService icingaService) throws NeoException {
		logger.info("Find icingaServices:checkvms by HostName - {}", icingaService
				.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME));
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		icingaServiceList = new ArrayList<IcingaService>();
		try {
			conn = IcingaConnectionManager.getInstance().getConnection();
			if(icingaService.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME) == null || icingaService.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME).equals("")){
				statement = conn.prepareStatement(SQL_FINDCHECKVMS);
			}else{
				statement = conn.prepareStatement(SQL_FINDCHECKVMS_BY_HOST_NAME);
				statement.setString(1, icingaService.getParams().getParam(IcingaService.SQL_COLUMN_LABEL_HOST_DISPLAY_NAME).toString());
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				IcingaService icingaServiceTmp = this.buildIcingaService(resultSet);
				if(icingaServiceTmp!=null){
				icingaServiceList.add(icingaServiceTmp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED);
		} finally {
			IcingaConnectionManager.closeConnection(conn, statement,
					resultSet);
		}
		return icingaServiceList;
	}

	@Override
	public List<IcingaService> findByHostGroupName(String groupname)
			throws NeoException {
		// TODO Auto-generated method stub SQL_FIND_BY_GROUP_NAME
		logger.info("Find icingaServicesby HostGroupName - {}", groupname);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		icingaServiceList = new ArrayList<IcingaService>();
		try {
			conn = IcingaConnectionManager.getInstance().getConnection();
			if(groupname == null || groupname.equals("")){
				statement = conn.prepareStatement(SQL_FIND_ALL);
			}else{
				statement = conn.prepareStatement(SQL_FIND_BY_GROUP_NAME);
				statement.setString(1, groupname);
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				IcingaService icingaServiceTmp = this.buildIcingaService(resultSet);
				if(icingaServiceTmp!=null){
				icingaServiceList.add(icingaServiceTmp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED);
		} finally {
			IcingaConnectionManager.closeConnection(conn, statement,
					resultSet);
		}
		//System.out.println("DAO结果个数："+icingaServiceList.size());
		return icingaServiceList;
	}
	
	
	public static void main(String[] args){
		IcingaServiceDaoImpl dl = new IcingaServiceDaoImpl();
		IcingaService icingaService = new IcingaService();
		List<IcingaService> list = null;
		try {
			list = dl.findAll(icingaService);
		} catch (NeoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (IcingaService icingaService2 : list) {
			System.out.println(icingaService2.getDisplay_name_CN());
		}
	}
	
}
