package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by liyongguan on 2017/12/29.
 * 大数据批量检索工具类
 */
public class DataDownUtil {

    /**
     * 根据url和编码集获得html的源代码
     * @param url
     * @param encoding
     * @return
     */
    public static String getHtmlResourceByUrl(String url,String encoding){
        StringBuffer sb = new StringBuffer();
        try{
            //建立url
            URL urlObj = new URL(url);
            //建立网络连接
            URLConnection connection = urlObj.openConnection();
            //将网络连接流转换成文件输入流
            InputStreamReader isr = new InputStreamReader(connection.getInputStream(),encoding);
            //将文件流写入到缓存中
            BufferedReader br = new BufferedReader(isr);

            String temp = null;
            while ((temp = br.readLine()) != null){
                sb.append(temp);
            }




        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args){
        //根据网址和网页的编码集获得网页的源代码


        //解析网页源代码，获得对应自定义采集内容

        //返回到页面


    }
}
