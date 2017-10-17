package com.designpattern.factory.abstractfactory;
/**
 * 产品A
 * @author zlq
 *
 */
public class ProductA implements IProduct {

	private String name;

	public ProductA(String name) {
		this.name = name;
	}

	@Override
	public void prit() {
		System.out.println("This productA name is " + this.name);
	}

}
