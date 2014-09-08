package date20140811;

import java.util.Arrays;

public class SortEx {
	public static void main(String[] args) {
		FoodStore[] arr = { new FoodStore().setName("AAA"), 
				new FoodStore().setName("ZCD"),
				new FoodStore().setName("AAA"),
				new FoodStore().setName("CAA")};
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].getName().equals("AAA")){
				arr[i] = arr[i];
			}
			else{
				arr[i] = null;
			}
		}
		System.out.println(Arrays.toString(arr));


	}
}

