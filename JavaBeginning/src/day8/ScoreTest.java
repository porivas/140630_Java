package day8;

import java.util.Scanner;

public class ScoreTest {
	public static void main(String[] args){
		int total =0;
		int size;
		Scanner scan = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하시오:");
		size = scan.nextInt();
		int[] score = new int[size];
		for (int i = 0; i < size; i++){
			System.out.print("성적을 입력하시오:");
			score[i] = scan.nextInt();
		}
		for (int i = 0; i<size; i++)
			total += score[i];
		System.out.println("평균성적은"+ total/size + "입니다.");

		
// System.out.println("평균성적은"+ total/size + "입니다.");

		
	}

}
