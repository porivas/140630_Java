package date20140807;

public class Tile {
	private int locattionNum;	// ���ù�ȣ���� ��ġ�� �˷��� (������ ������)
	private String name; // ������ �̸�
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

	// �迭 ���� �� �迭������ ��ҵ��� ���ڿ��� ���
	@Override
	public String toString() {
		return "Tile [locattionNum=" + locattionNum + ", name=" + name + "]";
	}

	// ���� Tile�� �������� ��ĭ���� Status���� ���ؼ� Ȯ��
	// City class������ �� �Լ��� �������̵��Ͽ� ���


	// ���� �̸��� ���ù�ȣ�� ������� �ʴ� ���̹Ƿ� private�� ��������� �ش� ������ �����Ͽ� �� �� �̿��� ������ �����Ƿ� getter, setter���

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
