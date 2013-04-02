package icinga.dao;

import java.util.List;

import beans.IcingaService;

import common.consts.NeoException;

public class MyRun implements Runnable{
	private static IcingaServiceDao icingaServiceDao;
	private static int tastcount = 0;
	private final int id = tastcount;//特殊！

	
	public MyRun(){
		tastcount++;
	}
	@Override
	public void run() {
		
		if(icingaServiceDao == null){
			icingaServiceDao = new IcingaServiceDaoImpl();
		}
		List<IcingaService> result = null;
		try {
			result = icingaServiceDao.findByHostGroupName(null);
		} catch (NeoException e) {
			e.printStackTrace();
		}
		System.out.print("myThreadID:"+this.id + " ");
		System.out.println("个数："+result.size());
//		for (IcingaService icingaService : result) {
//			System.out.print("myThreadID:"+this.id + " ");
//			System.out.println(icingaService.getDisplay_name() + " "+icingaService.getOutput() + " "+icingaService.getAction_url());
//			Thread.yield();
//		}
	}

}
