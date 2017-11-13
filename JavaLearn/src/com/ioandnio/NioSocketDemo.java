package com.ioandnio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;

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
	
	
	public void gatherAndScagtter(SelectionKey selectionKey) throws IOException{
		ByteBuffer first = ByteBuffer.allocate(1024);
		ByteBuffer second = ByteBuffer.allocate(1024);
		ByteBuffer [] buffArr = {first,second};
		SocketChannel channel  =(SocketChannel)selectionKey.channel();
		channel.read(buffArr);
		channel.write(buffArr);
	}
	
	public void fileChannel() throws IOException{
		RandomAccessFile file = new RandomAccessFile("", "rw");
		FileChannel channel = file.getChannel();//打开
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int data = channel.read(buffer);//读数据
		channel.write(buffer);//写数据
		long size = (int) channel.size();//关联文件的大小
		
		channel.truncate(1024);//截取文件
		channel.force(false);//强制写到磁盘  false不写入元数据（权限信息等）,true写入元数据
		channel.close();//关闭
	}
	
	
	public void serverSocketChannel() throws IOException{
		ServerSocketChannel channel = ServerSocketChannel.open();//打开
		channel.bind(new InetSocketAddress(9999));//绑定端口
		channel.configureBlocking(false);//设置非阻塞
		while(true){
			channel.accept();//监听新进来的TCP连接
		}
		//channel.close();//关闭
	}
	
}
