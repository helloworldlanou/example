package icinga.dao;

import java.util.List;

import common.consts.NeoException;

import beans.IcingaService;

import dao.base.BaseDao;


public interface IcingaServiceDao extends BaseDao<IcingaService> {
	
	/**
	 * @param params
	 * @return find icingaservices by CurrentState
	 * @throws Exception
	 */
	public List<IcingaService> findByCurrentState(IcingaService icingaService)
			throws NeoException;

	/**
	 * @param params
	 * @return find icingaservices by serviceIds
	 * @throws NeoException
	 */
	public List<IcingaService> findByServiceIds(IcingaService icingaService)
			throws NeoException;

	/**
	 * @param params
	 * @return find icingaservices by hostIds
	 * @throws NeoException
	 */
	public List<IcingaService> findByHostIds(IcingaService icingaService)
			throws NeoException;

	/**
	 * @param params
	 *            ,null means find all
	 * @return count of icingaservices by currentstate
	 * @throws NeoException
	 */
	public Integer findCountByCurrentState(IcingaService icingaService)
			throws NeoException;

	/**
	 * @param params
	 * @return find icingaservices by hostName
	 * @throws NeoException
	 */
	public List<IcingaService> findByHostName(IcingaService icingaService)
			throws NeoException;

	/**
	 * @param params
	 *            ,param = null for get all
	 * @return find icingaservices:checkvms by hostName
	 * @throws NeoException
	 */
	public List<IcingaService> findcheckvmsByHostName(
			IcingaService icingaService) throws NeoException;

	/**
	 * @param params
	 *            ,param = null for get all
	 * @return find icingaservices by hostgroupname
	 * @throws NeoException
	 */
	public List<IcingaService> findByHostGroupName(String hostgroupname)
			throws NeoException;

}
