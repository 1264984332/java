package com.proxy.jdkproxy2;

/**
 * Created by liyongguan on 2018/1/11.
 */
public class CarProxyTest {
    public static void main(String[] args){
        CarProxy proxy = new CarProxy();
        Car car1 = (Car)proxy.bind(new CarImpl());
        car1.carRun();
    }
}
