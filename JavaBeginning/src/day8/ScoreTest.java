package day8;

import java.util.Scanner;

public class ScoreTest {
	public static void main(String[] args){
		int total =0;
		int size;
		Scanner scan = new Scanner(System.in);
		System.out.print("�迭�� ũ�⸦ �Է��Ͻÿ�:");
		size = scan.nextInt();
		int[] score = new int[size];
		for (int i = 0; i < size; i++){
			System.out.print("������ �Է��Ͻÿ�:");
			score[i] = scan.nextInt();
		}
		for (int i = 0; i<size; i++)
			total += score[i];
		System.out.println("��ռ�����"+ total/size + "�Դϴ�.");

		
// System.out.println("��ռ�����"+ total/size + "�Դϴ�.");

		
	}

}
