package dao.base;

import java.util.List;


/**
 * Base dao implementation
 * 
 * @author wz
 * 
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Override
	public abstract int allocate(T t) throws Exception;

	@Override
	public abstract T findById(T t) throws Exception;

	@Override
	public abstract void deleteById(T t) throws Exception;

	@Override
	public abstract List<T> findAll(T t) throws Exception;

}
