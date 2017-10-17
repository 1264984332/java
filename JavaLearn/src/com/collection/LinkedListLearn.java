package com.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class LinkedListLearn {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		Random random =new Random();
		for(int i = 0;i<10;i++){
			list.add(random.nextInt(i+1));
		}
		for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
            if (i.next() == 0) {
                i.set(188);
                i.add(-1);
            }
        }
	}
}
