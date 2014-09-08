package date20140808_food;

public class Restaurant {
	
	private double lng;
	private double lat;
	private String name;
	private String menu;
	private String type;
	private double nearDistance;
	
	public Restaurant(double lng, double lat, String name, String menu,
			String type) {
		super();
		this.lng = lng;
		this.lat = lat;
		this.name = name;
		this.menu = menu;
		this.type = type;
		this.nearDistance = 0;
		}
	


	
	public double getNearDistance() {
		return nearDistance;
	}




	public void setNearDistance(double nearDistance) {
		this.nearDistance = nearDistance;
	}




	public void setLng(double lng) {
		this.lng = lng;
	}




	public void setLat(double lat) {
		this.lat = lat;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setMenu(String menu) {
		this.menu = menu;
	}




	public void setType(String type) {
		this.type = type;
	}




	public double getLng() {
		return lng;
	}




	public double getLat() {
		return lat;
	}




	public String getName() {
		return name;
	}




	public String getMenu() {
		return menu;
	}




	public String getType() {
		return type;
	}

	public double calcDistance(double myLng, double myLat){ //거리구하기
		double distance = Math.pow((myLng - this.lng),2) + Math.pow((myLat - this.lat),2);
		return distance;
	}
	
	

}
