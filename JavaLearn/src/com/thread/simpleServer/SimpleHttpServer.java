package com.thread.simpleServer;

import java.beans.IndexedPropertyChangeEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleHttpServer {
	
	private static class HttpRequestHandler implements Runnable{
		
		private Socket socket = null;
		public HttpRequestHandler(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			String line = null;
			BufferedReader  br = null;
			BufferedReader reader = null;
			PrintWriter writer = null;
			InputStream in = null;
			
			try{
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String header = reader.readLine();
				//由相对路径计算出绝对路径
				//String filePath =String 
				
				
			}catch (Exception e) {
				
			}finally {
				
			}
		}
	}
}
