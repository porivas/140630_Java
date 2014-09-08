package io4Package1;

import java.io.File;
import java.util.Arrays;

public class FileList {
	// bad code
	public static void main(String[] args) throws Exception {
		String dirName = "C:\\zzz\\mp3";
		File mp3Dir = new File(dirName);
		System.out.println(mp3Dir);
		String[] songList = mp3Dir.list();
//		System.out.println(Arrays.toString(songList));
		StringBuilder builder = new StringBuilder();
		for (String i : songList) {
			builder.append(i+"|");
		}
		System.out.println(builder);
		String result = builder.toString();
		String[] arr = result.split("\\|"); // 정규표현식 \\|
		for (String string : arr) {
			System.out.println(string);
		}
		System.out.println("------------");
	}

}
