package common.consts;

/**
 * Error code constants for web client
 * 
 * @author Joey
 * 
 */
public interface ExceptionConsts {

	/* --------------- Error code: 8000~8999 JDBC ----------------- */
	/* --------------- Constants for JDBC initialization ----------------- */
	static final int ERROR_CODE_JDBC_CONFIG_NOT_FOUND = 8001;
	static final String ERROR_STRING_JDBC_CONFIG_NOT_FOUND = "JDBC config file not found";

	static final int ERROR_CODE_JDBC_DRIVER_NOT_FOUND = 8002;
	static final String ERROR_STRING_JDBC_DRIVER_NOT_FOUND = "JDBC driver class not found";

	static final int ERROR_CODE_JDBC_OPEN_CONNECTION_FAILD = 8003;
	static final String ERROR_STRING_JDBC_OPEN_CONNECTION_FAILD = "Open JDBC connection failed";

	static final int ERROR_CODE_JDBC_CLOSE_CONNECTION_FAILD = 8004;
	static final String ERROR_STRING_JDBC_CLOSE_CONNECTION_FAILD = "Close JDBC connection failed";

	static final int ERROR_CODE_JDBC_CLOSE_STATEMENT_FAILD = 8005;
	static final String ERROR_STRING_JDBC_CLOSE_STATEMENT_FAILD = "Close JDBC statement failed";

	static final int ERROR_CODE_JDBC_CLOSE_RESULTSET_FAILD = 8006;
	static final String ERROR_STRING_JDBC_CLOES_RESULTSET_FAILD = "Close JDBC resultset failed";
	/* --------------- Constants for JDBC initialization ----------------- */

	/* --------------- Constants for JDBC execution ----------------- */
	static final int ERROR_CODE_JDBC_EXECUTE_SQL_FAILED = 8007;
	static final String ERROR_STRING_JDBC_EXECUTE_SQL_FAILED = "Execute JDBC sql failed";
	/* --------------- Constants for JDBC execution ----------------- */

	// failed to open icinga db
	static final int ERROR_CODE_JDBC_OPEN_ICINGA_DB_FAILED = 8008;
	static final String ERROR_STRING_JDBC_OPEN_ICINGA_DB_FAILED = "Failed to open icinga database...";

	// failed to open web db
	static final int ERROR_CODE_JDBC_OPEN_WEB_DB_FAILED = 8009;
	static final String ERROR_STRING_JDBC_OPEN_WEB_DB_FAILED = "Failed to open web database...";

	// failed to rw icinga_loadbalancelog table in Icinga database
	static final int ERROR_CODE_JDBC_EXECUTE_LOADBALANCE_SQL_FAILED = 8010;
	static final String ERROR_STRING_JDBC_EXECUTE_LOADBALANCE_SQL_FAILED = "Failed to read or write icinga_loadbalancelog table in Icinga database";

	// failed to rw icinga_monitorwarnlog table in Icinga database
	static final int ERROR_CODE_JDBC_EXECUTE_MONITORWARNLOG_SQL_FAILED = 8011;
	static final String ERROR_STRING_JDBC_EXECUTE_MONITORWARNLOG_SQL_FAILED = "Failed to read or write icinga_monitorwarnlog table in Icinga database";

	// failed to rw audit_conf table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_AUDITCONF_SQL_FAILED = 8012;
	static final String ERROR_STRING_JDBC_EXECUTE_AUDITCONF_SQL_FAILED = "Failed to read or write audit_conf table in web database";

	// failed to rw audit_record table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_AUDITRECORD_SQL_FAILED = 8013;
	static final String ERROR_STRING_JDBC_EXECUTE_AUDITRECORD_SQL_FAILED = "Failed to read or write audit_record table in web database";

	// failed to rw auth_info table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_AUTHINFO_SQL_FAILED = 8014;
	static final String ERROR_STRING_JDBC_EXECUTE_AUTHINFO_SQL_FAILED = "Failed to read or write auth_info table in web database";

	// failed to rw group table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_GROUP_SQL_FAILED = 8015;
	static final String ERROR_STRING_JDBC_EXECUTE_GROUP_SQL_FAILED = "Failed to read or write group table in web database";
	
	// failed to rw host_pri table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_HOSTPRI_SQL_FAILED = 8016;
	static final String ERROR_STRING_JDBC_EXECUTE_HOSTPRI_SQL_FAILED = "Failed to read or write host_pri table in web database";

