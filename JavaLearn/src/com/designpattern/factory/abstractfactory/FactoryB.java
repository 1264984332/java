package com.designpattern.factory.abstractfactory;

/**
 * 生产ProductB的工厂
 * @author zlq
 *
 */
public class FactoryB implements IAbstractFactory {

	private static FactoryB factoryB = null;

	private FactoryB() {
	}

	public static  IAbstractFactory getInstance() {
		if (factoryB == null) {
			synchronized (FactoryB.class) {
				if (factoryB == null)
					factoryB = new FactoryB();
			}
		}
		return factoryB;
	}

	@Override
	public ProductB getProduct(String key, String name) {
		if (!"B".equals(key))
			return null;
		else
			return new ProductB(name);
	}

}
