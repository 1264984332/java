package com.base;

/**
 * 枚举类的简单使用
 * @author lyg
 *
 */
public enum Color {
	RED,BULE,BLACK,GREEN,RED1("red1",1);
	private String name;
	private int index;
	private Color() {
	}
	
	private Color(String name,int index){
		this.index = index;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static void main(String[] args) {
		System.out.println(Color.RED);
		System.out.println(Color.RED1.getName());
	}
}
