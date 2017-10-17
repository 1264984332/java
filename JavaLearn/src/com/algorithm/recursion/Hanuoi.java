package com.algorithm.recursion;

/**
 * 汉诺塔
 * @author zlq
 *
 */
public class Hanuoi {

	public static void main(String[] args) {
		hanoi(3, "a", "b", "c");
	}

	//从a塔上移动到b塔上
	public static void hanoi(int n, String a, String b, String c) {
		if (n > 0) {
			hanoi(n - 1, a, c, b);
			System.out.println(a + "->" + b);
			hanoi(n - 1, c, b, a);
		}

	}
}
