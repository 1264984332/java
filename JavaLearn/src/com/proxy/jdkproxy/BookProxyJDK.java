package com.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liyongguan on 2018/1/5.
 * JDK动态代理
 */
public class BookProxyJDK implements InvocationHandler {

    public static void main(String[] args){
        BookCountImpl bookCount = new BookCountImpl();
        BookProxyJDK proxy = new BookProxyJDK();
        BookCount bookCount1 =(BookCount) proxy.bind(bookCount);
        bookCount1.addBook();
    }


    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {
        System.out.println("123");
        Object result=method.invoke(target,args);
        System.out.println("321");
        return result;
    }
}
