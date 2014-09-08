package date20140806;

public abstract class Chance {
	
	private String chanceTitle;
	
	public abstract void chanceEvent(Quiz quiz1); //√ﬂªÛ»≠
	
	public Chance(String chanceTitle) {
		this.chanceTitle = chanceTitle;
	}

	@Override
	public String toString() {
		return "Chance [chanceTitle=" + chanceTitle + "]";
	}
	
}
