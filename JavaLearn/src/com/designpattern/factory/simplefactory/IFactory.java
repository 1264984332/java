package com.designpattern.factory.simplefactory;

import java.util.Date;

public interface IFactory {

	public IProduct getProduct(String key,String name ,Date date);
}
