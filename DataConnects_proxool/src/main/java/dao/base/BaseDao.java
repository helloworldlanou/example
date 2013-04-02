package dao.base;

import java.util.List;


/**
 * 
 * The base interface of dao
 * 
 * @author wz
 * 
 */
public interface BaseDao<T> {

	/**
	 * Allocate a new T
	 * 
	 * @param t
	 * 
	 * @return If operation is successful, return the id of new T
	 * @throws NeoException
	 */
	public int allocate(T t) throws Exception;

	/**
	 * Get all T with filter
	 * 
	 * @return The array list of T
	 */
	public List<T> findAll(T t) throws Exception;

	/**
	 * Get T with id
	 * 
	 * @param t
	 * 
	 * @return The T with the id
	 */
	public T findById(T t) throws Exception;

	/**
	 * Delete T with id
	 * 
	 * @param t
	 * 
	 */
	public void deleteById(T t) throws Exception;

}