	// failed to rw image_pri table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_IMAGEPRI_SQL_FAILED = 8017;
	static final String ERROR_STRING_JDBC_EXECUTE_IMAGEPRI_SQL_FAILED = "Failed to read or write image_pri table in web database";

	// failed to rw role_pri table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_ROLEPRI_SQL_FAILED = 8018;
	static final String ERROR_STRING_JDBC_EXECUTE_ROLEPRI_SQL_FAILED = "Failed to read or write role_pri table in web database";

	// failed to rw vmm_pri table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_VMMPRI_SQL_FAILED = 8019;
	static final String ERROR_STRING_JDBC_EXECUTE_VMMPRI_SQL_FAILED = "Failed to read or write vmm_pri table in web database";

	// failed to rw pass_conf table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_PASSCONF_SQL_FAILED = 8020;
	static final String ERROR_STRING_JDBC_EXECUTE_PASSCONF_SQL_FAILED = "Failed to read or write pass_conf table in web database";
	
	// failed to rw role table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_ROLE_SQL_FAILED = 8021;
	static final String ERROR_STRING_JDBC_EXECUTE_ROLE_SQL_FAILED = "Failed to read or write role table in web database";
	
	// failed to rw ukey_auth table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_UKEYAUTH_SQL_FAILED = 8022;
	static final String ERROR_STRING_JDBC_EXECUTE_UKEYAUTH_SQL_FAILED = "Failed to read or write ukey_auth table in web database";
	
	// failed to rw user_info table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_USERINFO_SQL_FAILED = 8023;
	static final String ERROR_STRING_JDBC_EXECUTE_USERINFO_SQL_FAILED = "Failed to read or write user_info table in web database";

	// failed to rw icinga_host table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_ICINGAHOST_SQL_FAILED = 8024;
	static final String ERROR_STRING_JDBC_EXECUTE_ICINGAHOST_SQL_FAILED = "Failed to read or write icinga_host table in web database";

	// failed to rw icinga_service table in nkscloud_web database
	static final int ERROR_CODE_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED = 8025;
	static final String ERROR_STRING_JDBC_EXECUTE_ICINGASERVICE_SQL_FAILED = "Failed to read or write icinga_service table in web database";
	
	// no connection in threadlocal
	static final int ERROR_CODE_NO_CONNECTION_IN_TRANSACTION = 8026;
	static final String ERROR_STRING_NO_CONNECTION_IN_TRANSACTION = "No connection in threadlocal, please init it first";
	
