package com.javabasic;


public class FinalClass {

	public final int a=0;//基本类型初始值
	public final String b = "b";//String类型初始值
	
	public static void main(String[] args) {
		FinalClass test =new FinalClass();
		FinalEntity finalTest3 = new FinalEntity();//引用型变量
		finalTest3.setA(test.a);
		finalTest3.setB(test.b);
		
		System.out.println("最初值：");
		System.out.print(test.a+"  "+test.b+"  "+finalTest3.getA()+"  "+finalTest3.getB());
		System.out.println();
		
		FinalMethods finalTest2 = new FinalMethods();
		finalTest2.changeFinal(test.a);//修改基本类型变量
		finalTest2.changeFinal(test.b);//修改String类型变量
		finalTest2.changeFinal(finalTest3);//修改引用型变量
		
		System.out.println("更改后值：");
		System.out.print(test.a+"  "+test.b+"  "+finalTest3.getA()+"  "+finalTest3.getB());
		System.out.println();
	}
}
