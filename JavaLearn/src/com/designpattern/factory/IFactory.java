package com.designpattern.factory;

import java.util.Date;

public interface IFactory {

	public IProduct getProduct(String name ,Date date);
}
