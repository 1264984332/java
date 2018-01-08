package com.ioandnio;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by liyongguan on 2018/1/4.
 * 使用Nio进行文件的复制
 */
public class FileNioClass {
    private static final  String inFilePath = "E:\\1我的\\hadoop配置.txt";
    private static final  String outFilePath = "E:\\1我的\\hadoop配置副本.txt";

    public static void main(String[] args){
        //copyFile(inFilePath,outFilePath);
        System.out.println(~(-1L<<10));
        System.out.println(-1<<10);
        System.out.println(~1);
    }

    public static  void copyFile(String inFilePath,String outFilePath) {
        File inFile = new File(inFilePath);
        File outFile = new File(outFilePath);
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try{
            fin   = new FileInputStream(inFile);
            fout = new FileOutputStream(outFile);
            FileChannel inChanle = fin.getChannel();
            FileChannel outChanle = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(true){
                buffer.clear();
                int reader = inChanle.read(buffer);
                if(reader==-1){
                    System.out.println("复制完成。");
                    break;
                }

                buffer.flip();
                outChanle.write(buffer);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
