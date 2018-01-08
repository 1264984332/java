package com.leetcode.SearchInsertPosition;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={1,3};
		System.out.println(new SearchInsertPosition().searchInsert(a, 2));
	}

	public int searchInsert(int[] nums, int target) {
		int index = 1;
		if(nums[0]>target||nums[0]==target){
			//System.out.println("a");
			return 0;
		}
			
		if(nums[nums.length-1]<target){
			//System.out.println("b");
			return nums.length;
		}
		
		for(;index < nums.length;index++){
			if(nums[index]==target){
				//System.out.println("c");
				return index;
			}
			if(nums[index-1]<target&&nums[index]>target){
				//System.out.println("d");
				return index;
			}
		}
		return index;
    }

}
