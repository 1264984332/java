package com.ioandnio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioSocketDemo {

	private Selector selector;//通道选择器
	
	public static void main(String[] args) throws IOException {
		NioSocketDemo nioSocketDemo = new NioSocketDemo();
		nioSocketDemo.initServer(8888);
		nioSocketDemo.lisenterSelector();
	}
	
	
	public void initServer(int port) throws IOException{
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);//设置非阻塞
		serverChannel.socket().bind(new InetSocketAddress(port));
		this.selector = Selector.open();//打开选择器
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("服务已启动...");
	}
	public void lisenterSelector() throws IOException{
		while(true){
			//等待客户连接
			//selector模型，多路复用
			this.selector.select();
			//从选择器获取事件
			Iterator<SelectionKey> iterator = this.selector.keys().iterator();
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				iterator.remove();
				//处理请求
				handler(key);
			}
		}
	}
	
	public void handler(SelectionKey selectionKey) throws IOException{
		if(selectionKey.isAcceptable()){
			//处理客户端连接请求
			ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
			SocketChannel socketChannel = channel.accept();
			socketChannel.configureBlocking(false);
			//接收客户端发送的信息，需要给通道设置读的权限
			socketChannel.register(selector, SelectionKey.OP_READ);
		}else if(selectionKey.isReadable()){
			//处理客户端读的事件
			SocketChannel channel = (SocketChannel) selectionKey.channel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int readData = channel.read(buffer);
			if(readData>0){
				String info = new String(buffer.array(),"GBK").trim();
				System.out.println("接收的数据： "+info);
			}else{
				System.out.println("客户端关闭...");
				selectionKey.cancel();
			}
		}
	}
}
