package com.designpattern.factory.simplefactory;

import java.util.Date;

public class Client {

	public static void main(String[] args) {
		IFactory  factory = new Factory();
		Product product = (Product) factory.getProduct("1","first", new Date());
		product.prit();
	}
}
