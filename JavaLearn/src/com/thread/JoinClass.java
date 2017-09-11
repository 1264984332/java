package com.thread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class JoinClass {

	private static final int THREAD_COUNT = 12;/* 12���̷ֶ߳����� */
	private static final int NUMBER_COUNT = 201600;
	private static final int PER_COUNT = NUMBER_COUNT / THREAD_COUNT;
	private static final int RANDOM_LIMIT = 10000000;

	public static void main(String[] args) throws InterruptedException {
		// Ϊ����������ֵ, Ϊ�˷���鿴, Ϊ�����10000000���ڵ�ֵ
		Random random = new Random();
		int[] array = new int[NUMBER_COUNT];
		for (int i = 0; i < THREAD_COUNT; i++) {
			array[i] = random.nextInt(RANDOM_LIMIT);
		}
		
		List<Thread> threadList = new LinkedList<>();
		for (int index = 0; index < THREAD_COUNT; ++index) {
			Thread t = new Thread(new SortRunnable(array, index * PER_COUNT, (index + 1) * PER_COUNT));
			t.start();
			threadList.add(t);
		}

		// �ȴ��߳��������
		join(threadList);

		// �ֶκϲ�
		int[] result = merge(array, PER_COUNT, THREAD_COUNT);
		if (check(result)) {
			System.out.println("correct");
		}
	}

	private static boolean check(int[] array) {
		for (int i = 0; i < array.length - 1; ++i) {
			if (array[i] > array[i + 1]) {
				System.out.println("error");
				return false;
			}
		}
		return true;
	}

	private static void join(List<Thread> threads) throws InterruptedException {
		for (Thread thread : threads) {
			thread.join();
		}
	}

	/**
	 * �ֶκϲ�
	 *
	 * @param array
	 *            �Ѿ��ֶ��ź��������
	 * @param size
	 *            ÿ�εĳ���
	 * @param count
	 *            һ���Ķ���
	 * @return
	 */
	private static int[] merge(int[] array, int size, int count) {

		// indexes����arrayÿ�ε���ʼλ��
		int[] indexes = new int[count];
		for (int i = 0; i < count; ++i) {
			indexes[i] = i * size;
		}

		int[] result = new int[array.length];
		// i����result�±�
		for (int i = 0; i < result.length; ++i) {

			int minNumber = Integer.MAX_VALUE;
			int minIndex = 0;
			// �ڲ�forѭ��������: �ҳ���count������С���Ǹ�ֵ
			for (int index = 0; index < indexes.length; ++index) {
				// indexes[index]: ��ǰ�ε���ʼλ��
				if ((indexes[index] < (index + 1) * size) && (array[indexes[index]] < minNumber)) {
					minNumber = array[indexes[index]];
					minIndex = index;
				}
			}

			result[i] = minNumber;
			indexes[minIndex]++;
		}

		return result;
	}

	private static class SortRunnable implements Runnable {

		private int[] array;
		private int start;
		private int end;

		public SortRunnable(int[] array, int start, int end) {
			this.array = array;
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
			// �ֶ�����
			Arrays.sort(array, start, end);
		}
	}
}