	/*
	 * --------------- Error code: 10000~10999 Cluster(Host group)
	 * -----------------
	 */
	static final int ERROR_CODE_CLUSTER_NAME_DUPLICATED = 10001;
	static final String ERROR_STRING_CLUSTER_NAME_DUPLICATED = "Cluster name is used";
	static final int ERROR_CODE_CLUSTER_DEFAULT_NOT_DELETED = 10002;
	static final String ERROR_STRING_CLUSTER_DEFAULT_NOT_DELETED = "You can't delete default cluster";
	static final int ERROR_CODE_CLUSTER_HAS_HOST = 10003;
	static final String ERROR_STRING_CLUSTER_HAS_HOST = "Cluster has host,you can't delete the cluster";
	/* --------------- Error code: 11000~11999 Host ----------------- */
	static final int ERROR_CODE_HOST_NAME_DUPLICATED = 11001;
	static final String ERROR_STRING_HOST_NAME_DUPLICATED = "Host name is used";
	static final int ERROR_CODE_HOST_HAS_VM = 11002;
	static final String ERROR_STRING_HOST_HAS_VM = "Host has vm,you can't delete the host";
	static final int ERROR_CODE_ADD_HOST_TO_SECURITY = 11003;
	static final String ERROR_STRING_ADD_HOST_TO_SECURITY = "add host to security db error";
	/* --------------- Error code: 12000~12999 Image ----------------- */
	// Add by Huihui
	static final int ERROR_CODE_ADD_IMAGE_TO_SECURITY = 12000;
	static final String ERROR_STRING_ADD_IMAGE_TO_SECURITY = "add image to security db error";
	static final int ERROR_CODE_IMAGE_NAME_DUPLICATED = 12001;
	static final String ERROR_STRING_IMAGE_NAME_DUPLICATED = "Imagename has been used";
	static final int ERROR_CODE_CHANGE_IMAGE_GROUP_NOGOUP = 12002;
	static final String ERROR_STRING_CHANGE_IMAGE_GROUP_NOGOUP = "You don't choose any groups";
	static final int ERROR_CODE_USED_IMAGE_NOT_DELETED = 12003;
	static final String ERROR_STRING_USED_IMAGE_NOT_DELETED = "Image is used, you can't delete used image";
	static final int ERROR_CODE_IMAGE_DELETED_SUCESS = 12004;
	static final String ERROR_STRING_IMAGE_DELETED_SUCESS = "Delete image sucess";
	static final int ERROR_CODE_IMAGE_NO_CHANGE = 12005;
	static final String ERROR_STRING_IMAGE_NO_CHANGE = "Image changes nothing";
	static final int ERROR_CODE_IMAGE_PUBLISH_CHANGE_FAILED = 12006;
	static final String ERROR_STRING_IMAGE_PUBLISH_CHANGE_FAILED = "Image publish change failed causedby persistent";
	static final int ERROR_CODE_IMAGE_PUBLISH_CHANGE_SUCESS = 12007;
	static final String ERROR_STRING_IMAGE_PUBLISH_CHANGE_SUCESS = "Image publish change sucess";
	static final int ERROR_CODE_IMAGE_UNPUBLISH_CHANGE_FAILED = 12008;
	static final String ERROR_STRING_IMAGE_UNPUBLISH_CHANGE_FAILED = "Image unpublish change failed causedby persistent";
	static final int ERROR_CODE_IMAGE_UNPUBLISH_CHANGE_SUCESS = 12009;
	static final String ERROR_STRING_IMAGE_UNPUBLISH_CHANGE_SUCESS = "Image unpublish change sucess";
	static final int ERROR_CODE_IMAGE_PERSISTENT_CHANGE_FAILED = 12010;
	static final String ERROR_STRING_IMAGE_PERSISTENT_CHANGE_FAILED = "Image persistent change failed causedby publish";
	static final int ERROR_CODE_IMAGE_PERSISTENT_CHANGE_SUCESS = 12011;
	static final String ERROR_STRING_IMAGE_PERSISTENT_CHANGE_SUCESS = "Image persistent change sucess";
	static final int ERROR_CODE_IMAGE_UNPERSISTENT_CHANGE_FAILED = 12012;
	static final String ERROR_STRING_IMAGE_UNPERSISTENT_CHANGE_FAILED = "Image persistent change failed causedby publish";
	static final int ERROR_CODE_IMAGE_UNPERSISTENT_CHANGE_SUCESS = 12013;
	static final String ERROR_STRING_IMAGE_UNPERSISTENT_CHANGE_SUCESS = "Image unpersistent change sucess";
	static final int ERROR_CODE_IMAGE_ENABLE_CHANGE_SUCESS = 12014;
	static final String ERROR_STRING_IMAGE_ENABLE_CHANGE_SUCESS = "Image enable change sucess";
	static final int ERROR_CODE_IMAGE_ENABLE_CHANGE_FAILED = 12015;
	static final String ERROR_STRING_IMAGE_ENABLE_CHANGE_FAILED = "Image enable change failed because it is used image";
	static final int ERROR_CODE_IMAGE_UNENABLE_CHANGE_SUCESS = 12016;
	static final String ERROR_STRING_IMAGE_UNENABLE_CHANGE_SUCESS = "Image unenable change sucess";
	static final int ERROR_CODE_IMAGE_UNENABLE_CHANGE_FAILED = 12017;
	static final String ERROR_STRING_IMAGE_UNENABLE_CHANGE_FAILED = "Image unenable change failed";

	/* --------------- Error code: 13000~13999 VNet ----------------- */
	static final int ERROR_CODE_VNET_NAME_DUPLICATED = 13001;
	static final String ERROR_STRING_VNET_NAME_DUPLICATED = "Vnet name is used";
	static final int ERROR_CODE_VNET_IS_USING = 13002;
	static final String ERROR_STRING_VNET_IS_USING = "Vnet is using,you can't delete it";
	static final int ERROR_CODE_VNET_LEASE_VALUE_DUPLICATED = 13003;
	static final String ERROR_STRING_VNET_LEASE_VALUE_DUPLICATED = "lease is used";
	static final int ERROR_CODE_LEASE_NAME_DUPLICATED = 13004;
	static final String ERROR_STRING_LEASE_NAME_DUPLICATED = "Lease name is used";
	/* --------------- Error code: 14000~14999 VM ----------------- */
	static final int ERROR_CODE_VM_TIME_OFF_COPY_DUPLICATED = 14000;
	static final String ERROR_STRING_VM_TIME_OFF_COPY_DUPLICATED = "beanutils copy timeoff error.";
	
