package com.algorithm.bigfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 大文件排序
 * @author lyg
 * 
 * 
 * 大文件数据排序，假设是从小到大排序。假设文件大小为10G，文件里面存的是无序的数字，然后分成的小的子文件。
 * 大致思路：
 * 1、先将大文件进行拆分，可以将每个子文件的数据行数设置为10W条，然后通过循环大文件进行拆分，当读取大文件的行数达到了10W条，就进行写入到子文件中
 * 2、对各个小文件进行排序，由于小文件的数据量也不是很小，而且无序，因此采用的算法是快排。排序可以在拆分的过程中实现。
 * 3、再对各个小文件进行多路合并，合并的过程中使用堆排序，
 * 	具体做法是（假设分成10个子文件）：
 * 		3.1 分别从10个文件取出第一个，这样有10个数，组成一个数组
 * 		3.2 获取数组中最小元素的下标，并取出该数写到目标文件
 * 		3.3	根据最小元素的下标，从相应的子文件中读取下一个元素，重新组成10个元素的数组
 * 		3.4	依次按照3.2和3.3的方法取数，如果某个文件的数读完了，则把数组的长度减一，把后面的前移。（或者新加一个相同的长度数组，标识该文件是否读取完，这样可以减少前移的循环）
 * @version v1.0
 */
public class BigFile {

	public static void main(String[] args) throws Exception {
		splitFiles("E:" + File.separator + "aaa" + File.separator + "a.txt",
				"E:" + File.separator + "aaa" + File.separator + "a1" + File.separator + "a");
		mergeSorted("E:" + File.separator + "aaa" + File.separator + "a1");
	}

	public static void splitFiles(String inFilePath, String outFilePath) throws IOException {
		//TODO 可以设定每个子文件的行数
		
		int numCount = 2;// 每个文件的行数
		File file = new File(inFilePath);
		FileInputStream inputStream = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		StringBuffer buffer = new StringBuffer();

		String readerLine = "";
		int line = 0;
		int splitFileIndex = 1;
		while ((readerLine = reader.readLine()) != null) {
			buffer.append(readerLine + " ");
			if (++line % numCount == 0) {
				sortStringBuffer(buffer);// 直接对小文件进行排序
				splitFileIndex = line / numCount;
				write(outFilePath + splitFileIndex + ".txt", buffer.toString());
				buffer.setLength(0);
			}
			if (splitFileIndex * numCount < line && line % numCount != 0) {
				sortStringBuffer(buffer);// 直接对小文件进行排序
				splitFileIndex = line / numCount + 1;
				write(outFilePath + splitFileIndex + ".txt", buffer.toString());
				buffer.setLength(0);
			}
		}

		reader.close();

	}

	// 向文件写数据
	public static void write(String path, String buffer) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, true);
			writer.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	//进行排序，采用快速排序方法
	public static void sortStringBuffer(StringBuffer buffer) {

		String[] numberTexts = buffer.toString().split(" ");
		buffer.setLength(0);
		int[] numbers = new int[numberTexts.length];
		for (int i = 0; i < numberTexts.length; i++) {
			numbers[i] = Integer.parseInt(numberTexts[i]);
		}
		quickSort(numbers, 0, numbers.length - 1);
		for (int i = 0; i < numbers.length; i++) {
			buffer.append(numbers[i] + "\r\n");
		}
	}

	// 合并小文件
	public static void mergeSorted(String dirPath) throws NumberFormatException, IOException {

		File dirFile = new File(dirPath);
		File[] partFiles = dirFile.listFiles();
		int fileNums = partFiles.length;
		FileInputStream[] inputStreams = new FileInputStream[fileNums];
		BufferedReader[] readers = new BufferedReader[fileNums];

		//保存每个子文件最小的数的临时数组
		int[] minNumbers = new int[fileNums];
		// 构建小文件的读写流
		for (int i = 0; i < fileNums; i++) {
			inputStreams[i] = new FileInputStream(partFiles[i]);
			readers[i] = new BufferedReader(new InputStreamReader(inputStreams[i]));
			minNumbers[i] = Integer.parseInt(readers[i].readLine());
		}
		//初始化临时数组的长度
		int numberCount = fileNums;
		String line;
		
		while (true) {
			/*for (int i =0;i<numberCount;i++) {
				System.out.print(minNumbers[i] + " ");
			}*/
			int index = minIndex(minNumbers,numberCount);
			write("E:\\aaa\\outFilePath.txt", minNumbers[index] + "\r\n");
			line = readers[index].readLine();
			
			if (line != null) {
				minNumbers[index] = Integer.parseInt(line);
			} else if(line == null){//如果某个文件读取完了，则把临时数组的长度减少一位
				//System.out.println("-----------------");
				partFiles[index].delete();
				inputStreams[index].close();
				readers[index].close();
				for(int i = index;i<numberCount-1;i++){
					minNumbers[index] = minNumbers[index+1];
					inputStreams[index] = inputStreams[index+1];
					readers[index] = readers[index+1];
				}
				numberCount--;
			}

			if (numberCount <= 0) {
				break;
			}
		}

	}

	//查询最小的数字的下标
	public static int minIndex(int[] a,int l) {
		int t = 0;
		for (int i = 1; i < l; i++) {
			if (a[t] > a[i])
				t = i;
		}
		return t;
	}

	// 快排
	public static int[] quickSort(int[] array, int f, int e) {
		if (f > e)
			return array;
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
		return array;
	}
}
