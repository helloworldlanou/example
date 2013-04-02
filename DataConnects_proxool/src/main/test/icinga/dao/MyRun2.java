package icinga.dao;

import java.util.List;

import beans.IcingaService;

import common.consts.NeoException;

public class MyRun2 implements Runnable{
	private static IcingaServiceDao icingaServiceDao;
	private static int tastcount = 0;
	private final int id = tastcount;//特殊！

	private List<IcingaService> result;
	
	public MyRun2(){
		tastcount++;
	}
	@Override
	public void run() {
		
		if(icingaServiceDao == null){
			icingaServiceDao = new IcingaServiceDaoImpl();
		}
		try {
			result = icingaServiceDao.findByHostGroupName(null);
		} catch (NeoException e) {
			e.printStackTrace();
		}
		
		if(result.size() != 62){
			System.out.print("myThreadID:"+this.id + " ");
			System.out.println("个数："+result.size());
		}
		
		
	}

}
