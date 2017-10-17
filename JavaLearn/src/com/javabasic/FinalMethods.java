package com.javabasic;


public class FinalMethods {
	public void changeFinal(int a){
		a = a+1;
	}
	public void changeFinal(String a){
		a = a+"1";
	}
	public void changeFinal(FinalEntity a){
		a.setB("change");
		a.setA(12345);
	}
}
