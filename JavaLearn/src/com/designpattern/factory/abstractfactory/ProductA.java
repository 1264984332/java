package com.designpattern.factory.abstractfactory;

public class ProductA implements IProduct {

	private String name;

	public ProductA(String name) {
		this.name = name;
	}

	@Override
	public ProductA getProduct(String name) {

		return new ProductA(name);
	}

	@Override
	public void prit() {
		System.out.println("This productA name is " + this.name);
	}

}
