package com.designpattern.singleton;

/**
 * 饿汉式
 * 
 * @author zlq
 *
 */
public class Singleton {

	private Singleton() {
	}

	private static Singleton singleton = new Singleton();

	public static Singleton getInstance() {
		return singleton;
	}
}
