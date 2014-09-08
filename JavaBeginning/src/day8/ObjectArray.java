package day8;

public class ObjectArray {
	public static void main(String[] args){
		String[] arr = { new String("Hi"), new String("My"), "name is goopy"};
		for (int i = 0; i< arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		System.out.println();
	}

}