	static final int ERROR_CODE_VM_SNAPSHOT_NAME_DUPLICATED = 14001;
	static final String ERROR_STRING_VM_SNAPSHOT_NAME_DUPLICATED = "the Snapshot name is used";
	static final int ERROR_CODE_VM_NOT_DISK_0_DUPLICATED = 14002;
	static final String ERROR_STRING_VM_NOT_DISK_0_DUPLICATED = "the VM OS disk  not find";

	/* --------------- Error code: 15000~15999 User ----------------- */
	static final int ERROR_CODE_USER_NO_AUTHORITY_GET_USER = 15001;
	static final String ERROR_STRING_USER_NO_AUTHORITY_GET_USER = "User has no authority to get other user info";
	static final int ERROR_CODE_USER_NAME_DUPLICATED = 15002;
	static final String ERROR_STRING_USER_NAME_DUPLICATED = "User name is used";
	static final int ERROR_CODE_USER_ROOT_NOT_DELETED = 15003;
	static final String ERROR_STRING_USER_ROOT_NOT_DELETED = "You can't delete root";
	static final int ERROR_CODE_USER_HAS_VNET = 15004;
	static final String ERROR_STRING_USER_HAS_VNET = "User has vnet,you can't delete the user";
	static final int ERROR_CODE_USER_HAS_IMAGE = 15005;
	static final String ERROR_STRING_USER_HAS_IMAGE = "User has image,you can't delete the user";
	static final int ERROR_CODE_USER_HAS_VM = 15006;
	static final String ERROR_STRING_USER_HAS_VM = "User has vm,you can't delete the user";
	static final int ERROR_CODE_USER_NO_AUTHORITY_DELETE_VNET = 15007;
	static final String ERROR_STRING_USER_NO_AUTHORITY_DELETE_VNET = "User has no authority to delete the vnet";
	static final int ERROR_CODE_USER_CHECKCODE_NULL = 15008;
	static final String ERROR_STRING_USER_CHECKCODE_NULL = "CheckCode is null";
	static final int ERROR_CODE_USER_CHECKCODE_NOT_CORRECT = 15009;
	static final String ERROR_STRING_USER_CHECKCODE_NOT_CORRECT = "User input checkCode is not correct";
	static final int ERROR_CODE_USER_NOT_LOGIN = 15010;
	static final String ERROR_STRING_USER_NOT_LOGIN = "User is not login or out of time";
	static final int ERROR_CODE_USER_PASSWD_VALIDATE_NOT_CORRECT = 15011;
	static final String ERROR_STRING_USER_PASSWD_VALIDATE_NOT_CORRECT = "User former password is not correct";
	static final int ERROR_CODE_USER_SAVE_SECURITY_NOT_CORRECT = 15012;
	static final String ERROR_STRING_USER_SAVE_SECURITY_NOT_CORRECT = "Save user to security db error";
	static final int ERROR_CODE_USE_NEOADMIN_GROUP_CANT_NOT_UPDATE = 15013;
	static final String ERROR_STRING_USE_NEOADMIN_GROUP_CANT_NOT_UPDATE = "neoadmin's group can't change the group manager";
	// add by guojing
	static final int ERROR_CODE_USER_INFO_ALLOCATE_NULL_VAR = 15014;
	static final String ERROR_STRING_USER_INFO_ALLOCATE_NULL_VAR = "Allocate userinfo has null variable";
	// add by ZhuTengfei
	static final int ERROR_CODE_USER_PASSWORD_TOO_SHORT = 15015;
	static final String ERROR_STRING_USER_PASSWORD_TOO_SHORT = "New password is too short";
	static final int ERROR_CODE_USER_PASSWORD_NEED_NUM = 15016;
	static final String ERROR_STRING_USER_PASSWORD_NEED_NUM = "New password has to contain one number at least";
	static final int ERROR_CODE_USER_PASSWORD_NEED_PHA = 15017;
	static final String ERROR_STRING_USER_PASSWORD_NEED_PHA = "New password has to contain one character at least";
	static final int ERROR_CODE_USER_PASSWORD_ERROR = 15018;
	static final String ERROR_STRING_USER_PASSWORD_ERROR = "Username or password is error";
	static final int ERROR_CODE_USER_NOT_IN_GROUP = 15019;
	static final String ERROR_STRING_USER_NOT_IN_GROUP = "User does not belong to any group!";
	static final int ERROR_CODE_USER_HAS_ASSIGN_VM = 15020;
	static final String ERROR_STRING_USER_HAS_ASSIGN_VM = "User has assigned vm! you can't delete it";
	static final int ERROR_CODE_USER_NAME_IS_EMPTY = 15021;
	static final String ERROR_STRING_USER_NAME_IS_EMPTY = "User login name can't empty";
	static final int ERROR_CODE_USER_PASSWD_IS_EMPTY = 15022;
	static final String ERROR_STRING_USER_PASSWD_IS_EMPTY = "User login password can't empty";
	static final int ERROR_CODE_USER_INFO_FIND_EMPTY = 15023;
	static final String ERROR_STRING_USER_INFO_FIND_EMPTY = "can not find record by uid in userinfo table";
	// add by guojing
	// add by wangzhuo
	/* --------------- Error code: 16000~16999 Icinga ----------------- */
	static final int ERROR_CODE_TIME_FORMAT_ERROR = 16001;
	static final String ERROR_STRING_TIME_FORMAT_ERROR = "The time you entered is malformed";
	
