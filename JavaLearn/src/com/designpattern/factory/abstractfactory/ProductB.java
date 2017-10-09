package com.designpattern.factory.abstractfactory;
/**
 * 产品B
 * @author zlq
 *
 */
public class ProductB implements IProduct {
	private String name;

	public ProductB(String name) {
		this.name = name;
	}


	@Override
	public void prit() {
		System.out.println("This productB name is " + this.name);
	}

}
