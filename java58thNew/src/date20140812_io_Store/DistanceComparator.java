package date20140812_io_Store;
import java.util.Comparator;

public class DistanceComparator implements Comparator<FoodStore> {
	private double lat;
	private double lng;
	private String name;
	private String menu;
	private String type;

	public DistanceComparator(double lat, double lng, String name, String menu,
			String type) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.menu = menu;
		this.type = type;
	}

	@Override
	public int compare(FoodStore o1, FoodStore o2) {
		double distance1 = o1.calcDistance(this.lat, this.lng);
		double distance2 = o2.calcDistance(this.lat, this.lng);
		return (int) ((distance1 - distance2) * 100000);
	}

}