	static final int ERROR_CODE_ICINGA_BASH_NOT_FIND = 16002;
	static final String ERROR_STRING_ICINGA_BASH_NOT_FIND = "the icinga bash sh not find.";

	static final int ERROR_CODE_ICINGA_BASH_CANNOT_RUN = 16003;
	static final String ERROR_STRING_ICINGA_BASH_CANNOT_RUN = "the icinga bash sh cannot run.";

	static final int ERROR_CODE_ICINGA_BASH_RUN_FAILED = 16004;
	static final String ERROR_STRING_ICINGA_BASH_RUN_FAILED = "the icinga bash sh run with errors: ";

	static final int ERROR_CODE_CLASS_NOT_FOUND = 16005;
	static final String ERROR_STRING_CLASS_NOT_FOUND = "class not found";

	static final int ERROR_CODE_IO_EXCEPTION = 16006;
	static final String ERROR_STRING_IO_EXCEPTION = "IO Exception ocurred";
	
	/* --------------- Error code: 17000~17999 Offering ----------------- */
	// Error code: 17000~17099 Hardware Offering
	static final int ERROR_CODE_HD_OFFERING_ALLOCATE_WRONG_PARAM = 17000;
	static final String ERROR_STRING_HD_OFFERING_ALLOCATE_WRONG_PARAM = "the HDOffering obj must contains all properties when allocating";

	static final int ERROR_CODE_HD_OFFERING_FINDALL_WRONG_PARAM = 17001;
	static final String ERROR_STRING_HD_OFFERING_FINDALL_WRONG_PARAM = "the HDOffering obj can not be null when findAll";

	/* --------------- Error code: 18000~18999 Software distribution ----------------- */
	static final int ERROR_CODE_SOFT_DISTRIBUTE_SENDDOWNLOADREQ_FAIELD = 18001;
	static final String ERROR_STRING_SOFT_DISTRIBUTE_SENDDOWNLOADREQ_FAILED = "Failed to send download request to output stream";

	static final int ERROR_CODE_SOFT_DISTRIBUTE_INVALID_VM_IP = 18002;
	static final String ERROR_STRING_SOFT_DISTRIBUTE_INVALID_VM_IP = "The input vm ip is not valid";

	static final int ERROR_CODE_SOFT_DISTRIBUTE_UNKNOWN_VM_HOSTNAME = 18003;
	static final String ERROR_STRING_SOFT_DISTRIBUTE_UNKNOWN_VM_HOSTNAME = "Unknown vm hostname";

	static final int ERROR_CODE_SOFT_DISTRIBUTE_CONNECT_VM_SOCKET_FAILED = 18004;
	static final String ERROR_STRING_SOFT_DISTRIBUTE_CONNECT_VM_SOCKET_FAILED = "Failed to connect vm, socket has been closed or shutdown";

