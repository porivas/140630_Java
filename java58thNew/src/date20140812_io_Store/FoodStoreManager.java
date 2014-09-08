package date20140812_io_Store;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FoodStoreManager {
	
	private FoodStore[] stores;
	private ArrayList<FoodStore> stores2;
	private FoodStoreDAO textManager;

	public FoodStoreManager() throws Exception {
//		this.stores = new FoodStore[999];
		this.splitText();
		System.out.println("stores Ãâ·Â Å×½ºÆ®");
		System.out.println(Arrays.toString(stores));
//		stores = (FoodStore[]) stores2.toArray();
		
//		stores.add(new FoodStore(37.564188, 126.993011, "¸íµ¿Ä®±¹¼ö", "Ä®±¹¼ö", "ÇÑ½Ä"));
//		stores [0] = new FoodStore(37.564188, 126.993011, "¸íµ¿Ä®±¹¼ö", "Ä®±¹¼ö", "ÇÑ½Ä");	
//		stores [1] = new FoodStore(37.564503, 126.992636, "Á¡½ÉºßÆä", "ºÒ°í±â, Ä«·¹, ¹æ¿ïÅä¸¶Åä", "ÇÑ½Ä" );	
//		stores [2] = new FoodStore(37.565134, 126.992187, "¿À¸ð°¡¸®Ä®±¹¼ö", "Ä®±¹¼ö", "ÇÑ½Ä");	
//		stores [3] = new FoodStore(37.564593, 126.991756, "ÇÑÆòÄ¿ÇÇ", "Ä¿ÇÇ, Áê½º, º£ÀÌÄ¿¸®", "±îÆä" );	
//		stores [4] = new FoodStore(37.563786, 126.991223, "ÇÔÁö¼º", "Â¥Àå¸é, Â«»Í, ººÀ½¹ä, ±º¸¸µÎ, ÅÁ¼öÀ°", "Áß½Ä" );	
//		stores [5] = new FoodStore(37.564879, 126.989664 , "±è°¡³×", "±è¹ä, ±èÄ¡ººÀ½¹ä, ¿ìµ¿, ¶ó¸é", "ºÐ½Ä" );	
//		stores [6] = new FoodStore(37.564260, 126.993358, "³¶¸¸Â«»Í", "Â«»Í, Â«»Í¹ä, ±º¸¸µÎ", "Áß½Ä" );	
//		stores [7] = new FoodStore(37.565788,126.992966, "¼ø´ë±¹¹äÁý", "¼ø´ë, ¼ÒÁÖ, ¿ì»ç°ñ±¹¹ä, µÅÁö±¹¹ä", "ÇÑ½Ä" );	
//		stores [8] = new FoodStore(37.565330,126.993100 , "¸¶Æ÷¸¸µÎ", "±º¸¸µÎ, ±èÄ¡¸¸µÎ, °í±â¸¸µÎ, °¥ºñ¸¸µÎ, ¸ðµë¸¸µÎ, °³¼º¸¸µÎ", "ÇÑ½Ä" );	
//		stores [9] = new FoodStore(37.563490,126.992004, "º»°¡´ßÇÑ¸¶¸®", "´ß°¥ºñ, »ï°èÅÁ, ´ßµµ¸®ÅÁ, ¹Ý°èÅÁ, ¹é¼÷, ´ß±¸ÀÌ ", "ÇÑ½Ä" );	
//		System.out.println(stores.get(0).toString()+"\n"+"Á¤»óÃß°¡µÇ¾ú½À´Ï´Ù.");
	}

	public FoodStore[] findStoresByDistance(double currentLat, double currentLng) {
//		final FoodStoreManager that = this;
		FoodStore[] resultStore = new FoodStore[10];
		
		Arrays.sort(this.stores, new Comparator<FoodStore>(){
			
		 @Override
			public int compare(FoodStore f1, FoodStore f2){
				
//				System.out.println(FoodStoreManager.this.stores);
				return (int)((f1.calcDistance(currentLat, currentLng)-f2.calcDistance(currentLat, currentLng))*100000);			
						
			}
			
			
		});
	

		return this.stores;
	}
	
	public ArrayList splitText() throws Exception{
		stores2 = new ArrayList<FoodStore>();
		textManager = new FoodStoreDAO();
		ArrayList tempList = textManager.LoadData();
		int i=0;
		String str;
		int j = tempList.size();
		stores = new FoodStore[j];
		while (true){
			try{
			str = (String) tempList.get(i);
			String[] parts = str.split(" ");
			stores2.add(new FoodStore(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[2], parts[3], parts[4]));
//			String string = "004-034556";
//			String[] parts = string.split("-");
//			String part1 = parts[0]; // 004
//			String part2 = parts[1]; // 034556
			this.stores[i]= stores2.get(i);
			i++;
			}
			catch(Exception e){
				break;
			}
		}
		return stores2;
	}
//	public FoodStore splitOneText(String tempList) throws Exception{
//		String str;
//		str = tempList;
//		String[] parts = str.split(" ");
//		return new FoodStore(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[2], parts[3], parts[4]);
//	}
	

	public ArrayList<FoodStore> getStores2() {
		return stores2;
	}

	public void setStores2(ArrayList<FoodStore> stores2) {
		this.stores2 = stores2;
	}

	public FoodStore[] findStoresByDistance(final double currentLat, final double currentLng, FoodStore[] currentFoodStoreArr) {
//		final FoodStoreManager that = this;
//		FoodStore[] resultStore = new FoodStore[10];		
		Arrays.sort(currentFoodStoreArr, new Comparator<FoodStore>(){
			
		 @Override
			public int compare(FoodStore f1, FoodStore f2){
				return (int)((f1.calcDistance(currentLat, currentLng)-f2.calcDistance(currentLat, currentLng))*100000);			
			}	
		});
	
		return currentFoodStoreArr;
	}
	
	
	public FoodStore[] findStoresByMenuName(double currentLat, double currentLng, String menuName) {
		int cnt=0;
		for (FoodStore foodStore : stores) {
			if(foodStore.equals(menuName)){
				cnt++;
			}
		}
		FoodStore[] resultStore = new FoodStore[cnt];
		
		int i = 0;
		for (FoodStore foodStore : stores) {
			if(foodStore.equals(menuName)){
				System.out.println(foodStore);
				resultStore[i++] = foodStore;
			}
		}
		return findStoresByDistance(currentLat, currentLng, resultStore);
	}
	
	@Override
	public String toString() {
		return "FoodStoreManager [stores=" + Arrays.toString(stores) + "]";
	}
		

	}


