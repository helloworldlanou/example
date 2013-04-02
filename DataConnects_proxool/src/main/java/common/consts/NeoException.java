/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.consts;

/**
 * 
 * @author Joey
 */
public class NeoException extends Exception {

	private int errorCode;

	/**
	 * Constructor (private)
	 */
	private NeoException() {
	}

	/**
	 * Constructor
	 * 
	 * @param errorCode
	 *            The error code defined in NeoExceptionConsts
	 * @param message
	 *            The error message defined in NeoExceptionConsts
	 */
	public NeoException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Constructor
	 * 
	 * @param errorCode
	 *            The error code defined in NeoExceptionConsts
	 * @param message
	 *            The error message defined in NeoExceptionConsts
	 * @param cause
	 *            The throwable cause
	 */
	public NeoException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * Get the error code defined in NeoExceptionConsts
	 * 
	 * @return The error code defined in NeoExceptionConsts
	 */
	public int getErrorCode() {
		return this.errorCode;
	}
}
