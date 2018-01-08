package com.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetClass {

	public static void main(String[] args) {
		
		Set<Integer>set = new TreeSet();
		Set<Integer>set2 = new TreeSet(new myCompartor());
		
		for (int i = 19; i >= 0; i--) {
			set.add(i);
			set2.add(i);
		}
		
		System.out.println(set);
		System.out.println(set2);
	}
	public static class myCompartor implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
		
	}
}
