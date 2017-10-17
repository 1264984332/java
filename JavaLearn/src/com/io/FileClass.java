package com.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class FileClass {

	public static void main(String[] args) throws IOException {
		testStringReaderWriter();
	}

	public static void testStringReaderWriter() throws IOException {
		String string = "锦瑟无端五十弦，一弦一柱思华年。" + "庄生晓梦迷蝴蝶，望帝春心托杜鹃。" + "沧海月明珠有泪，蓝田日暖玉生烟。" + "此情可待成追忆？只是当时已惘然。";
		try (StringReader reader = new StringReader(string)) {
			char[] buffer = new char[32];
			int count;
			while ((count = reader.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, count));
			}
		}

		System.out.println("************");
		try (StringWriter writer = new StringWriter()) {
			writer.write("昨夜星辰昨夜风，");
			writer.append("画楼西畔桂堂东。");
			writer.append("身无彩凤双飞翼，");
			writer.append("心有灵犀一点通。");
			System.out.println(writer.toString());
		}
	}

	private static void displayFiles(File directory, int depth) {
		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				for (int i = 0; i < depth - 1; ++i) {
					System.out.print("|   ");
				}
				if (depth != 0) {
					System.out.print("|-- ");
				}
				System.out.println(file.getName());

				if (file.isDirectory()) {
					displayFiles(file, depth + 1);
				}
			}
		}
	}
}
