package dao.base;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.consts.ExceptionConsts;
import common.consts.NeoException;


/**
 * Database connnection manager using proxool connection pool
 * 
 * @author Joey
 * 
 */
public class IcingaConnectionManager extends AbstractConnectionManager {

	private static final Logger logger = LoggerFactory
			.getLogger(IcingaConnectionManager.class);

	/**
	 * JDBC config filename
	 */
	private static final String JDBC_FILE_NAME = "/icinga-jdbc.properties";

	/**
	 * Singleton pattern instance object
	 */
	private static IcingaConnectionManager instance;

	private ProxoolDataSource dataSource;

	/**
	 * Constructor
	 * 
	 * @throws NeoException
	 */
	private IcingaConnectionManager() throws NeoException {
		logger.info("Init the IcingaConnectionManager...");
		// load properties from jdbc.properties
		Properties properties = new Properties();
		try {
			properties
					.load(this.getClass().getResourceAsStream(JDBC_FILE_NAME));
		} catch (IOException e) {
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_CONFIG_NOT_FOUND,
					ExceptionConsts.ERROR_STRING_JDBC_CONFIG_NOT_FOUND);
		}
		this.dataSource = super.initFromProperties(properties);
	}

	/**
	 * Singleton get instance method
	 * 
	 * @return The singleton instance
	 * @throws NeoException
	 */
	public synchronized static IcingaConnectionManager getInstance()
			throws NeoException {
		if (instance == null) {
			instance = new IcingaConnectionManager();
		}
		return instance;
	}

	/**
	 * Connection pool
	 * 
	 * @return
	 * @throws NeoException
	 */
	public synchronized final Connection getConnection() throws NeoException {
		try {
			return super.getConnection(this.dataSource);
		} catch (NeoException e) {
			throw new NeoException(ExceptionConsts.ERROR_CODE_JDBC_OPEN_ICINGA_DB_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_OPEN_ICINGA_DB_FAILED);
		}
	}

}
