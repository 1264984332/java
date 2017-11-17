package com.thread.customerandproducter;

public class ThreadPoolTest {

	public static void main(String[] args) {

		 SecLogEntity log1 = new SecLogEntity();
	        log1.setLogName("test1");
	        log1.setLogSrc("seclog1");
	 
	        SecLogEntity log2 = new SecLogEntity();
	        log2.setLogName("test2");
	        log2.setLogSrc("seclog2");
	 
	      /*  SysLogEntity log3 = new SysLogEntity();
	        log3.setLogName("test3");
	        log3.setLogSrc("syslog1");
	 
	        SysLogEntity log4 = new SysLogEntity();
	        log4.setLogName("test4");
	        log4.setLogSrc("syslog2");
	 */
	        ThreadPoolManager.getThreadPoolManager().getSecLogThreadPool().execute(new SecLogProduceThread(log1));
	        ThreadPoolManager.getThreadPoolManager().getSecLogThreadPool().execute(new SecLogProduceThread(log2));
	        ThreadPoolManager.getThreadPoolManager().getSecLogThreadPool().execute(new SecLogCustomer());
	 /*
	        ThreadPoolManager.getInstance().getSysLogThreadPool().execute(new SysLogProduceThread(log3));
	        ThreadPoolManager.getInstance().getSysLogThreadPool().execute(new SysLogProduceThread(log4));
	        ThreadPoolManager.getInstance().getSysLogThreadPool().execute(new SysLogConsumeThread());*/
	}

}
