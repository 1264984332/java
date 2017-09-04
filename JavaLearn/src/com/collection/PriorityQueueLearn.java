package com.collection;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueLearn {

	public static void main(String[] args) {
		Random random = new Random();
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i = 0 ;i<10;i++){
			queue.add(random.nextInt(100));
		}
		System.out.println();
			
		//wu xu
		for(Integer integer:queue)
			System.out.printf(" %d",integer);
		System.out.println();
		//you xu
		while(!queue.isEmpty()){
			System.out.printf(" %d",queue.poll());
		}
		System.out.println();
		for(Integer integer:queue)
			System.out.printf(" %d",integer);
	}
}
