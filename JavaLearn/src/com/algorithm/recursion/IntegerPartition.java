package com.algorithm.recursion;

/**
 * 整数切分
 * @author zlq
 *
 */
public class IntegerPartition {

	static int co = 0;

	public static void main(String[] args) {
		System.out.println(partition(6, 6));
		System.out.println(co);
		System.out.println(partition1(6, 6));
		System.out.println(co1);
		for(int i = 0;i<7;i++){
			for(int j = 0;j<7;j++)
				System.out.print(result[i][j]+" " );
			System.out.println();
		}
	}

	//正常递归
	public static int partition(int n, int m) {
		co++;
		if (n == 1 || m == 1)
			return 1;
		if (n < m)
			partition(n, n);
		if (n > m && m > 1) {
			return partition(n - m, m) + partition(n, m - 1);
		} else {
			return partition(n, n - 1) + 1;
		}
	}

	static int result[][] = new int[10][10];
	static int co1 = 0;
	//动态规划的递归，记录结果
	public static int partition1(int n, int m) {
		co1++;
		if (n == 1 || m == 1) {
			result[n][m] = 1;
			
			return result[n][m];
		}
		if (n < m) {
			result[n][n] = (result[n][n] == 1) ? result[n][n] : partition(n, n);
			return result[n][n];
		}

		if (n > m && m > 1) {
			result[n][m] = (result[n][n] == 1) ? result[n][n] :( partition(n - m, m) + partition(n, m - 1));
			return result[n][m];
		} else {
			result[n][m] = (result[n][n] == 1) ? result[n][n] :(partition(n, n - 1) + 1);
			return result[n][m] ;
		}
	}
}