	static final int ERROR_CODE_SOFT_DISTRIBUTE_START_DOWNLOAD_INSTALL_SUCESS = 18005;
	static final String ERROR_STRING_SOFT_DISTRIBUTE_START_DOWNLOAD_INSTALL_SUCESS = "Start download and install softwares sucess";
	
	static final int ERROR_CODE_SOFT_DISTRIBUTE_CONNECT_APACHE_SOCKET_FAILED = 18006;
	static final String ERROR_STRING_SOFT_DISTRIBUTE_CONNECT_APACHE_SOCKET_FAILED = "Failed to connect apache server, server has been closed or shutdown";
//	
//	static final int ERROR_CODE_SOFT_DISTRIBUTE_ = 18007;
//	static final String ERROR_STRING_SOFT_DISTRIBUTE_ = "";
//	
//	static final int ERROR_CODE_SOFT_DISTRIBUTE_ = 18008;
//	static final String ERROR_STRING_SOFT_DISTRIBUTE_ = "";
//	
//	static final int ERROR_CODE_SOFT_DISTRIBUTE_ = 18009;
//	static final String ERROR_STRING_SOFT_DISTRIBUTE_ = "";

	// add by guojing
	/* --------------- Error code: 20000~22000 Security ----------------- */
	static final int ERROR_CODE_GROUP_ALLOCATE_NULL_VAR = 20001;
	static final String ERROR_STRING_GROUP_ALLOCATE_NULL_VAR = "Allocate group has null variable";

	static final int ERROR_CODE_ROLE_ALLOCATE_NULL_VAR = 20002;
	static final String ERROR_STRING_ROLE_ALLOCATE_NULL_VAR = "Allocate role has null variable";

	static final int ERROR_CODE_ROLE_PRIVILEGE_ALLOCATE_NULL_VAR = 20003;
	static final String ERROR_STRING_ROLE_PRIVILEGE_ALLOCATE_NULL_VAR = "Allocate role privilege has null variable";

	static final int ERROR_CODE_HOSTPRI_ALLOCATE_NULL_VAR = 20004;
	static final String ERROR_STRING_HOSTPRI_ALLOCATE_NULL_VAR = "Allocate hostPri has null variable";

	static final int ERROR_CODE_IMAGEPRI_ALLOCATE_NULL_VAR = 20005;
	static final String ERROR_STRING_IMAGEPRI_ALLOCATE_NULL_VAR = "Allocate imagePri has null variable";

	static final int ERROR_CODE_VMMPRI_ALLOCATE_NULL_VAR = 20006;
	static final String ERROR_STRING_VMMPRI_ALLOCATE_NULL_VAR = "Allocate vmmPri has null variable";

	static final int ERROR_CODE_GROUP_HAS_USER = 20007;
	static final String ERROR_STRING_GROUP_HAS_USER = "group has user ! you can't delete";

	static final int ERROR_CODE_GROUP_HAS_SAME_NAME = 20008;
	static final String ERROR_STRING_GROUP_HAS_SAME_NAME = "group has same name aready ";

	static final int ERROR_CODE_GROUP_IS_SUPER_GROUP = 2009;
	static final String ERROR_STRING_GROUP_IS_SUPER_GROUP = "group is default group ";

	static final int ERROR_CODE_GROUP_HAS_CHILD_GROUP = 20010;
	static final String ERROR_STRING_GROUP_CHILD_GROUP = "group has child group or group is default group ! you can't delete";

	static final int ERROR_CODE_ROLE_IS_DEFAULT_GROUP_ROLE = 20011;
	static final String ERROR_STRING_ROLE_IS_DEFAULT_GROUP_ROLE = "role is default group role ! you must delete group first";

	static final int ERROR_CODE_ROLE_IS_SUPER_ROLE = 20012;
	static final String ERROR_STRING_ROLE_IS_SUPER_ROLE = "role is super role ! you can not delete it";

	static final int ERROR_CODE_ROLE_HAS_CHILD_ROLE = 20013;
	static final String ERROR_STRING_ROLE_HAS_CHILD_ROLE = "role has child role ! you can not delete it";

	static final int ERROR_CODE_ROLE_HAS_SAME_NAME = 20014;
	static final String ERROR_STRING_ROLE_HAS_SAME_NAME = "role has same name aready";

	// Added by Joey: call shell script "neouseradd" failed
	static final int ERROR_CODE_NEOUSERADD_FAILED = 20015;
	static final String ERROR_STRING_NEOUSERADD_FAILED = "failed to execute neouseradd command";

