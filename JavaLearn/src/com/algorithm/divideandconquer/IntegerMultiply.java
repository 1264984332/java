package com.algorithm.divideandconquer;

/**
 * @author zlq
 * 
 */
public class IntegerMultiply {

	public static void main(String[] args) {
		
		System.out.println(interMultiply(22,22,2));
	}
	// 大数相乘的思路为：将大数分成两份，分别求，再分成两份，直至变成一位
	static int interMultiply(int X, int Y, int n) {
		int sign = sign(X) * sign(Y);
		int x = Math.abs(X);
		int y = Math.abs(Y);
		if ((0 == x) || (0 == y))
			return 0;
		if (1 == n)
			return x * y;
		
		int XL = (int) (x / Math.pow(10, n / 2));//A
		int XR = (int) (x - XL * Math.pow(10, n / 2));//B
		int YL = (int) (y / Math.pow(10, n / 2));//C
		int YR = (int) (y - YL * Math.pow(10, n / 2));//D
		
		int XLYL = interMultiply(XL,  YL,  n/2);//AC
		int XRYR = interMultiply(XR, YR, n/2);//BD
        int XLYRXRYL = interMultiply(XL - XR, YR - YL, n/2) + XLYL + XRYR;//(A-B)*(D-C) 
        
        // 结果：AC*10(N) + (A-B)*(D-C)*10(N/2) + BD
        return sign * (XLYL * (int)Math.pow(10, n) + XLYRXRYL * (int)Math.pow(10, n/2) + XRYR);  
        
	}

	public static int sign(int x) {
		return x > 0 ? 1 : -1;
	}
}
