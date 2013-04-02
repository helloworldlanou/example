package dao.base;

import java.sql.Connection;

import common.consts.ExceptionConsts;
import common.consts.NeoException;


/**
 * The Conenction holder stored in ThreadLocal
 * 
 * @author Joey
 * 
 */
public class ConnectionHolder {

	private Connection connection = null;
	private boolean rollback = false;
	private boolean readonly = false;
	private boolean alreadyClosed = false;
	
	public boolean isAlreadyClosed() {
		return alreadyClosed;
	}

	public void setAlreadyClosed(boolean alreadyClosed) {
		this.alreadyClosed = alreadyClosed;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public Connection getConnection() throws NeoException {
		if (connection == null) {
			throw new NeoException(
					ExceptionConsts.ERROR_CODE_NO_CONNECTION_IN_TRANSACTION,
					ExceptionConsts.ERROR_STRING_NO_CONNECTION_IN_TRANSACTION);
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean isRollback() {
		return rollback;
	}

	public void setRollback(boolean rollback) {
		this.rollback = rollback;
	}
}
