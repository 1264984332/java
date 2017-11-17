package com.thread;

import java.io.PipedReader;
import java.io.PipedWriter;
/**
 * 管道相关类
 * @author zlq
 *
 */
public class PipedClass {

	public static void main(String[] args) throws Exception {
		PipedWriter out = new PipedWriter();
		PipedReader in = new PipedReader();
		//输入输出流连接
		out.connect(in);
		Thread printThread = new Thread(new Print(in),"printThread");
		printThread.start();
		int receive = 0;
		try {
			while((receive=System.in.read())!=-1){
				System.out.println(receive);
				out.write(receive);
			}
		} finally {
			out.close();
		}
	}
	private static class Print implements Runnable{
		private PipedReader in;
		public Print(PipedReader in){
			this.in = in;
		}
		public void run(){
			int receive = 0;
			try {
				while((receive = in.read())!=-1){
					System.out.print((char)receive);
				}
			} catch (Exception e) {
			}
		}
	}

}
