package com.designpattern.factory.abstractfactory;

public class ProductB2 implements IProduct {


	private String name;

	public ProductB2(String name) {
		this.name = name;
	}

	@Override
	public void prit() {
		System.out.println("This productB2 name is " + this.name);
	}

}
