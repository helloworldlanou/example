package dao.base;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.logicalcobwebs.proxool.ProxoolDataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.consts.ExceptionConsts;
import common.consts.NeoException;


/**
 * Danaus search transaction manager
 * 
 * @author wz
 * 
 */
public class TransactionManager {


	// Put the connection holder into each ThreadLocal
	private static ThreadLocal<ConnectionHolder> threadLocal = new ThreadLocal<ConnectionHolder>();

	/**
	 * Now, begin transaction. Set readonly = false as default
	 */
	public static void beginTransaction() {
		ConnectionHolder connectionHoler = null;
		Connection connection = null;
		try {
			connection = NkscloudConnectionManager.getInstance()
					.getConnection();
			connection.setAutoCommit(false);
			connectionHoler = new ConnectionHolder();
			connectionHoler.setConnection(connection);
			connectionHoler.setRollback(false);
			connectionHoler.setReadonly(false);
			threadLocal.set(connectionHoler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Now, begin transaction
	 */
	public static void beginTransaction(boolean readOnly) {
		ConnectionHolder connectionHoler = null;
		Connection connection = null;
		try {
			connection = NkscloudConnectionManager.getInstance()
					.getConnection();
			connection.setAutoCommit(false);
			connectionHoler = new ConnectionHolder();
			connectionHoler.setConnection(connection);
			connectionHoler.setRollback(false);
			connectionHoler.setReadonly(readOnly);
			connectionHoler.setAlreadyClosed(false);
			threadLocal.set(connectionHoler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Now, commit transaction, it's an end.
	 */
	public static void endTransaction() {
		ConnectionHolder connectionHolder = threadLocal.get();
		if (connectionHolder == null || connectionHolder.isAlreadyClosed()) {
			return;
		}
		Connection connection = null;
		try {
			connection = connectionHolder.getConnection();
			if (connection == null) {
				return;
			}
			if (!connectionHolder.isRollback()) {
				connection.commit();
				connection.setAutoCommit(true);
			}
			connectionHolder.setAlreadyClosed(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				close(connection);
			}
		}
	}

	/**
	 * Connection rollback
	 */
	public static void rollback() {
		ConnectionHolder connectionHolder = threadLocal.get();
		connectionHolder.setRollback(true);

		Connection connection = null;
		try {
			connection = connectionHolder.getConnection();
			if (connectionHolder.isReadonly()) {
			} else {
				connection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the connection
	 * 
	 * @return
	 * @throws NeoException
	 */
	public static Connection openConnection() throws NeoException {
		ConnectionHolder connectionHolder = threadLocal.get();
		if (connectionHolder == null) {
			return null;
		}
		return connectionHolder.getConnection();
	}

	/**
	 * Close the connection
	 * 
	 * @param connection
	 */
	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement, ResultSet resultSet) {
		try {
			close(statement);
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close the connection and statement
	 * 
	 * @param connection
	 * @param statement
	 */
	public static void close(Connection connection, Statement statement) {
		close(connection);
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close the connection, statement and resultset
	 * 
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void close(Connection connection, Statement statement,
			ResultSet resultSet) {
		close(connection, statement);
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

class NkscloudConnectionManager extends AbstractConnectionManager {


	/**
	 * JDBC config filename
	 */
	private static final String JDBC_FILE_NAME = "/extra-jdbc.properties";

	/**
	 * Singleton pattern instance object
	 */
	private static NkscloudConnectionManager instance;

	private ProxoolDataSource dataSource;

	/**
	 * Constructor
	 * 
	 * @throws NeoException
	 */
	private NkscloudConnectionManager() throws NeoException {
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
	public synchronized static NkscloudConnectionManager getInstance()
			throws NeoException {
		if (instance == null) {
			instance = new NkscloudConnectionManager();
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
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_OPEN_WEB_DB_FAILED,
					ExceptionConsts.ERROR_STRING_JDBC_OPEN_WEB_DB_FAILED);
		}
	}
}

abstract class AbstractConnectionManager {

	/**
	 * Driver class name for jdbc
	 */
	private static final String JDBC_DRIVER_CLASS = "driverClass";

	/**
	 * Database url for jdbc
	 */
	private static final String JDBC_DB_URL = "jdbcUrl";

	/**
	 * Username when connecting
	 */
	private static final String JDBC_CONNECTION_USERNAME = "user";

	/**
	 * Password when connecting
	 */
	private static final String JDBC_CONNECTION_PASSWORD = "password";

	/**
	 * The pool size when initing the pool
	 */
	private static final String JDBC_INIT_POOL_SIZE = "initialPoolSize";

	/**
	 * The max pool size
	 */
	private static final String JDBC_MAX_POOL_SIZE = "maxPoolSize";

	/**
	 * The max idle time
	 */
	private static final String JDBC_MAX_IDLE_TIME = "maxIdleTime";

	private static final String PROXOOL_CONNECTION_POOL_ALIAS = "cp_alias";

	/**
	 * If auto commit when closed
	 */
	private static final String JDBC_AUTO_COMMIT_WHEN_CLOSE = "autoCommitOnClose";

	public ProxoolDataSource initFromProperties(Properties properties)
			throws NeoException {
		// init the dataSource
		ProxoolDataSource dataSource = new ProxoolDataSource();
		dataSource.setTestBeforeUse(true);
		dataSource.setHouseKeepingTestSql("show tables;");
		dataSource.setUser(properties.getProperty(JDBC_CONNECTION_USERNAME));
		dataSource
				.setPassword(properties.getProperty(JDBC_CONNECTION_PASSWORD));
		dataSource.setDriverUrl(properties.getProperty(JDBC_DB_URL));
		try {
			dataSource.setDriver(properties.getProperty(JDBC_DRIVER_CLASS));
		} catch (Exception e) {
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_DRIVER_NOT_FOUND,
					ExceptionConsts.ERROR_STRING_JDBC_DRIVER_NOT_FOUND);
		}
		dataSource.setMaximumConnectionCount(Integer.parseInt(properties
				.getProperty(JDBC_MAX_POOL_SIZE)));
		dataSource.setMinimumConnectionCount(Integer.parseInt(properties
				.getProperty(JDBC_INIT_POOL_SIZE)));
		dataSource.setAlias(properties
				.getProperty(PROXOOL_CONNECTION_POOL_ALIAS));
		// dataSource.setInitialPoolSize(Integer.parseInt(properties
		// .getProperty(JDBC_INIT_POOL_SIZE)));
		// dataSource.setMaxPoolSize(Integer.parseInt(properties
		// .getProperty(JDBC_MAX_POOL_SIZE)));
		// dataSource.setMaxIdleTime(Integer.parseInt(properties
		// .getProperty(JDBC_MAX_IDLE_TIME)));
		// dataSource.setAutoCommitOnClose(Boolean.parseBoolean(properties
		// .getProperty(JDBC_AUTO_COMMIT_WHEN_CLOSE)));
		return dataSource;
	}

	/**
	 * Connection pool
	 * 
	 * @return
	 * @throws NeoException
	 */
	public synchronized final Connection getConnection(
			ProxoolDataSource dataSource) throws NeoException {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_JDBC_OPEN_CONNECTION_FAILD,
					ExceptionConsts.ERROR_STRING_JDBC_OPEN_CONNECTION_FAILD);
		}
		return conn;
	}

	/**
	 * Close the database connection
	 * 
	 * @param connection
	 * @throws NeoException
	 */
	public static void closeConnection(Connection connection)
			throws NeoException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new NeoException(
						ExceptionConsts.ERROR_CODE_JDBC_CLOSE_CONNECTION_FAILD,
						ExceptionConsts.ERROR_STRING_JDBC_CLOSE_CONNECTION_FAILD);
			}
		}
	}

	/**
	 * Close the Statement
	 * 
	 * @param statement
	 * @throws NeoException
	 */
	public static void closeStatement(Statement statement) throws NeoException {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new NeoException(
						ExceptionConsts.ERROR_CODE_JDBC_CLOSE_STATEMENT_FAILD,
						ExceptionConsts.ERROR_STRING_JDBC_CLOSE_STATEMENT_FAILD);
			}
		}
	}

	/**
	 * Close the database connection, statement and resultset
	 * 
	 * @param connection
	 * @param statement
	 * @param resultSet
	 * @throws NeoException
	 */
	public static void closeConnection(Connection connection,
			Statement statement, ResultSet resultSet) throws NeoException {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	/**
	 * @param resultSet
	 * @throws NeoException
	 */
	public static void closeResultSet(ResultSet resultSet) throws NeoException {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new NeoException(
						ExceptionConsts.ERROR_CODE_JDBC_CLOSE_RESULTSET_FAILD,
						ExceptionConsts.ERROR_STRING_JDBC_CLOES_RESULTSET_FAILD);
			}
		}
	}

	/**
	 * @param statement
	 * @param resultSet
	 * @throws NeoException
	 */
	public static void closeConnection(Statement statement, ResultSet resultSet)
			throws NeoException {
		closeResultSet(resultSet);
		closeStatement(statement);
	}

}
