package date20140812_io_Store;
public class FoodStore {
	private double lng;
	private double lat;
	private String name;
	private String menu;
	private String type;
	private double nearDistance;

	public FoodStore(double lng, double lat, String name, String menu,
			String type) {
		super();
		this.lng = lng;
		this.lat = lat;
		this.name = name;
		this.menu = menu;
		this.type = type;
		this.nearDistance = 0;

	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getNearDistance() {
		return nearDistance;
	}

	public void setNearDistance(double nearDistance) {
		this.nearDistance = nearDistance;
	}

	@Override
	public String toString() {
		return "FoodStore [lng=" + lng + ", lat=" + lat + ", name=" + name
				+ ", menu=" + menu + ", type=" + type + ", nearDistance="
				+ nearDistance + "]\n";
	}

	public double calcDistance(double otherLat, double otherLng) {
		double result = Math.sqrt(Math.pow((otherLat - this.lat), 2)
				+ Math.pow((otherLat - this.lng), 2));
		this.nearDistance  = result;
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		return result;
	}

	public boolean equals(String menu) {
		String s = this.menu;
			return (s.matches(".*"+ menu +".*"));
		
	}
	
	
}