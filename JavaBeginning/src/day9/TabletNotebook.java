package day9;

class TabletNotebook extends NotebookComp{
	private String regstPenModel;
	public TabletNotebook(String name, int initChag, String pen){
		super(name, initChag);
		String regstPenModel = pen;
		//		regstPenModel = pen;
	}
	public void write(String penInfo){
		if(batteryCheck() == true){
			if(!regstPenModel.equals(penInfo)){
				System.out.println("��ϵ� ���� �ƴմϴ�.");
			}
			else{
				System.out.println("�ʱ⳻���� ó���մϴ�.");
				useBattery();
			}
		}
	}


}
