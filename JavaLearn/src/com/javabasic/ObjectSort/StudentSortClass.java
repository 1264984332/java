package com.javabasic.ObjectSort;

import java.util.Comparator;

/**
 * Created by liyongguan on 2017/12/27.
 */
public class StudentSortClass implements Comparator<Student> {

    @Override
    public int compare(Student o1,Student o2) {
        return o1.getId()-o2.getId();
    }

    public static void main(String[] args){
        System.out.println( System.getProperty("sun.arch.data.model"));
    }


}
