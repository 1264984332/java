package com.collection;

import java.util.Set;

public class LinkedHashSet {

	public static void main(String[] args) {

		Set<Integer> set = new java.util.LinkedHashSet<>();
		for (int i = 0; i < 10; i++)
			set.add(i);
		for (int i = 19; i >= 0; i--) {
			set.add(i);
		}
		System.out.println(set);
	}

}
