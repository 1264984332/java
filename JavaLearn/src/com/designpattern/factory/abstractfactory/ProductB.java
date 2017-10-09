package com.designpattern.factory.abstractfactory;

public class ProductB implements IProduct {
	private String name;

	public ProductB(String name) {
		this.name = name;
	}

	@Override
	public ProductB getProduct(String name) {

		return new ProductB(name);
	}

	@Override
	public void prit() {
		System.out.println("This productB name is " + this.name);
	}

}
