package date20140812_io_Store;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodStoreDAO implements IFoodStoreDAO {

	@Override
	public ArrayList LoadData() throws Exception {
		InputStream in = new FileInputStream("c:\\zzz\\FoodStore_MS-DOS_by_WordPad2.txt");
//		System.out.println(in);
		Scanner sc = new Scanner(in);
		ArrayList<String> storeArrayList = new ArrayList<String>();

		while (true) {
			try {
				String strTest = sc.nextLine();
				storeArrayList.add(strTest);
//				System.out.println(strTest);
			} catch (Exception e) {
				break;
			}
		}
		return storeArrayList;
	}

	@Override
	public void SaveData(ArrayList stores) throws Exception {
		// TODO Auto-generated method stub
		String fileRoot = "c:\\zzz\\FoodStore_MS-DOS_by_WordPad2.txt";
		OutputStream out = new FileOutputStream(fileRoot);
		for (int j = 0; j < stores.size(); j++) {
			String storeContent = (String) stores.get(j)+"\n";
			out = new FileOutputStream(fileRoot, true);
			byte[] msgBytes = storeContent.getBytes();
			out.write(msgBytes);
		}
		
	}

	public void addData(double lng, double lat, String name, String menu,
			String type) throws Exception {
		String fileRoot = "c:\\zzz\\FoodStore_MS-DOS_by_WordPad2.txt";

//		Scanner sc = new Scanner(System.in);
		String storeContent = lat+" "+lng+" "+name+" "+menu+" "+type+"\n";
		OutputStream out = new FileOutputStream(fileRoot, true);
		//		String msg = sc.nextLine() + "\n";

		//		while (true) {
		//			
		//			String msg = sc.nextLine() + "\n";
		//
		//			if (msg.equals("EXIT\n")) {
		//				break;
		//			}
		
		byte[] msgBytes = storeContent.getBytes();
		out.write(msgBytes);

	}

}
