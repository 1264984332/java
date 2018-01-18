package com.leetcode.RemoveElement;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 0, 4, 4, 0, 4, 4, 4, 0, 2 };
		System.out.println(new RemoveElement().removeElement(a, 4));
	}

	public int removeElement(int[] nums, int val) {
		int m = 0;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != val) {
				nums[m] = nums[i];
				m++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		return m;
	}
}
