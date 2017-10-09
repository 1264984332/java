package com.designpattern.builder;

public class Client {

	public static void main(String[] args) {
		
		BuilderEntity  entity= Builder.instanceBulider().putParam("first", "FirstValue").putFirst("first1").builder();
		System.out.println("entity value is "+entity.getParams().get("first"));
		System.out.println("entity first value is "+entity.getFirst());
	}
}
