package com.algorithm.sort;

public class heapSortClass {

	public static void main(String[] args) {
		int[] array6 = { 1,2,3,4,5 ,6,7};
		System.out.println("堆排序： ");
		new heapSortClass().heapSort(array6);
		print(array6);
	}
	
	public void heapSort(int [] arr){
		bulidHeap(arr, arr.length);
		for(int i = arr.length-1;i>=0;i--){
			swap(arr, i, 0);
			exchangeHeap(arr, i, 0);
		}
	}
	
	public void bulidHeap(int [] arr, int size){
		if(size<=0||arr==null)
			return;
		int mid = size/2;
		for(int i = mid;i>=0;i--){
			exchangeHeap(arr, size, i);
		}
			
	}
	public void exchangeHeap(int [] arr,int size,int index){
		int left = index*2+2;
		int right = index*2+1;
		int max = index;
		if(left<size && arr[max]<arr[left]){
			max = left;
		}
		if(right<size && arr[max]<arr[right]){
			max = right;
		}
		if(max!=index){
			swap(arr, max, index);
			exchangeHeap(arr, size, max);
		}
		
	}
	public void swap(int [] arr,int a,int b){
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
