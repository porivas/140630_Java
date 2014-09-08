package date20140811;

public class FoodStore implements Comparable<FoodStore> {
	
	private String name;
	public FoodStore setName(String name){
		this.name = name;
		return this;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(FoodStore other){
		return this.name.compareTo(other.name);
	}
	

	public boolean equals1(FoodStore obj) {
		// TODO Auto-generated method stub
		return this.name.equals(obj.name);
	}

	@Override
	public String toString() {
		return "FoodStore [name=" + name + "]";
	}

}
