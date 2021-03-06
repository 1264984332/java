package com.proxy.jdkproxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liyongguan on 2018/1/11.
 */
public class CarProxy implements InvocationHandler {

    Object target;
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {

        Object result = method.invoke(target,args);
        return result;
    }
}
