package com.javabasic.ObjectSort;

/**
 * Created by liyongguan on 2017/12/27.
 */
public class Student implements Comparable{
    private String name;
    private int id;

    public Student(String name,int id) {
        this.name=name;
        this.id=id;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        return (s.id-id)>0?1:-1;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
