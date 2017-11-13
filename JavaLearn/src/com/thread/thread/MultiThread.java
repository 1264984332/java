package com.thread.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 打印多线程的信息
 * @author zlq
 *
 */
public class MultiThread {

	public static void main(String[] args) {

		ThreadMXBean  threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] infos = threadMXBean.dumpAllThreads(false, false);
		for(ThreadInfo info:infos){
			System.out.println("["+info.getThreadId()+"]"+info.getThreadName());
		}
	}

}
