package com.designpattern.factory.abstractfactory;

/**
 * 生产ProductA的工厂
 * @author zlq
 *
 */
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
	public IProduct getProduct(String key,String name) {
		if(!"A".equals(key))
			return  new ProductA2(name);
		else 
			return new ProductA(name);
	}

}