	// Added by Joey: call shell script "neouserdel" failed
	static final int ERROR_CODE_NEOUSERDEL_FAILED = 20016;
	static final String ERROR_STRING_NEOUSERDEL_FAILED = "failed to execute neouserdel command";

	// Added by Joey: has the same id or group id when allocating ImagePri
	static final int ERROR_CODE_IMAGE_PRI_SAME_GROUP = 20017;
	static final String ERROR_STRING_IMAGE_PRI_SAME_GROUP = "the imagePri has the same id or group id when allocating ImagePri";

	// Added by Joey: The image of ImagePri can not be public
	static final int ERROR_CODE_IMAGE_PRI_IMAGE_CANNOT_PUBLIC = 20018;
	static final String ERROR_STRING_IMAGE_PRI_IMAGE_CANNOT_PUBLIC = "The image in ImagePri can not be public";

	// Added by Joey: inform to neoswap daemon by socket - UnknownHostException
	static final int ERROR_CODE_NEOSWAP_INFORMED_UNKNOWND_SOCKET = 20019;
	static final String ERROR_STRING_NEOSWAP_INFORMED_UNKNOWND_SOCKET = "The host of socket addr is unknown when informing the neoswap daemon";

	// Added by Joey: inform to neoswap daemon by socket - input/output IOException
	static final int ERROR_CODE_NEOSWAP_INFORMED_SOCKETIO_FAILED = 20020;
	static final String ERROR_STRING_NEOSWAP_INFORMED_SOCKETIO_FAILED = "The socket input/output stream is error when informing the neoswap daemon";

	static final int ERROR_CODE_GROUP_HAS_MAX_CHILD = 20021;
	static final String ERROR_STRING_GROUP_HAS_MAX_CHILD = "The parent group has max child group,can not add more child group";

	static final int ERROR_CODE_ROLE_HAS_MAX_CHILD = 20022;
	static final String ERROR_STRING_ROLE_HAS_MAX_CHILD = "The parent role has max child,can not add more child role";
	
	// add by guojing

	// other exception(21000 -219999)
	//add by zhutengfei: About export auditrecord to xls
	static final int ERROR_CODE_XLS_ROWS_EXCEEDED = 21000;
	static final String ERROR_STRING_XLS_ROWS_EXCEEDED = "The row accessed exceeds its range.";
	static final int ERROR_CODE_XLS_WRITE_FILE = 21001;
	static final String ERROR_STRING_XLS_WRITE_FILE = "Fail to write the file.";
	
	
	//add by jiasong (22000-23000)
	static final int ERROR_CODE_UKEY_LOGIN_FAILED = 22000;
	static final String ERROR_STRING_UKEY_LOGIN_FAILED = "Ukey login failed";
	
	static final int ERROR_CODE_UKEY_GENERATECERT_FAILED = 22001;
	static final String ERROR_STRING_UKEY_GENERATECERT_FAILED = "Generate cert error";
	
	static final int ERROR_CODE_UKEY_IMPORTCERT_FAILED = 22002;
	static final String ERROR_STRING_UKEY_IMPORTCERT_FAILED = "Import cert error";
	
	static final int ERROR_CODE_UKEY_READ_CERT_PKEY_FAILED = 22003;
	static final String ERROR_STRING_UKEY_READ_CERT_PKEY_FAILED = "Read cert or privatekey failed";
	
	static final int ERROR_CODE_UKEY_INSERT_UKEY = 22004;
	static final String ERROR_STRING_UKEY_INSERT_UKEY = "Please insert the Ukey into server";
	
	static final int ERROR_CODE_UKEY_SOPIN_WRONG = 22005;
	static final String ERROR_STRING_UKEY_SOPIN_WRONG = "So Pin is wrong";
	
	//add by huanghong (24001-25000)
	static final int ERROR_CODE_BACKUP_CMD_FAILED = 24001;
	static final String ERROR_STRING_BACKUP_CMD_FAILED = "No mysql be found or access backup file failed";
	
	static final int ERROR_CODE_BACKUP_JDBC_FAILED = 24002;
	static final String ERROR_STRING_BACKUP_JDBC_FAILED = "Load JDBC failed";
	
	static final int ERROR_CODE_BACKUP_SQL_FAILED = 24003;
	static final String ERROR_STRING_BACKUP_SQL_FAILED = "SQL error, no data or data was damaged";
}
