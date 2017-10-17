package com.algorithm.divideandconquer;

public class RoundRobin {

	public static void main(String[] args) {
		int size = 8;
		int[][] table = new int[size + 1][size + 1];
		roundMatch2(table, size, 3);
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void roundMatch(int[][] a, int n) {
		if (a == null)
			return;
		if (n == 1) {
			a[0][0] = 1;
			return;
		}
		int m = n / 2;
		roundMatch(a, m);// 左上
		// 右上区域
		for (int i = 0; i < m; i++) {
			for (int j = m; j < n; j++) {
				a[i][j] = a[i][j - m] + m;
			}
		}
		// 左下区域
		for (int i = m; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = a[i - m][j] + m;
			}
		}
		// 右下区域
		for (int i = m; i < n; i++) {
			for (int j = m; j < n; j++) {
				a[i][j] = a[i - m][j - m];
			}
		}
	}

	public static void roundMatch2(int[][] a, int n, int k) {
		if (a == null)
			return;
		if (n == 1) {
			a[0][0] = 1;
			return;
		}
		for (int i = 1; i <= n; i++)
			a[1][i] = i;
		int m = 1;
		for (int s = 1; s <= k; s++) {
			n /= 2;
			for (int t = 1; t <= n; t++)
				for (int i = m + 1; i <= 2 * m; i++)
					for (int j = m + 1; j <= 2 * m; j++) {
						a[i][j + (t - 1) * 2 * m] = a[i - m][j + (t - 1) * 2 * m - m];/* 右下角的值等于左上角的值 */
						a[i][j + (t - 1) * 2 * m - m] = a[i - m][j + (t - 1) * 2 * m];/* 左下角的值等于右上角的值 */
					}
			m *= 2;
		}
	}
}
