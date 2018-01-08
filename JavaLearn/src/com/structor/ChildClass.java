package com.structor;

/**
 * Created by liyongguan on 2017/12/27.
 */
public class ChildClass extends BaseClass1{
    public ChildClass(){
        System.out.println("ChildClass");
    }
    public ObjectClass2 o2= new ObjectClass2();
    public ObjectClass1 o1= new ObjectClass1();
    public static void main(String[] args){
        new ChildClass();
    }
}
