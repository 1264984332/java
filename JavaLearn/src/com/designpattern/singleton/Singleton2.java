package com.designpattern.singleton;

/**
 * 懒汉式
 * @author zlq
 *
 */
public class Singleton2 {

	private Singleton2(){};
	private static Singleton2 singleton = null;
	public static Singleton2 getInstance(){
		if(singleton==null){
			synchronized(Singleton2.class){
				if(singleton==null){
					singleton = new Singleton2();
				}
			}
		}
		return singleton;
	}
}
