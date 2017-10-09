package com.designpattern.factory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product2 implements IProduct {

	public String name;

	public Date productTime;

	public Product2() {
	}

	public Product2(String name, Date date) {
		this.name = name;
		this.productTime = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getProductTime() {
		return productTime;
	}

	public void setProductTime(Date productTime) {
		this.productTime = productTime;
	}

	@Override
	public void prit() {
		System.out.println("This product2 name is " + this.name + " and product date is "
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.productTime));
	}

}
