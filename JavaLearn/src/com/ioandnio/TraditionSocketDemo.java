package com.ioandnio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TraditionSocketDemo {

	public static void main(String[] args) throws IOException {
		generalMethod();
		
	}
	
	//普通方式
	public static void generalMethod() throws IOException{
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(7777);
		System.out.println("服务端启动...");
		while(true){
			//获取socket客户端
			Socket socket = serverSocket.accept();
			System.out.println("有新客户连接..."+socket.getInetAddress());
			
			InputStream is = socket.getInputStream();
			byte[] b = new byte[1024];
			while(true){
				int data = is.read(b);
				if(data!=-1){
					String info = new String(b, 0, data,"utf-8");
					System.out.println(info);
				}else{
					break;
				}
			}
		}
	}
	//线程池的方式
	public static void threadPoolMethod() throws IOException{
		ExecutorService threadPool = Executors.newCachedThreadPool();
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(7777);
		while(true){
			Socket socket = serverSocket.accept();
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("有新客户连接..."+socket.getInetAddress());
						
						InputStream is = socket.getInputStream();
						byte[] b = new byte[1024];
						while(true){
							int data = is.read(b);
							if(data!=-1){
								String info = new String(b, 0, data,"utf-8");
								System.out.println(info);
							}else{
								break;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
		}
	}
}
