package day8;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args){
/*		String[] arr;
		// int i;
		arr = new String[3];
		
		arr[0] = new String("안녕?");
		arr[1] = "친구야";
		arr[2] = "반갑다";
		
		for (int x =0 ; x <arr.length; x++){
			System.out.println(arr[x]);
		}*/
		System.out.print("배열길이 값을 입력하세요:");
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int[] score = new int[i];
		for (int a = 0; a<score.length; a++)
		{
			score[a] = a+11;
			System.out.println((a+1)+"번째 값은"+ score[a]+"입니다." );
		}
		
	}

}
