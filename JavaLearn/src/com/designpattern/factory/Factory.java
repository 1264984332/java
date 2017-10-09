package com.designpattern.factory;

import java.util.Date;

public class Factory implements IFactory {

	@Override
	public IProduct getProduct(String key,String name ,Date date) {
		if("1".equals(key))
			return new Product(name, date);
		else if("2".equals(key))
			return new Product2(name, date);
		return null;
	}

}
