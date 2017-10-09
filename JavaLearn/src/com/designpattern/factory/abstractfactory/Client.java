package com.designpattern.factory.abstractfactory;

public class Client {

	public static void main(String[] args) {
		IAbstractFactory factoryA = FactoryA.getInstance();
		IAbstractFactory factoryB = FactoryB.getInstance();
		ProductA productA = (ProductA) factoryA.getProduct("A", "profuctA");
		ProductB productB = (ProductB) factoryB.getProduct("B", "profuctB");
		productA.prit();
		productB.prit();
	}
}
