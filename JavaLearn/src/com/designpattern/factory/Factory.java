package com.designpattern.factory;

import java.util.Date;

public class Factory implements IFactory {

	@Override
	public IProduct getProduct(String name ,Date date) {
		return new Product(name, date);
	}

}
