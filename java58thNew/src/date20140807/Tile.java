package date20140807;

public class Tile {
	private int locattionNum;	// 도시번호이자 위치를 알려줌 (도시의 고유값)
	private String name; // 도시의 이름
	public int cityStatus;
	public int getCityStatus() {
		return cityStatus;
	}
	
	public void checkCity(int cityStatus, Player player) {
		// TODO Auto-generated method stub

	}
	
	public void setCityStatus(int cityStatus) {
		this.cityStatus = cityStatus;
	}

	// 배열 선언 후 배열내부의 요소들을 문자열로 출력
	@Override
	public String toString() {
		return "Tile [locattionNum=" + locattionNum + ", name=" + name + "]";
	}

	// 현재 Tile이 도시인지 빈칸인지 Status값을 통해서 확인
	// City class에서는 위 함수를 오버라이딩하여 사용


	// 도시 이름과 도시번호는 변경되지 않는 값이므로 private을 사용하지만 해당 값들을 복사하여 비교 및 이용할 여지는 있으므로 getter, setter사용

	public int getLocattionNum() {
		return locattionNum;
	}

	public void setLocattionNum(int locattionNum) {
		this.locattionNum = locattionNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}







}
