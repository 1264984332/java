package com.algorithm.dp;
/**
 * 动态规划 0-1背包问题
 * @author lyg
 * 
 * @version v1.0
 */
public class ZoreOneBackage {

	public static void main(String[] args) {
		int [] w = {2,2,6,5,4};
		int [] v = {6,3,5,4,6};
		int c = 10;
		int [] x = new int[5];//记录装入情况，0不装，1 装
		x[0] =1;
		int [][]m=new int[5][c+1];//需要维护的二维表，为了方便计算加入一列，其中第0列表示背包容量为0时背包的最大价值为0
		
		for(int i = 1;i<5;i++){
			for(int j = 1;j<=c;j++){
				if(j<w[i]){//剩余小于重量，不装入
					m[i][j] = m[i-1][j];
				}else{//可以装入的话，判断第i个不装入的值和装入的值大小
					m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i]]+v[i]);
				}
			}
		}
		System.out.println("最大值："+m[w.length-1][c]);
		
		for(int i = 4;i>0;i--){
			if(m[i][c]>m[i-1][c]){
				x[i] = 1;
				c -= w[i];
			}
			else
				x[i] = 0;
		}

		System.out.print("装入背包的物品编号是：");
		for(int i=0;i<5;i++){
			if(x[i]==1) 
				System.out.printf("%2d",(i+1));
		}
		
	}
}
