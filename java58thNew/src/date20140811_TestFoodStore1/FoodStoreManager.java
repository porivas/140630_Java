package date20140811_TestFoodStore1;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;

public class FoodStoreManager {
	
	private FoodStore[] stores;

	public FoodStoreManager() {
		this.stores = new FoodStore[10];
		stores [0] = new FoodStore(37.564188, 126.993011, "��Į����", "Į����", "�ѽ�");	
		stores [1] = new FoodStore(37.564503, 126.992636, "���ɺ���", "�Ұ��, ī��, ����丶��", "�ѽ�" );	
		stores [2] = new FoodStore(37.565134, 126.992187, "���𰡸�Į����", "Į����", "�ѽ�");	
		stores [3] = new FoodStore(37.564593, 126.991756, "����Ŀ��", "Ŀ��, �꽺, ����Ŀ��", "����" );	
		stores [4] = new FoodStore(37.563786, 126.991223, "������", "¥���, «��, ������, ������, ������", "�߽�" );	
		stores [5] = new FoodStore(37.564879, 126.989664 , "�谡��", "���, ��ġ������, �쵿, ���", "�н�" );	
		stores [6] = new FoodStore(37.564260, 126.993358, "����«��", "«��, «�͹�, ������", "�߽�" );	
		stores [7] = new FoodStore(37.565788,126.992966, "���뱹����", "����, ����, ���񱹹�, ��������", "�ѽ�" );	
		stores [8] = new FoodStore(37.565330,126.993100 , "��������", "������, ��ġ����, ��⸸��, ���񸸵�, ��븸��, ��������", "�ѽ�" );	
		stores [9] = new FoodStore(37.563490,126.992004, "�������Ѹ���", "�߰���, �����, �ߵ�����, �ݰ���, ���, �߱��� ", "�ѽ�" );	


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


