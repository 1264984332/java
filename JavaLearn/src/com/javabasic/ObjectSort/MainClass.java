package com.javabasic.ObjectSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyongguan on 2017/12/27.
 */
public class MainClass {
    public static void main(String[] args){
        Student s1 = new Student("zs",4);
        Student s2 = new Student("ls",2);
        Student s3 = new Student("ww",3);
        Student [] students = new Student[3];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        for (Student s:students) {
            System.out.println(s.getName());
        }
        Arrays.sort(students);
        System.out.println();
        for (Student s:students) {
            System.out.println(s.getName());
        }
        Arrays.sort(students,new StudentSortClass());
        System.out.println();
        for (Student s:students) {
            System.out.println(s.getName());
        }

    }
}
