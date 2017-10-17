package com.designpattern.factory.abstractfactory;

public class ProductA2 implements IProduct {


	private String name;

	public ProductA2(String name) {
		this.name = name;
	}

	@Override
	public void prit() {
		System.out.println("This productA2 name is " + this.name);
	}

}
