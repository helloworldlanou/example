/**
 * 
 */
package icinga.dao;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.IcingaService;

import common.consts.NeoException;

/**
 * @author root
 *
 */
public class IcingaServiceDaoImplTest {

	private  IcingaServiceDao icingaServiceDao;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//icingaServiceDao = new IcingaServiceDaoImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("结束！");
	}

	@Test
	public void test() {
		
		new Thread(new MyRun()).start();
		
		/*
		List<IcingaService> result = null;
		try {
			result = icingaServiceDao.findByHostGroupName(null);
		} catch (NeoException e) {
			e.printStackTrace();
		}
		for (IcingaService icingaService : result) {
			System.out.println(icingaService.getDisplay_name() + " "+icingaService.getOutput() + " "+icingaService.getAction_url());
		}
		Assert.assertTrue(result.size()>0);
		*/
	}

}
