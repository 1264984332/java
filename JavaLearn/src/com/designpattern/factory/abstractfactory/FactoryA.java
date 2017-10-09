package com.designpattern.factory.abstractfactory;

public class FactoryA implements IAbstractFactory{

	private static FactoryA factoryA = null;
	private FactoryA(){}
	
	public static FactoryA getInstance() {
		if(factoryA==null){
			synchronized(FactoryA.class){
				if(factoryA==null)
					factoryA = new FactoryA();
			}
		}
		return factoryA;
	}

	@Override
	public ProductA getProduct(String key,String name) {
		if(!"A".equals(key))
			return null;
		else 
			return new ProductA(name);
	}

}
