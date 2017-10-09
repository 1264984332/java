package com.designpattern.factory;

import java.util.Date;

public class Client {

	public static void main(String[] args) {
		IFactory  factory = new Factory();
		Product product = (Product) factory.getProduct("first", new Date());
		product.prit();
	}
}
