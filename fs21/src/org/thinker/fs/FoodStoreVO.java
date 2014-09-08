package org.thinker.fs;

public class FoodStoreVO {

	private String name;
	private String menu;
	private Location loc;
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
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	
	@Override
	public String toString() {
		return "FoodStoreVO [name=" + name + ", menu=" + menu + ", loc=" + loc
				+ "]";
	}
	
	
}
