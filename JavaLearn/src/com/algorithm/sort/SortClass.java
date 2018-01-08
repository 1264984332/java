package com.algorithm.sort;

public class SortClass {

	

	public static void main(String[] args) {

		int[] array1 = { 2, 4, 51, 53, 12, 3, 32, 12, 11, 10 };
		bubbleSort(array1);
		System.out.println("冒泡排序： ");
		print(array1);
		int[] array2 = { 2, 4, 51, 53, 12, 3, 32, 12, 11, 10 };
		System.out.println("选择排序12： ");
		selectionSort(array2);
		print(array2);
		int[] array3 = { 2, 4, 51, 53, 12, 3, 32, 12, 11, 10 };
		System.out.println("快速排序： ");
		quickSort(array3, 0, array3.length - 1);
		print(array3);
		int[] array4 = { 2, 4, 51, 53, 12, 3, 32, 12, 11, 10 };
		System.out.println("插入排序： ");
		insertSort1(array4);
		print(array4);
		int[] array5 = { 2, 4, 51, 53, 12, 3, 32, 12, 11, 10 };
		System.out.println("归并排序： ");
		mergeSort(array5, 0, 1);
		print(array5);
		int[] array6 = { 2, 4, 51, 53, 12, 3, 32, 12, 11, 10 };
		System.out.println("堆排序： ");
		heapSort(array6);
		print(array6);
	}

	/**
	 * 冒泡排序
	 *
	 * @param array
	 *            数组
	 */
	public static void bubbleSort(int[] array) {
		int len = array.length;
		if (len < 2)
			return;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * 选择排序
	 *
	 * @param array
	 *            数组
	 */
	public static void selectionSort(int[] array) {
		int len = array.length;
		if (len < 2)
			return;
		for (int i = 0; i < len; i++) {
			int k = i;
			for (int j = i + 1; j < len; j++) {
				if (array[k] > array[j]) {
					k = j;
				}
			}
			if (k != i) {
				int temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
	}

	/**
	 * 快速排序
	 *
	 * @param array
	 *            数组
	 * @param f
	 *            起始位置
	 * @param e
	 *            结束位置
	 */
	public static void quickSort(int[] array, int f, int e) {
		if (f > e)
			return;
		int povit = array[f];// 以第一个作为标记
		int low = f;
		int high = e;
		while (low < high) {
			while (povit <= array[high] && low < high)
				high--;
			if (low < high) {
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				low++;
			}
			while (array[low] <= povit && low < high)
				low++;
			if (low < high) {
				int temp = array[high];
				array[high] = array[low];
				array[low] = temp;
				high--;
			}
			if (f < low)
				quickSort(array, f, low - 1);
			if (high < e)
				quickSort(array, low + 1, e);
		}
	}

	/**
	 * 插入排序
	 *
	 * @param array
	 *            数组
	 */
	public static void insertSort(int[] array) {
		int len = array.length;
		if (len < 2)
			return;
		for (int i = 0; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				} else {
					break;
				}
			}
		}
	}

	public static void insertSort1(int[] array) {
		int len = array.length;
		if (len < 2)
			return;
		for (int i = 0; i < len; i++) {
			int key  =  array[i];
			for (int j = i; j > 0; j--) {
				if (key < array[j - 1]) {
					array[j] = array[j-1];
				} else {
					array[j] = key;
					break;
				}
			}
		}
	}
	/**
	 * 归并排序 主程序
	 *
	 * @param a
	 *            数组
	 * @param s
	 *            起始位置，一般是0
	 * @param len
	 *            起始长度，一般是1
	 */
	public static void mergeSort(int[] a, int s, int len) {
		int size = a.length;
		int mid = size / (len << 1);
		int c = size & ((len << 1) - 1);
		// -------归并到只剩一个有序集合的时候结束算法-------//
		if (mid == 0)
			return;
		// ------进行一趟归并排序-------//
		for (int i = 0; i < mid; ++i) {
			s = i * 2 * len;
			merge(a, s, s + len, (len << 1) + s - 1);
		}
		// -------将剩下的数和倒数一个有序集合归并-------//
		if (c != 0)
			merge(a, size - c - 2 * len, size - c, size - 1);
		// -------递归执行下一趟归并排序------//
		mergeSort(a, 0, 2 * len);
	}

	/**
	 * 归并排序的合并
	 *
	 * @param a
	 *            数组
	 * @param s
	 *            第一个数组的起始点
	 * @param m
	 *            第二个数组的起始点
	 * @param t
	 *            第二个数组的结束点
	 */
	private static void merge(int[] a, int s, int m, int t) {
		int[] tmp = new int[t - s + 1];
		int i = s, j = m, k = 0;
		while (i < m && j <= t) {
			if (a[i] <= a[j]) {
				tmp[k] = a[i];
				k++;
				i++;
			} else {
				tmp[k] = a[j];
				j++;
				k++;
			}
		}
		while (i < m) {
			tmp[k] = a[i];
			i++;
			k++;
		}
		while (j <= t) {
			tmp[k] = a[j];
			j++;
			k++;
		}
		System.arraycopy(tmp, 0, a, s, tmp.length);
	}
	/**
	 * 堆排序
	 * @param array
	 */
	public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        buildMaxHeap(array);  //构建最大堆
        //交换位置，排序，将堆顶跟叶节点交换
        for (int i = array.length - 1; i >= 1; i--) {
            exchangeElements(array, 0, i);
            maxHeap(array, i, 0);  //重新构建最大堆
        }
    }

    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;
        //从最后的非叶节点开始
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    /**
     * 构造最大堆
     * @param array
     * @param heapSize 堆的大小
     * @param index 根节点
     */
    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            exchangeElements(array, index, largest);//交互最大堆顶
            maxHeap(array, heapSize, largest);  //检查是否影响下层
        }
    }
    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
