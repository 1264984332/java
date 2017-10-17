package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * iterator()方法返回一个迭代器Iterator.与其他容器主要用于存储数据不同,Iterator主要用于遍历容器. 
 * @author zlq
 *
 */
public class IteratorLearn {

	public static void main(String [] args) {
		Collection<Integer> collection = new ArrayList<>();
		Random random = new Random();
		for(int i = 0;i<10;i++)
			collection.add(random.nextInt(i+1));
		System.out.print("before:");
		for(Iterator<Integer> iterator = collection.iterator();iterator.hasNext();){
			Integer integer = iterator.next();
			System.out.printf(" %d",integer);
			if(integer==0)
				iterator.remove();
		}
		System.out.printf(" %nafter:");
		for(Integer integer:collection)
			System.out.printf(" %d",integer);
	}
	
}
