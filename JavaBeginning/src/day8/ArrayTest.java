package day8;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args){
/*		String[] arr;
		// int i;
		arr = new String[3];
		
		arr[0] = new String("�ȳ�?");
		arr[1] = "ģ����";
		arr[2] = "�ݰ���";
		
		for (int x =0 ; x <arr.length; x++){
			System.out.println(arr[x]);
		}*/
		System.out.print("�迭���� ���� �Է��ϼ���:");
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int[] score = new int[i];
		for (int a = 0; a<score.length; a++)
		{
			score[a] = a+11;
			System.out.println((a+1)+"��° ����"+ score[a]+"�Դϴ�." );
		}
		
	}

}
